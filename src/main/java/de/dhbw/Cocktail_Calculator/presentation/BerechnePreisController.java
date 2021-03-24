package de.dhbw.Cocktail_Calculator.presentation;

import de.dhbw.Cocktail_Calculator.core.Getraenk;
import de.dhbw.Cocktail_Calculator.core.Zutat;
import de.dhbw.Cocktail_Calculator.infrastructure.cocktaildb.CocktailDBClient;
import de.dhbw.Cocktail_Calculator.infrastructure.cocktaildb.Drink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/v1/cocktails")
public class BerechnePreisController {

    @GetMapping
    public PreisResponse calc(@RequestParam("name") String name) {
        CocktailDBClient client = new CocktailDBClient();

        Drink drink = client.getData(name).getDrinks().get(2); //für Tommys Margarita

        // Konvertierung von Drink zu Getränk
        Getraenk getraenk = convertDrink(drink);
        
        // Getränke-Menge normieren
        normiereMengen(getraenk);

        // Preis für Getränk berechnen
        // die Mengen der 3 Zutaten müssen nun mit einem Preis berechnet werden
        System.out.println(getraenk.getZutaten().get(0));
        System.out.println(getraenk.getZutaten().get(1));
        System.out.println(getraenk.getZutaten().get(2));
        // Rückgabe des Preises
        // Der berechnete Preis wird nun über ein PreisResponse Objekt zurückgegeben


        Drink calculate = new Drink();

        return new PreisResponse();
    }

    private void normiereMengen(Getraenk getraenk) {
        for (Zutat z : getraenk.getZutaten()) {
            String mengeStr = z.getMenge();

            if (mengeStr.endsWith("cl")) {
                int indexOfEinheit = mengeStr.indexOf("cl");   //"4.5 cl"    // "1\/2 tsp "
                mengeStr = mengeStr.substring(0, indexOfEinheit).trim();
                //mengeStr = mengeStr.replaceAll("\\/", "");

                Double mengeDouble = Double.valueOf(mengeStr);
                double inMilliliter = mengeDouble * 5;

                z.setMengeInMl(inMilliliter);
            } else if (mengeStr.endsWith("spoons")) {
                int indexOfEinheit = mengeStr.indexOf("spoons");
                mengeStr = mengeStr.substring(0, indexOfEinheit).trim();

                Double mengeDouble = Double.valueOf(mengeStr);
                double inMilliliter = mengeDouble * 5;

                z.setMengeInMl(inMilliliter);
            }
        }

    }

    private Getraenk convertDrink(Drink drink) {
        Getraenk g = new Getraenk();
        g.setName(drink.getStrDrink());

        Zutat zutat1 = new Zutat();
        zutat1.setName(drink.getStrIngredient1());
        zutat1.setMenge(drink.getStrMeasure1().trim());
        g.getZutaten().add(zutat1);

        Zutat zutat2 = new Zutat();
        zutat2.setName(drink.getStrIngredient2());
        zutat2.setMenge(drink.getStrMeasure2().trim());
        g.getZutaten().add(zutat2);

        Zutat zutat3 = new Zutat();
        zutat3.setName(drink.getStrIngredient3());
        zutat3.setMenge(drink.getStrMeasure3().trim());
        g.getZutaten().add(zutat3);

        return g;        //gibt ein Getranke-Objekt g zurück dessen Liste<Zutat> mit 3 Zutaten gefüllt wird
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
