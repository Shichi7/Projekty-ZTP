package com.company;

class Main {

    public static void main(String[] args) {
        //ONP - ODWROTNA NOTACJA POLSKA

        String onp_equation;

        //onp_equation = "2.5 3 + sin"; // sin(2.5 + 3)
        onp_equation = "3.5 4 + 5.1 sin * 4 2 / - 9 cos +"; //(3.5 + 4) * sin(5.1) - 4/2 + cos(9)
        //onp_equation = "4 2 5 *";  //błędne równanie

        testEquation(onp_equation);
    }

    private static void testEquation(String onp_equation) {
        Tree equation = new Tree();

        equation.createTreeFromString(onp_equation);
        if (equation.created())
        {
            equation.printTree();
            equation.evaluate();
        }
    }
}
