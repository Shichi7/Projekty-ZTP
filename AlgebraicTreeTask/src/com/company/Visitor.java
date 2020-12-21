package com.company;

import java.util.Arrays;

class Visitor
{
    public String visit(BinaryOperatorElement element)
    {
        int depth = element.getDepth();

        String node_string = "";
        node_string += generateFrontSpaces(depth - 1)+ "{\n";
        node_string += generateFrontSpaces(depth)+ "type: \"" + element.getType() +"\",\n";
        node_string += generateFrontSpaces(depth)+ "depth: "+ depth+",\n";
        node_string += generateFrontSpaces(depth)+ "operator: \""+element.getOperator()+"\",\n";
        node_string += generateFrontSpaces(depth)+ "first_child: \n"+ element.getFirstChild().accept(this);
        node_string += generateFrontSpaces(depth)+ "second_child: \n"+ element.getSecondChild().accept(this);
        node_string += generateFrontSpaces(depth - 1)+ "}\n";

        return node_string;
    }

    public String visit(UnaryOperatorElement element)
    {
        int depth = element.getDepth();

        String node_string = "";
        node_string += generateFrontSpaces(depth - 1)+ "{\n";
        node_string += generateFrontSpaces(depth)+ "type: \"" + element.getType() +"\",\n";
        node_string += generateFrontSpaces(depth)+ "depth: "+ depth+",\n";
        node_string += generateFrontSpaces(depth)+ "operator: \""+element.getOperator()+"\",\n";
        node_string += generateFrontSpaces(depth)+ "child: \n"+ element.getChild().accept(this);
        node_string += generateFrontSpaces(depth - 1)+ "}\n";

        return node_string;
    }

    public String visit(ValueElement element)
    {
        int depth = element.getDepth();

        String node_string = "";
        node_string += generateFrontSpaces(depth - 1)+ "{\n";
        node_string += generateFrontSpaces(depth)+ "type: \"" + element.getType() +"\",\n";
        node_string += generateFrontSpaces(depth)+ "depth: "+ depth+",\n";
        node_string += generateFrontSpaces(depth)+ "value: "+element.evaluateValue()+",\n";
        node_string += generateFrontSpaces(depth - 1)+ "}\n";

        return node_string;
    }

    private String generateFrontSpaces(int depth)
    {
        char space = ' ';
        int count = 3*depth;

        char[] repeat = new char[count];
        Arrays.fill(repeat, space);

        return new String(repeat);
    }
}
