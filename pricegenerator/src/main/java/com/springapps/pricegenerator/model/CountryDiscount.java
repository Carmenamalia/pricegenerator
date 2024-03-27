package com.springapps.pricegenerator.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class CountryDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double discountValue;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference("products-countryDiscounts")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference("countries-countryDiscounts")
    private Country country;

    public CountryDiscount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
