package de.dhbw.Cocktail_Calculator.core.calculator.model;

import lombok.Data;

@Data
public class Zutat {
    private String name;
    private String menge;
    private double mengeInMl;
    private double einzelpreis;
}
