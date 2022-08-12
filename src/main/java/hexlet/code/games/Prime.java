package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static String instruction = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static String questionInPrimeGame() {
        var number = Math.abs((int) (Math.random() * (Engine.getMaxRandomNumber() + 2)));
        return Integer.toString(number);
    }

    public static String rightAnswerInPrimeGame(String question) {
        var number = Integer.parseInt(question);
        int i = 2;

        do {
            if (number % i == 0) {
                return "no";
            } else {
                i++;
            }
        } while (i < number);
        return "yes";
    }

    public static void playPrimeGame() {
        Engine.getName();
        Engine.getInstruction(instruction);

        var rightAnswersCount = 0;
        do {
            String question = questionInPrimeGame();
            Engine.getQuestion(question);
            String answer = Engine.getAnswerFromUser();
            String rightAnswer = rightAnswerInPrimeGame(question);

            boolean result = Engine.compareAnswers(answer, rightAnswer);

            if (result) {
                Engine.getCorrect();
                rightAnswersCount++;
            } else {
                Engine.getWrongAnswer(answer, rightAnswer);
            }

        } while (rightAnswersCount < Engine.getRoundCount());

        Engine.getCongratulations();
    }
}
