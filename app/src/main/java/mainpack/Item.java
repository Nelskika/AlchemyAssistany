package mainpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Item implements  Comparable<Item>{

    String name;
    String tags;
    String usage;
    String bulk;
    String activate;
    String basicDescription;



    public String getName() {
        return name;
    }

    public String getTags() {
        return tags;
    }

    public String getUsage() {
        return usage;
    }

    public String getBulk() {
        return bulk;
    }

    public String getActivate() {
        return activate;
    }

    public String getBasicDescription() {
        return basicDescription;
    }



    public Item(File file){
        super();
        try {
            FileInputStream inFile = new FileInputStream(file);
            Scanner scr = new Scanner(inFile);
            scr.useDelimiter("[\r\n]+");

            name = scr.nextLine();
            tags = scr.nextLine();
            usage =scr.nextLine();
            bulk = scr.nextLine();
            activate = scr.nextLine();
            scr.useDelimiter("");
            basicDescription = "";
            while(scr.hasNext())
                basicDescription += scr.next();




            System.out.println("here");



        }catch (FileNotFoundException ex){
            System.out.println(ex);
        }

    }



    public int compareTo(Item b) {


        return this.getName().compareTo(b.getName());


    }

}


