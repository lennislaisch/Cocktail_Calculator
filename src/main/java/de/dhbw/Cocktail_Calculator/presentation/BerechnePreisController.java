package de.dhbw.Cocktail_Calculator.presentation;

import de.dhbw.Cocktail_Calculator.core.*;
import de.dhbw.Cocktail_Calculator.infrastructure.cocktaildb.CocktailDBClient;
import de.dhbw.Cocktail_Calculator.infrastructure.cocktaildb.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/v1/cocktails")
public class BerechnePreisController {
    @Autowired
    private CalculationService calculationService;

    @Autowired
    private NormierenService normierenService;

    @Autowired
    private ConvertDrinkService convertDrinkService;

    @GetMapping
    public PreisResponse calc(@RequestParam("name") String name) {
        PreisResponse dto = new PreisResponse();
        CocktailDBClient client = new CocktailDBClient();

        Drink drink = client.getData(name).getDrinks().get(2); //für Tommys Margarita

        // Konvertierung von Drink zu Getränk
        Getraenk getraenk = convertDrinkService.convertDrink(drink);
        
        // Getränke-Menge normieren
        normierenService.normiereMengen(getraenk);

        // Preis für Getränk berechnen
        // die Mengen der 3 Zutaten müssen nun mit einem Preis berechnet werden
        System.out.println(getraenk.getZutaten().get(0));
        System.out.println(getraenk.getZutaten().get(1));
        System.out.println(getraenk.getZutaten().get(2));
        // Rückgabe des Preises
        // Der berechnete Preis wird nun über ein PreisResponse Objekt zurückgegeben

        dto.setPreis(calculationService.preisberechnen(getraenk));
        dto.setName(getraenk.getName());
        return dto;
    }




    /*
    @GetMapping(path = "/abc")
    public CocktailDbResponse calc2(@RequestParam("a") String name) {
        CocktailDBClient client = new CocktailDBClient();

        CocktailDbResponse data = client.getData(name);

        String ingredient1 = data.getDrinks().get(0).getStrIngredient1();

        System.out.print(ingredient1);

        return data;
    }
    */
}
