package Project;

import java.io.*;
import java.util.*;

public class QuizMaker {
    public static void main(String []args) throws IOException, InvalidQuizFormatException {
        File file = new File(args[0]+".txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        int a = 0, b = 0;
        for(;;){
            if (in.readLine() == null) break;
            if (in.readLine().equals("Next")) a = b;
            b++;
        }
        Quiz.setName("Java OOP");
        if(a == 0)throw new InvalidQuizFormatException();
        b += b - 1; a += a + 2;
        Quiz quiz = new Quiz();
        quiz = Quiz.loadFromFile("", a, b,args[0]);
        String[] options = new String[4];
        int count = 0,correct = 0;String str = "";
        String []strs = {"A","B","C","D"};
        Test.labels.addAll( Arrays.asList(strs) );
        System.out.println("==============================================================");
        System.out.println("Welcome to \""+Quiz.getName()+"\" Quiz!");
        int run = (int)System.currentTimeMillis();
        int x = (int)(a / 2.5);
        while (count < x) {
            BufferedReader getOptions = new BufferedReader(new FileReader(file));
            int n = (int) (Math.random()*x);
            while (str.contains(String.valueOf(n))) {n = (int)(Math.random()*x);}
            str+=n; n++;
            if (n <= a / 5) {
                for (int i = 0; i < (n - 1) * 5 + 1; i++)
                    getOptions.readLine();
                for (int i = 0; i < 4; i++) {
                    options[i] = getOptions.readLine();
                }
                Test.setOptions(options);
                Question.setAnswer(options[0]);
                Question.setDescription(Quiz.questions.get(n-1));
                System.out.println("--------------------------------------------------------------");
                System.out.println("Question "+(1+count)+". "+Question.getDescription());
                options = start(options);
                for (int i = 0; i < 4; i++) {
                    System.out.println(Test.labels.get(i)+") "+options[i]);
                }
                System.out.print("Enter the correct choice: ");
                Scanner input = new Scanner(System.in);
                String st = input.next();
                while(Math.abs((int)st.charAt(0)-65)>4) {
                    System.out.print("Invalid choice try again! (Ex: A, B, ...): ");
                    st = input.next();
                }
                if (options[(int)st.charAt(0) - 65].equals(Question.getAnswer())) {
                    System.out.println("You are right!!!"); correct++;
                }
                else System.out.println("You are wrong. Correct Answer is: " + Question.getAnswer());
            }
            if (n > a / 5) {
                BufferedReader fil = new BufferedReader(new FileReader(file));
                for (int i = 0; i < a; i++)
                    fil.readLine();
                for (int i = 0; i < n-(a/5); i++) {
                    Question.setDescription(fil.readLine());
                    Question.setAnswer(fil.readLine());
                }
                System.out.println("--------------------------------------------------------------");
                System.out.println("Question "+(1+count)+". "+Question.getDescription());
                System.out.print("Type your answer: ");
                Scanner scan = new Scanner(System.in);
                if(FillIn.check(scan.next())){
                    System.out.println("You are right!!!"); correct++;
                }
                else System.out.println("You are Wrong. Correct Answer is: " + Question.getAnswer());
            }
            count++;
        } int all = (int)(a/2.5);
        System.out.println("--------------------------------------------------------------");
        System.out.print("Correct Answers: "+correct+"/"+all+" ("+(correct*100/all)+"%). ");
        System.out.print("Your time is: "+((int)(System.currentTimeMillis()-run)/1000)+" seconds.");
    }public static String[] start(String []options){
        for(int i = 0;i<4;i++){
            int a = (int)(Math.random()*4);
            int b = (int)(Math.random()*4);
            String temp = options[a];
            options[a] = options[b];
            options[b] = temp;
        }
        return options;
    }
}

