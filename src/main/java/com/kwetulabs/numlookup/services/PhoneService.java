package com.kwetulabs.numlookup.services;

import com.kwetulabs.numlookup.models.Phone;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    public Phone getPhoneDetails(String phoneNumber){
        Phone phone = new Phone();

        var phoneLength = phoneNumber.length();


        if (phoneLength == 9) {
            phone.setNumber("0" + phoneNumber);
            phone.setCountry("Tanzania");
            phone.setFormat("InCountry");
        } else {
            phone.setNumber(phoneNumber);
            phone.setCountry("International");
            phone.setFormat("International");
        }


        return phone;
    }
}
