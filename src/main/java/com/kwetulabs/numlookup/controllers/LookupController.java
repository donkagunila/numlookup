package com.kwetulabs.numlookup.controllers;

import com.kwetulabs.numlookup.responses.ResponseHandler;
import com.kwetulabs.numlookup.services.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class LookupController {

    private final PhoneService phoneService;

    public LookupController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("lookup")
    public ResponseEntity<Object> getNumDetails(@RequestParam String number){

        if(number.length() < 9){
            return ResponseHandler.generateErrorResponse("Invalid Phone Number", HttpStatus.BAD_REQUEST, "Invalid Phone Number Length");
        }
        var phoneDetails = phoneService.getPhoneDetails(number);
        return ResponseHandler.generateResponse("Numlookup", HttpStatus.OK, phoneDetails);
    }
}
