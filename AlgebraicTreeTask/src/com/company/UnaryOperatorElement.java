package com.company;

class UnaryOperatorElement extends TreeElement
{
    final private String operator;
    private TreeElement child;

    public UnaryOperatorElement(String operator)
    {
        this.type = "unary";
        this.operator = operator;
        child = null;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setDepth(int depth)
    {
        this.depth = depth;
        child.setDepth(depth+1);
    }

    public void setChild(TreeElement new_child)
    {
        child = new_child;
    }

    public TreeElement getChild()
    {
        return child;
    }

    public double evaluateValue()
    {
        double value = 0;
        if (operator.equals("sin"))
        {
            value = Math.sin(child.evaluateValue());
        }
        else if (operator.equals("cos"))
        {
            value = Math.cos(child.evaluateValue());
        }

        return value;
    }

    public String accept(Visitor visitor)
    {
       return visitor.visit(this);
    }

    public static boolean validOperator(String operator)
    {
        boolean valid = false;
        if ((operator.equals("sin"))||(operator.equals("cos")))
        {
            valid = true;
        }

        return valid;
    }
}
