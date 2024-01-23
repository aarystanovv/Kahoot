package Project;

public abstract class Question {
    static String description,answer;

    public static void setDescription(String a){description = a;}

    public static void setAnswer(String a){
        answer = a;
    }

    public static String getDescription() {return description;}

    public static String getAnswer() {return answer;}

}
