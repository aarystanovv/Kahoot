package Project;

import java.util.ArrayList;

public class Test extends Question {
    static String []options;
    final int numOfOptions = 4;
    static ArrayList<String> labels = new ArrayList<String>();

    public Test(){}

    public static void setOptions(String[] a) {
        options = a;
    }

    public String getOptionAt(int x){
        return options[x];
    }

    public String toString(){
        return "";
    }

}