package quizzes;

import java.util.ArrayList;
import java.util.HashMap;

public class QuizRunner {
    public static void main(String[] args) {

        ArrayList<String> myMultipleChoiceAnswers = new ArrayList<>();
        myMultipleChoiceAnswers.add("Bob");
        myMultipleChoiceAnswers.add("Joe");
        myMultipleChoiceAnswers.add("Dylan");
        MultipleChoice myMultipleChoice = new MultipleChoice("Who is the Greatest?", 9001, 2, myMultipleChoiceAnswers);

        HashMap<String, Boolean> myCheckBoxAnswers = new HashMap<>();
        myCheckBoxAnswers.put("Me", true);
        myCheckBoxAnswers.put("Myself", true);
        myCheckBoxAnswers.put("I", true);
        myCheckBoxAnswers.put("Mario", false);
        CheckBox myCheckBox = new CheckBox("Who is awesome?", 9002, myCheckBoxAnswers);

        TrueFalse myTrueFalse = new TrueFalse("Do we live on Earth?", 9000000, true);

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(myMultipleChoice);
        questions.add(myCheckBox);

        Quiz myFunQuiz = new Quiz(1, "FUN FUN FUN", questions);
        myFunQuiz.add(myTrueFalse);

        myFunQuiz.start();
        myFunQuiz.grade();
    }
}
