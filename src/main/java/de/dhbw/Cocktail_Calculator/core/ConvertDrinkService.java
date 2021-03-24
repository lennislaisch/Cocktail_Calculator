package de.dhbw.Cocktail_Calculator.core;


import de.dhbw.Cocktail_Calculator.infrastructure.cocktaildb.Drink;
import org.springframework.stereotype.Service;

@Service
public class ConvertDrinkService {
        public Getraenk convertDrink(Drink drink) {

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
}
