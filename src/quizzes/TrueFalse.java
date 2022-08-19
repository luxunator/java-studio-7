package quizzes;

import java.util.Scanner;

public class TrueFalse extends Question {

    private final boolean correctAnswer;
    private boolean userAnswer;

    TrueFalse(String text, int points, boolean correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer;
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
        System.out.println("1. True");
        System.out.println("2. False");
        System.out.print("\nAnswer Number: ");

        int answerNum = input.nextInt();

        if (answerNum == 1) {
            this.userAnswer = true;
            return;
        }

        this.userAnswer = false;
    }
}
