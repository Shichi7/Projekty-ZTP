package maincourse.mainpackage;

import ingredient.mainpackage.Ingredient;

import java.util.ArrayList;

public class MainCoursesHolder
{
    public ArrayList<MainCourse> dishes = new ArrayList<>();

    public MainCoursesHolder()
    {
        dishes.add(new MainCourse(12.50, "Futomaki Łosoś Pieczony", false));
        dishes.add(new MainCourse(20.00, "Zupa Curry z Cukinią", true));
        dishes.add(new MainCourse(24.00, "Schab Kujawski", false));
    }

    public String getString()
    {
        String description = "Menu:\n\n";
        for (MainCourse dish : dishes)
        {
            description+= dish.getString()+"\n";
        }
        return description;
    }

    public void addIngredientAtIndex(Ingredient allergen, int index)
    {
        dishes.get(index).addAllergen(allergen);
    }
}
