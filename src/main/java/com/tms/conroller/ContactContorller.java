package com.tms.conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactContorller {
    
    @GetMapping("/contact")
    public String saveContactDetails(){
        return "Inquiry details are saved to the DB";
    }
}
