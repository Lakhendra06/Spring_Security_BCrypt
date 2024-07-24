package com.tms.conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    
    @GetMapping("/myLoans")
    public String getLoanDetails(){
        return "Loan Details";
    }
}
