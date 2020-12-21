package com.company;

public class SpecialsData
{
    boolean allprivate = false;
    boolean singleton = false;
    boolean builder = false;
    boolean getters = false;
    boolean setters = false;

    public boolean setNewSpecial(String special)
    {
        boolean correct_special = true;
        if (special.equals("allprivate")) allprivate = true;
        else if (special.equals("singleton"))
        {
            if (builder) correct_special = false;
            else singleton = true;
        }
        else if (special.equals("builder"))
        {
            if (singleton) correct_special = false;
            else builder = true;
        }
        else if (special.equals("getters")) getters = true;
        else if (special.equals("setters")) setters = true;
        else
        {
            correct_special = false;
        }
        return correct_special;
    }
}
