package com.springapps.pricegenerator.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference("countries-users")
    private List<User> users;
    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("countries-countryDiscounts")
    private List<CountryDiscount> countryDiscounts;

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<CountryDiscount> getCountryDiscounts() {
        return countryDiscounts;
    }

    public void setCountryDiscounts(List<CountryDiscount> countryDiscounts) {
        this.countryDiscounts = countryDiscounts;
    }
}
