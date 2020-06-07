package com.company;

class BinaryOperatorElement extends TreeElement
{
    final private String operator;
    private TreeElement first_child;
    private TreeElement second_child;

    public BinaryOperatorElement(String operator)
    {
        this.type = "binary";
        this.operator = operator;
        first_child = null;
        second_child = null;
    }

    public void setDepth(int depth)
    {
        this.depth = depth;
        first_child.setDepth(depth+1);
        second_child.setDepth(depth+1);
    }

    public void setChild(TreeElement new_child)
    {
        if (first_child!=null)
        {
            second_child = new_child;
        }
        else
        {
            first_child = new_child;
        }
    }

    public TreeElement getFirstChild()
    {
        return first_child;
    }

    public TreeElement getSecondChild()
    {
        return second_child;
    }

    public double evaluateValue()
    {
        double value = 0;
        switch(operator)
        {
            case "+":
                value = second_child.evaluateValue() + first_child.evaluateValue();
                break;
            case "-":
                value = second_child.evaluateValue() - first_child.evaluateValue();
                break;
            case "*":
                value = second_child.evaluateValue() * first_child.evaluateValue();
                break;
            case "/":
                value = second_child.evaluateValue() / first_child.evaluateValue();
                break;
        }

        return value;
    }

    public String getOperator()
    {
        return operator;
    }

    public String accept(Visitor visitor)
    {
        return visitor.visit(this);
    }

    public static boolean validOperator(String operator)
    {
        boolean valid = false;
        if ((operator.equals("+"))||(operator.equals("-"))||(operator.equals("/"))||(operator.equals("*")))
        {
            valid = true;
        }

        return valid;
    }
}
