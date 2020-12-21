package com.company;

public class ArgumentData {

    public String name;
    public String access;
    public String type;

    public boolean isCorrect()
    {
        boolean flag = false;
        if ((!name.equals(""))&&(!access.equals(""))&&(!type.equals("")))
        {
            flag = true;
        }
        return flag;
    }
}
