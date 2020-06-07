package com.company;

abstract class TreeElement
{
    String type;
    int depth;

    public int getDepth()
    {
        return depth;
    }

    public String getType()
    {
        return type;
    }

    abstract void setDepth(int depth);
    abstract double evaluateValue();

    abstract String accept(Visitor visitor);
}
