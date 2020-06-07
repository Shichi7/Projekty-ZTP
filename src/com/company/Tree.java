package com.company;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

class Tree
{
    private TreeElement top_element = null;
    private String original_string = "";

    public void evaluate()
    {
        String evaluation = "Tree evaluation:\n["+original_string+"] = [" + top_element.evaluateValue()+"]";
        System.out.println(evaluation);
    }

    public void printTree()
    {
        String tree_json = "\nJSON Equation Tree dump:\n" + top_element.accept(new Visitor());

        System.out.println(tree_json);
    }

    public boolean created()
    {
        return top_element != null;
    }

    public void createTreeFromString(String new_expression)
    {
        Stack<TreeElement> organizer = new Stack<>();
        original_string = new_expression;

        String[] expressions_list = new_expression.split(" ");

        try
        {
            for(String expression : expressions_list)
            {
                TreeElement new_node;

                if (UnaryOperatorElement.validOperator(expression))
                {
                    UnaryOperatorElement new_node_temp = new UnaryOperatorElement(expression);
                    new_node_temp.setChild(organizer.pop());
                    new_node = new_node_temp;
                }
                else if (BinaryOperatorElement.validOperator(expression))
                {
                    BinaryOperatorElement new_node_temp = new BinaryOperatorElement(expression);
                    new_node_temp.setChild(organizer.pop());
                    new_node_temp.setChild(organizer.pop());
                    new_node = new_node_temp;
                }
                else
                {
                    ValueElement new_node_temp = new ValueElement();
                    new_node_temp.setValue(expression);
                    new_node = new_node_temp;
                }
                organizer.push(new_node);
            }

            if (organizer.size() == 1)
            {
                top_element = organizer.pop();
                top_element.setDepth(1);
            }
            else
            {
                throw new IOException("Bad expression!");
            }
        }
        catch(IOException | EmptyStackException | NumberFormatException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
