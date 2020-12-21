package ingredient.mainpackage;

public class Ingredient
{
    String name;
    int amount;

    public Ingredient(String name, int amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getString()
    {
        return name + ", amount: ["+amount+"]g\n";
    }
}
