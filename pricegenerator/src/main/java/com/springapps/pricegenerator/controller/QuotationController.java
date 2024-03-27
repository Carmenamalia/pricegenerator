package com.springapps.pricegenerator.controller;

import com.springapps.pricegenerator.model.Quotation;
import com.springapps.pricegenerator.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotation")
public class QuotationController {

    private QuotationService quotationService;

    @Autowired
    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @PostMapping("/{productId}/{userId}")
    public ResponseEntity<Quotation> generateQuotation(@PathVariable Long productId, @PathVariable Long userId){
          Quotation generateQuotation = quotationService.generateQuotation(productId,userId);
          return ResponseEntity.ok(generateQuotation);
    }
}
