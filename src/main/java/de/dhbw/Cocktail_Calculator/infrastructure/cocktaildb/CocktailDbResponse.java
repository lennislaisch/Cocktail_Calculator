package de.dhbw.Cocktail_Calculator.infrastructure.cocktaildb;

import de.dhbw.Cocktail_Calculator.infrastructure.cocktaildb.Drink;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CocktailDbResponse {
    private List<Drink> drinks;
}
