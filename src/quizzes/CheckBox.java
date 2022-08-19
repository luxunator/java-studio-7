package quizzes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CheckBox extends Question {

    private final HashMap<String, Boolean> answers;
    private HashMap<String, Boolean> userAnswers = new HashMap<>();

    CheckBox(String text, int points, HashMap<String, Boolean> answers) {
        super(text, points);
        this.answers = answers;
    }

    public int grade() {
        String correctness = "\nCorrect!";
        boolean pass = true;
        int answerNum = 1;
        String correct = "Correct Answer: ";
        String user = "Your Answer: ";

        for (String answer: this.answers.keySet()) {
            if (this.answers.get(answer) != this.userAnswers.get(answer)) {
                correctness = "\nIncorrect";
                pass = false;
            }

            if (this.answers.get(answer)) {
                correct += answerNum + ", ";
            }

            if (this.userAnswers.get(answer)) {
                user += answerNum + ", ";
            }

            answerNum++;
        }

        System.out.println(correctness);
        System.out.println(this.getText());
        System.out.println(correct.substring(0, correct.length()-2));
        System.out.println(user.substring(0, user.length()-2));

        if (pass) {
            return this.getPoints();
        }

        return 0;
    }

    public void askQuestion() {
        Scanner input = new Scanner(System.in);

        System.out.println(this.getText() + ": ");
        int answerNum = 1;

        for (String answer: this.answers.keySet()) {
            System.out.println(answerNum + ". " + answer);
            answerNum++;
        }

        System.out.print("\nAnswer Numbers (ex: 1, 3, 5): ");
        ArrayList<String> answersList = new ArrayList(Arrays.asList(input.nextLine().replace(" ", "").split(",")));

        answerNum = 1;
        for (String answer: this.answers.keySet()) {
            if (answersList.contains(String.valueOf(answerNum))) {
                this.userAnswers.put(answer, true);
            } else {
                this.userAnswers.put(answer, false);
            }

            answerNum++;
        }
    }
}
