package com.springapps.pricegenerator.service;

import com.springapps.pricegenerator.model.*;
import com.springapps.pricegenerator.repository.DiscountRepository;
import com.springapps.pricegenerator.repository.ProductRepository;
import com.springapps.pricegenerator.repository.QuotationRepository;
import com.springapps.pricegenerator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuotationService {

    private UserRepository userRepository;
    private ProductRepository productRepository;
    private UserService userService;
    private DiscountRepository discountRepository;
    private QuotationRepository quotationRepository;

    @Autowired
    public QuotationService(UserRepository userRepository, ProductRepository productRepository,QuotationRepository quotationRepository, UserService userService, DiscountRepository discountRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.userService = userService;
        this.discountRepository = discountRepository;
        this.quotationRepository = quotationRepository;
    }

    //Dacă vârsta clientului este mai mare decât un prag stabilit pentru produsul pe care vrea să îl cumpere,
    // atunci se aplică o reducere de 20% față de prețul de listă al produsului.
    // Dacă nu, cotația rămâne egală cu prețul inițial.
    @Transactional
    public Quotation generateQuotation(Long productId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("product not found"));
        Quotation quotation = new Quotation();
        if (userService.getUserAge(user) >= product.getAgeDiscountThreshold()) {
            quotation.setAgeDiscount(product.getBasePrice() * 0.2);
        }
        Country country = user.getCountry();
        CountryDiscount countryDiscount = discountRepository.findByCountry_IdAndProduct_Id(country.getId(), product.getId());
        quotation.setCountryDiscount(product.getBasePrice() * countryDiscount.getDiscountValue() / 100);
        quotation.setExpireDate(LocalDateTime.now().plusMinutes(5));
        quotation.setProduct(product);
        quotation.setUser(user);
        quotation.setPrice(product.getBasePrice() - quotation.getAgeDiscount() - quotation.getCountryDiscount());
        return quotationRepository.save(quotation);
    }

    public List<Quotation> getActiveQuotation(Long userId){
        return quotationRepository.findAllByUser_IdAndExpireDateAfter(userId,LocalDateTime.now());
    }
}
