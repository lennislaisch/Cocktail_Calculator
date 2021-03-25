package de.dhbw.Cocktail_Calculator.presentation;

import de.dhbw.Cocktail_Calculator.core.calculator.model.Zutat;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PreisResponse {
    private String name;
    private double preis;
    private List<Zutat> zutatenliste = new ArrayList<>();
}
