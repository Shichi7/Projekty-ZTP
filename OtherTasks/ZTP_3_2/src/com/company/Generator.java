package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generator
{
    private static Logger logger = Logger.getLogger(Generator.class.getName());
    String loaded_data;
    int string_pos;
    ArrayList<ArgumentData> argument_data;
    SpecialsData specials_data;

    String class_name;
    String filename;

    public Generator()
    {
        //PRZYKLAD #1 STRATEGII WYJĄTKÓW GDZIE
        //W PRZYPADKU WYSTĄPIENIA WYJĄTKU WYKONYWANA JEST PEWNA
        //AKCJA DOMYŚLNA (W TYM WYPADKU DODANIE CONSOLE HANDLER'A)
        try
        {
            logger.setUseParentHandlers(false);
            logger.addHandler(new FileHandler("logger.log",true));
            logger.setLevel(Level.ALL);
        }
        catch(IOException e)
        {
            logger.addHandler(new ConsoleHandler());
        }
    }

    private void resetGenerator(String filename)
    {
        this.filename = filename;
        argument_data = new ArrayList<>();
        specials_data = new SpecialsData();

        string_pos = 0;
    }

    public void generatorManager(String filename)
    {
        resetGenerator(filename);

        boolean data_loaded = false;
        boolean data_interpreted = false;

        //PRZYKLAD #2 STRATEGII WYJĄTKÓW GDZIE
        //W PRZYPADKU WYSTĄPIENIA WYJĄTKU WYKONYWANA JEST ZAPIS DO LOGGERA
        try
        {
            loadData();
            data_loaded = true;
        }
        catch(FileNotFoundException exception)
        {
            logger.log(Level.SEVERE, exception.getMessage());
            System.out.println(exception.getMessage());
        }

        if (data_loaded)
        {
            try
            {
                parseData();
                data_interpreted = true;
            }
            catch(IllegalArgumentException exception)
            {
                logger.log(Level.SEVERE, exception.getMessage());
                System.out.println(exception.getMessage());
            }
        }

        if (data_interpreted)
        {
            generate();
        }
    }

    private String generateSingleton(String class_string)
    {
        if (specials_data.singleton)
        {
            class_string+="\n    private static "+class_name+"_instance = null;\n";

            class_string+="\n    private "+class_name+"(){};\n";

            class_string+="\n    public static "+class_name+"_get_instance()\n";
            class_string += "    {\n";


            class_string += "       "+class_name+"_instance = "+class_name+"_instance == null ? new "+class_name+"() : "+class_name+"_instance;\n";
            class_string += "       return "+class_name+"_instance;\n";
            class_string += "    }\n";
        }

        return class_string;
    }

    private String generateGetters(String class_string)
    {
        if (specials_data.getters)
        {
            for (ArgumentData argument: argument_data)
            {
                class_string+="\n    public "+argument.type+" get_"+argument.name+"()\n";
                class_string += "    {\n";
                class_string += "       return "+argument.name+";\n";
                class_string += "    }\n";
            }
        }
        return class_string;
    }

    private String generateSetters(String class_string)
    {
        if (specials_data.setters)
        {
            for (ArgumentData argument: argument_data)
            {
                class_string+="\n    public void set_"+argument.name+"("+argument.type+" new_"+argument.name+")\n";
                class_string += "    {\n";
                class_string += "       "+argument.name+" = new_"+argument.name+";\n";
                class_string += "    }\n";
            }
        }
        return class_string;
    }

    private String generateBuilderPart1(String class_string)
    {
        if (specials_data.builder)
        {
            class_string+="\n    private "+class_name+"("+class_name+"Builder builder);\n";
            class_string += "    {\n";
            for (ArgumentData argument: argument_data)
            {
                class_string+="        this."+argument.name+" = builder."+argument.name+";\n";
            }
            class_string += "    }\n";
        }
        return class_string;
    }

    private String generateBuilderPart2(String class_string)
    {
        if (specials_data.builder)
        {
            class_string += "\n    public static class "+class_name+"Builder\n";
            class_string += "    {\n";

            for (ArgumentData argument: argument_data)
            {
                class_string+="        private "+argument.type+" "+argument.name+";\n";
            }
            class_string+="\n        public "+class_name+"Builder(){};\n";

            for (ArgumentData argument: argument_data)
            {
                class_string+="\n        public "+class_name+"Builder set_"+argument.name+"("+argument.type+" new_"+argument.name+")\n";
                class_string += "        {\n";
                class_string += "            "+argument.name+" = new_"+argument.name+";\n";
                class_string += "            return this;\n";
                class_string += "        }\n";
            }

            class_string+="\n        public "+class_name+" build()\n";
            class_string += "        {\n";
            class_string += "            return new "+class_name+"(this);\n";
            class_string += "        }\n";
            class_string += "    }\n";
        }
        return class_string;
    }

    private void generate()
    {
        String class_string = "public class "+class_name+"\n";

        if (specials_data.allprivate)
        {
            for (ArgumentData argument: argument_data)
            {
                argument.access = "private";
            }
        }

        class_string += "{\n";

        for (ArgumentData argument: argument_data)
        {
            class_string+="    "+argument.access+" "+argument.type+" "+argument.name+";\n";
        }

        class_string = generateBuilderPart1(class_string);
        class_string = generateSingleton(class_string);
        class_string = generateGetters(class_string);
        class_string = generateSetters(class_string);
        class_string = generateBuilderPart2(class_string);

        class_string += "}\n";

        System.out.println(class_string);

    }

    public void loadData() throws java.io.FileNotFoundException
    {
        File file = new File(filename+".txt");

        Scanner myReader = new Scanner(file);
        if (myReader.hasNextLine()) loaded_data = myReader.nextLine();

        myReader.close();
    }

    private void parseData()
    {
        parseName();

        if ((string_pos<loaded_data.length())&&(loaded_data.charAt(string_pos)=='-'))
        {
            string_pos++;
            parseArguments();
        }
        else
        {
            throw new IllegalArgumentException("Błąd formuły - brak startu argumentow");
        }

        if ((string_pos<loaded_data.length())&&(loaded_data.charAt(string_pos)=='-'))
        {
            string_pos++;
            parseSpecials();
        }
        else
        {
            throw new IllegalArgumentException("Błąd formuły - brak startu specjalnych wytycznych");
        }

        if ((string_pos!=loaded_data.length()-1)||(loaded_data.charAt(string_pos)!='-'))
        {
            throw new IllegalArgumentException("Błąd formuły - brak końca ciągu");
        }
    }

    private void parseSpecials()
    {
        while ((string_pos<loaded_data.length())&&(loaded_data.charAt(string_pos)!='-'))
        {
            String new_special = getTerm();

            boolean correct = specials_data.setNewSpecial(new_special);

            if (!correct)
            {
                throw new IllegalArgumentException("Błąd formuły - specjalna wytyczna");
            }
        }
    }

    private void parseArguments()
    {
        while ((string_pos<loaded_data.length())&&(loaded_data.charAt(string_pos)!='-'))
        {
            parseArgument();
        }
    }

    private void parseArgument()
    {
        ArgumentData new_argument = new ArgumentData();
        new_argument.name = getTerm();
        new_argument.access = getTerm();
        new_argument.type = getTerm();

        if (!new_argument.isCorrect())
        {
            throw new IllegalArgumentException("Błąd formuły - wczytywanie argumentu");
        }

        argument_data.add(new_argument);
    }

    private void parseName() throws IllegalArgumentException
    {
        class_name = getTerm();

        if (class_name.equals(""))
        {
            throw new IllegalArgumentException("Błąd formuły - nazwa klasy");
        }
    }

    private String getTerm()
    {
        String new_term = "";
        while((string_pos<loaded_data.length())&&(loaded_data.charAt(string_pos)!=';'))
        {
            new_term += loaded_data.charAt(string_pos);
            string_pos++;
        }

        //System.out.println(new_term);

        if (string_pos==loaded_data.length())
        {
            new_term = "";
        }
        string_pos++;
        return new_term;
    }
}
