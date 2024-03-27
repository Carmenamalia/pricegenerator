package com.springapps.pricegenerator.repository;

import com.springapps.pricegenerator.model.CountryDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<CountryDiscount,Long> {

    CountryDiscount findByCountry_IdAndProduct_Id(Long countryId,Long productId);
}
