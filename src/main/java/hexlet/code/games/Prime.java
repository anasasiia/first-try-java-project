package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static final String INSTRUCTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static String[] questions = questionsInPrimeGame();
    public static String[] answers = answersInPrimeGame(questions);

    public static String generateQuestionInPrimeGame() {
        var question = (int) Math.abs((Math.random() * Engine.getMaxRandomNumber()) + 2);
        return Integer.toString(question);
    }

    public static String[] questionsInPrimeGame() {
        String[] questions = new String[Engine.ROUND_COUNT];
        for (var i = 0; i < questions.length; i++) {
            questions[i] = generateQuestionInPrimeGame();
        }
        return questions;
    }

    public static String[] answersInPrimeGame(String[] questions) {
        String[] answers = new String[Engine.ROUND_COUNT];
        int answersIndex = 0;

        for (var questionIndex = 0; questionIndex < questions.length; questionIndex++) {
            for (int i = 2; i < Integer.parseInt(questions[questionIndex]); i++) {
                if (Integer.parseInt(questions[questionIndex]) % i == 0) {
                    answers[answersIndex] = "no";
                    break;
                }
                answers[answersIndex] = "yes";
            }
            answersIndex++;
        }
        return answers;
    }

}
