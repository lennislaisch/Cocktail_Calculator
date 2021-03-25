package de.dhbw.Cocktail_Calculator.core;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class NormierenService {
    public void normiereMengen(Getraenk getraenk) {

        for (Zutat z : getraenk.getZutaten()) {
            String mengeStr = z.getMenge();


                //Umwandlung cl in Milliliter
            if (mengeStr.endsWith("cl")) {
                int indexOfEinheit = mengeStr.indexOf("cl");   //"4.5 cl"           //Schneidet cl vom String ab
                mengeStr = mengeStr.substring(0, indexOfEinheit).trim();


                Double mengeDouble = Double.valueOf(mengeStr);
                double inMilliliter = mengeDouble * 10;

                z.setMengeInMl(inMilliliter);


                //Umwandlung spoon in Milliliter
            } else if (mengeStr.endsWith("spoons")) {
                int indexOfEinheit = mengeStr.indexOf("spoons");                //Schneidet spoon vom String ab
                mengeStr = mengeStr.substring(0, indexOfEinheit).trim();

                Double mengeDouble = Double.valueOf(mengeStr);
                double inMilliliter = mengeDouble * 15;

                z.setMengeInMl(inMilliliter);
            }
        }

    }
}
