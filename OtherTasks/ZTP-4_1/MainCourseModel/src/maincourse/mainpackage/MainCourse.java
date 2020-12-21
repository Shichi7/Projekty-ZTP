package maincourse.mainpackage;

import ingredient.mainpackage.Ingredient;

public class MainCourse {
    double price;
    String name;
    boolean vegan;
    Ingredient allergen  = null;

    MainCourse(double price, String name, boolean vegan) {
        this.price = price;
        this.name = name;
        this.vegan = vegan;
    }

    public String getString()
    {
        String description = "Name: "+name+"\n";
        description += "Price: "+price+" zł\n";
        description += "Vegan: " + (vegan ? "yes" : "no") + "\n";
        description += allergen != null ? "Alergen: " + allergen.getString() : "";


        return description;
    }

    public void addAllergen(Ingredient allergen)
    {
        this.allergen = allergen;
    }

}

