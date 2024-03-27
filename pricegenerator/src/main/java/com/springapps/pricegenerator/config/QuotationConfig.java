package com.springapps.pricegenerator.config;

import com.springapps.pricegenerator.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class QuotationConfig {
    private QuotationRepository quotationRepository;

    @Autowired
    public QuotationConfig(QuotationRepository quotationRepository) {
        this.quotationRepository = quotationRepository;
    }

    //programeaza metoda pt a rula la intervale regulate
    @Scheduled(cron = "0 0 * * * *")
    public void deleteExpiredEntities() {
        quotationRepository.deleteAllByExpirationDateBefore(LocalDateTime.now());
    }
}

