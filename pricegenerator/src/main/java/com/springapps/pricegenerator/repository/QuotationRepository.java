package com.springapps.pricegenerator.repository;

import com.springapps.pricegenerator.model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation,Long> {
    List<Quotation> findAllByUser_IdAndExpireDateAfter(Long userId, LocalDateTime date);
    void deleteAllByExpirationDateBefore(LocalDateTime date);
}
