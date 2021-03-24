package de.dhbw.Cocktail_Calculator.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import java.io.IOException;
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
