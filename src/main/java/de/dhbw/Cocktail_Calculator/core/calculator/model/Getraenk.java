package de.dhbw.Cocktail_Calculator.core.calculator.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.*;



@Data
public class Getraenk {
	private int kosten=0;
	private String name = "";

	@Singular
	private List<Zutat> zutaten = new ArrayList<>();

}
