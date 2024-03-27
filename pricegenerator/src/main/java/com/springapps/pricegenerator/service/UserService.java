package com.springapps.pricegenerator.service;

import com.springapps.pricegenerator.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserService {

    public Integer getUserAge(User user){
      return   Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();
    }
}
