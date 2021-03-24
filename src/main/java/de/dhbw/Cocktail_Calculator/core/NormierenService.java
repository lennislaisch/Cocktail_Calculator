package de.dhbw.Cocktail_Calculator.core;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class NormierenService {
    public void normiereMengen(Getraenk xy) {
        Getraenk getraenk = xy;
        for (Zutat z : getraenk.getZutaten()) {
            String mengeStr = z.getMenge();

            if (mengeStr.endsWith("cl")) {
                int indexOfEinheit = mengeStr.indexOf("cl");   //"4.5 cl"    // "1\/2 tsp "
                mengeStr = mengeStr.substring(0, indexOfEinheit).trim();
                //mengeStr = mengeStr.replaceAll("\\/", "");

                Double mengeDouble = Double.valueOf(mengeStr);
                double inMilliliter = mengeDouble * 10;

                z.setMengeInMl(inMilliliter);
            } else if (mengeStr.endsWith("spoons")) {
                int indexOfEinheit = mengeStr.indexOf("spoons");
                mengeStr = mengeStr.substring(0, indexOfEinheit).trim();

                Double mengeDouble = Double.valueOf(mengeStr);
                double inMilliliter = mengeDouble * 15;

                z.setMengeInMl(inMilliliter);
            }
        }

    }
}
