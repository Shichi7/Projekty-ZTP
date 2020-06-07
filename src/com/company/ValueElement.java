package com.company;

class ValueElement extends TreeElement
{
    private double value;

    public void setDepth(int depth)
    {
        this.depth = depth;
    }

    public void setValue(String value)
    {
        this.type = "value";
        this.value = Double.parseDouble(value);
    }

    public double evaluateValue()
    {
        return value;
    }

    public String accept(Visitor visitor)
    {
        return visitor.visit(this);
    }
}
