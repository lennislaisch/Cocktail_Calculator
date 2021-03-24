package de.dhbw.Cocktail_Calculator.core;

import de.dhbw.Cocktail_Calculator.infrastructure.cocktaildb.Drink;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    public double preisberechnen(Getraenk getraenk) {
        double preis = 0;

        for (Zutat z : getraenk.getZutaten())
            switch(z.getName()){                    //hätte auch bpsw. Repository anlegen können und über SQL Zutatendaten einfügen können
                case "Tequila":                     //Preis für Flasche 700ml Tequila   13.00€
                  preis = preis + (13.00 / 700) * z.getMengeInMl();
                  System.out.println(preis);
                    break;
                case "Lime Juice":                  //Preis für Flasche 500ml Limettensaft 2.00€
                    preis = preis + (2.00 / 500) * z.getMengeInMl();
                    System.out.println(preis);
                    break;
                case "Agave syrup":                 //Preis für Flasche 350ml Agaven syrup 3.50€
                    preis = preis + (3.50/350) * z.getMengeInMl();
                    System.out.println(preis);
                    break;
                default:
                    System.out.println("Keine Preisangaben zu dieser Zutat");
                    break;
            }
        preis = Math.round(preis * 100.0) / 100.0;  //
        return preis;
    }

/*
    public int mlAngabe(String name_Zutat, String menge_Zutat){

        if (name_Zutat.equals("Grapefruit juice")
                || name_Zutat.equals("Cranberry juice ")
                || name_Zutat.equals("Grenadine ")
                || name_Zutat.equals("Orange juice ")
                || name_Zutat.equals("Pineapple ")
                || name_Zutat.equals("Coca-Cola ")
                || name_Zutat.equals("Light cream ")
                || name_Zutat.equals("Nutmeg ")) {
            return 200;
        } else {
            return mlAngabeKonvertiert(menge_Zutat);
        }


    }*/
/*
    public int mlAngabeKonvertiert(String menge_Zutat) {

        switch (menge_Zutat) {
            case "1\\/8 oz ":
                return 4;
            ;
            case "1\\/4 oz ":
                return 7;
            case "1\\/2 oz ":
                return 14;
            case "3\\/4 oz ":
                return 21;
            case "1 oz ":
                return 28;
            case "1 1\\/4 oz ":
                return 35;
            case "1 1\\/2 oz ":
                return 42;
            case "1 3\\/4 oz ":
                return 49;
            case "2 oz ":
                return 56;
            case "2 1\\/2 oz ":
                return 56;
            case "3 oz ":
                return 85;
            case "4 oz ":
                return 113;
            case "5 oz ":
                return 142;
            case "6 oz ":
                return 170;
            case "7 oz ":
                return 198;
            case "8 oz ":
                return 227;
            case "9 oz ":
                return 255;
            case "10 oz ":
                return 283;
            case "2-4 ":
                return 10;
            case "1 tsp ":
                return 10;
            case "1\/2 tsp ":
                return 10;
            case "2 tsp ":
                return 20;
            case "3 tsp ":
                return 30;
            case "4 tsp ":
                return 40;
            case "1 tblsp ":
                return 15;
            case "2 tblsp ":
                return 30;
            case "3 tblsp ":
                return 45;
            case "4.5 cL ":
                return 45;
            case "1 cube ":
                return 5;
            case "1 dashe ":
                return 2;
            case "dashe ":
                return 2;
            case "2 dashes ":
                return 4;
            case "2-3 drops ":
                return 4;
            case "1 spash ":
                return 100;
            case "2 measures ":
                return 60;
            case "1 wedge ":
                return 4;
            case "1 ":
                return 6;
            case "1\\/4 cup ":
                return 6;
            case "Juice of 1\\/2 ":
                return 50;
            case "1\\/2 slice ":
                return 50;
            case "Twist of ":
                return 4;
            case "1 twist of ":
                return 6;
            default:
                return 0;
        }
    }*/
}
