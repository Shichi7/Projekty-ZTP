package menu.mainpackage;

import ingredient.mainpackage.Ingredient;
import maincourse.mainpackage.MainCoursesHolder;

public class Main
{

    public static void main(String[] args)
    {
        MainCoursesHolder courses_holder = new MainCoursesHolder();

        System.out.print(courses_holder.getString());

        Ingredient ingredient = new Ingredient("peanuts", 10);
        courses_holder.addIngredientAtIndex(ingredient, 1);

        System.out.print(courses_holder.getString());

    }

}
