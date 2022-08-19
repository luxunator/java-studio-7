package quizzes;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoice extends Question {

    private final ArrayList<String> answers;
    private final int correctAnswer;
    private int userAnswer;


    MultipleChoice(String text, int points, int correctAnswer, ArrayList<String> answers){
        super(text, points);
        this.correctAnswer = correctAnswer + 1;
        this.answers = answers;
    }

    public int grade() {
        String correctness = "\nIncorrect!";
        boolean pass = false;

        if (this.correctAnswer == this.userAnswer) {
            correctness = "\nCorrect!";
            pass = true;
        }

        System.out.println(correctness);
        System.out.println(this.getText());
        System.out.println("Correct Answer: " + correctAnswer);
        System.out.println("Your Answer: " + userAnswer);

        if (pass) {
            return this.getPoints();
        }

        return 0;
    }

    public void askQuestion() {
        Scanner input = new Scanner(System.in);
        System.out.println(this.getText() + ": ");

        for (String answer : this.answers) {
            System.out.println((answers.indexOf(answer) + 1) + ". " + answer);
        }

        System.out.print("\nAnswer Number: ");
        this.userAnswer = input.nextInt();
    }
}
