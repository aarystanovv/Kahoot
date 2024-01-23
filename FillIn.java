package Project;

import java.util.Locale;

public class FillIn extends Question {
    public static boolean check (String s){
        if (s.toLowerCase(Locale.ROOT).equals(Question.getAnswer().toLowerCase(Locale.ROOT)))
            return true;
        else return false;
    }
    @Override
    public String toString() {
        return getDescription().replace("{blank}", "______");
    }

}
