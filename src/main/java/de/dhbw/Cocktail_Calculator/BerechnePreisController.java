package de.dhbw.Cocktail_Calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/v1/cocktails")
public class BerechnePreisController {

    @GetMapping
    public CocktailDbResponse calc(@RequestParam("name") String name) {
        CocktailDBClient client = new CocktailDBClient();

        CocktailDbResponse data = client.getData(name);

        Drink calculate = new Drink();

        //speichern der Ingredients im Drink-Object
        calculate.setStrIngredient1(data.getDrinks().get(0).getStrIngredient1());
        calculate.setStrIngredient2(data.getDrinks().get(0).getStrIngredient2());
        calculate.setStrIngredient3(data.getDrinks().get(0).getStrIngredient3());
        calculate.setStrIngredient4(data.getDrinks().get(0).getStrIngredient4());
        calculate.setStrIngredient5(data.getDrinks().get(0).getStrIngredient5());
        calculate.setStrIngredient6(data.getDrinks().get(0).getStrIngredient6());
        calculate.setStrIngredient7(data.getDrinks().get(0).getStrIngredient7());
        calculate.setStrIngredient8(data.getDrinks().get(0).getStrIngredient8());

        calculate.setStrMeasure1(data.getDrinks().get(0).getStrMeasure1());
        calculate.setStrMeasure2(data.getDrinks().get(0).getStrMeasure2());
        calculate.setStrMeasure3(data.getDrinks().get(0).getStrMeasure3());
        calculate.setStrMeasure4(data.getDrinks().get(0).getStrMeasure4());
        calculate.setStrMeasure5(data.getDrinks().get(0).getStrMeasure5());
        calculate.setStrMeasure6(data.getDrinks().get(0).getStrMeasure6());
        calculate.setStrMeasure7(data.getDrinks().get(0).getStrMeasure7());
        calculate.setStrMeasure8(data.getDrinks().get(0).getStrMeasure8());

        //falls Zeit ist noch  einbauen das bei Null das ingredient nicht ausgegeben wird
        if (calculate.getStrIngredient1() != null){System.out.println("Du benötigst " + calculate.getStrMeasure1() + " von " + calculate.getStrIngredient1());}
        if (calculate.getStrIngredient2() != null)System.out.println("Du benötigst " + calculate.getStrMeasure2() + " von " + calculate.getStrIngredient2());
        if (calculate.getStrIngredient3() != null)System.out.println("Du benötigst " + calculate.getStrMeasure3() + " von " + calculate.getStrIngredient3());
        if (calculate.getStrIngredient4() != null)System.out.println("Du benötigst " + calculate.getStrMeasure4() + " von " + calculate.getStrIngredient4());
        if (calculate.getStrIngredient5() != null)System.out.println("Du benötigst " + calculate.getStrMeasure5() + " von " + calculate.getStrIngredient5());
        if (calculate.getStrIngredient6() != null)System.out.println("Du benötigst " + calculate.getStrMeasure6() + " von " + calculate.getStrIngredient6());
        if (calculate.getStrIngredient7() != null)System.out.println("Du benötigst " + calculate.getStrMeasure7() + " von " + calculate.getStrIngredient7());
        if (calculate.getStrIngredient8() != null)System.out.println("Du benötigst " + calculate.getStrMeasure8() + " von " + calculate.getStrIngredient8());

        return data;
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
