package com.springapps.pricegenerator.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double basePrice;
    private String name;

    private Integer ageDiscountThreshold;
    private Integer stock;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("products-quotations")
    private List<Quotation> quotationList;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("products-countryDiscounts")
    private List<CountryDiscount> countryDiscountList;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAgeDiscountThreshold() {
        return ageDiscountThreshold;
    }

    public void setAgeDiscountThreshold(Integer ageDiscountThreshold) {
        this.ageDiscountThreshold = ageDiscountThreshold;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<Quotation> getQuotationList() {
        return quotationList;
    }

    public void setQuotationList(List<Quotation> quotationList) {
        this.quotationList = quotationList;
    }

    public List<CountryDiscount> getCountryDiscountList() {
        return countryDiscountList;
    }

    public void setCountryDiscountList(List<CountryDiscount> countryDiscountList) {
        this.countryDiscountList = countryDiscountList;
    }
}
