package quizzes;

public abstract class Question {

    private final String text;
    private final int points;

    Question(String text, int points){
        this.text = text;
        this.points = points;
    }

    public abstract int grade();
    public abstract void askQuestion();

    public String getText() {
        return this.text;
    }

    public int getPoints() {
        return this.points;
    }
}
