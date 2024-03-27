package com.springapps.pricegenerator.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime expireDate;
    private Double ageDiscount;
    private Double price;
    private Double countryDiscount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("users-quotations")
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference("orders-quotations")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference("products-quotations")
    private Product product;

    public Quotation() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public Double getAgeDiscount() {
        return ageDiscount;
    }

    public void setAgeDiscount(Double ageDiscount) {
        this.ageDiscount = ageDiscount;
    }

    public Double getCountryDiscount() {
        return countryDiscount;
    }

    public void setCountryDiscount(Double countryDiscount) {
        this.countryDiscount = countryDiscount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
