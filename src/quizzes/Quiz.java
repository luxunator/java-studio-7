package quizzes;

import java.util.ArrayList;

public class Quiz {

    private final int id;
    private final String name;
    private int totalPoints = 0;
    private int finalPoints = 0;
    private final ArrayList<Question> questions;

    Quiz(int id, String name, ArrayList<Question> questions){
        this.id = id;
        this.name = name;
        this.questions = questions;
    }

    public void start(){
        System.out.println(this.name);

        for (Question question : questions) {
            System.out.print("\n");
            question.askQuestion();
        }
    }

    public void grade() {
        System.out.println("\n" + this.name + " Grade Report:");

        for (Question question: questions) {
            this.totalPoints += question.getPoints();
            this.finalPoints += question.grade();
        }

        System.out.println("\n" + this.finalPoints + " / " + this.totalPoints);
    }

    public void add(Question question) {
        questions.add(question);
    }

}
