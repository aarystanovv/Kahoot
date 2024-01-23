package Project;

import java.io.*;
import java.util.*;

public class Quiz {
    public static String name;
    public static ArrayList<String> questions = new ArrayList<String>();

    public Quiz(){}

    public static void setName(String a){
        name = a;
    }
    public static String getName(){
        return name;
    }

    public static Quiz loadFromFile(String s,int a,int b,String args) throws IOException {
        Quiz quiz = new Quiz();
        File file = new File(args+".txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        for(int i = 0;i<a/5;i++){
            questions.add(in.readLine());
            for(int j=0;j<4;j++)in.readLine();
        }in.readLine();
        for(int i = 0;i<(b-a+1)/2;i++){
            questions.add(in.readLine()); in.readLine();
        }
        return quiz;
    }
}