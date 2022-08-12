package com.kwetulabs.numlookup.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Phone {

    public String number;
    public String country;
    public String format;

}
