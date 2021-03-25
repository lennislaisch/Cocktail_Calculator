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
    public PreisResponse calc(@RequestParam("name") String name) {                          //api/v1/cocktails?name=
        PreisResponse dto = new PreisResponse();                                            //dto ist glaub doppelt gemoppelt aber, es funktioniert
        CocktailDBClient client = new CocktailDBClient();

        Drink drink = client.getData(name).getDrinks().get(2);                              //funktioniert aktuell nur für Margarita

        // Konvertierung von Drink zu Getränk
        Getraenk getraenk = convertDrinkService.convertDrink(drink);
        
        // Getränke-Menge normieren
        normierenService.normiereMengen(getraenk);




        // Preis für Getränk und Zutaten berechnen
        dto.setPreis(calculationService.preisberechnen(getraenk));
        dto.setName(getraenk.getName());
        dto.setZutatenliste(getraenk.getZutaten());

        // Rückgabe der Preise
        // Der berechnete Preise werden nun über ein PreisResponse Objekt zurückgegeben
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
