package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    static final int MAX_RANDOM_NUMBER = 100;
    private static String instruction = "Answer 'yes' if number even otherwise answer 'no'.";


    public static String questionInEvenGame() {
        var number = (int) (Math.random() * (MAX_RANDOM_NUMBER + 1));
        return Integer.toString(number);
    }

    public static String rightAnswerInEvenGame(String number) {
        if (Integer.parseInt(number) % 2 == 0) {
            return "yes";
        }
        return "no";
    }

    public static void playEvenGame() {
        Engine.getName();
        Engine.getInstruction(instruction);

        var rightAnswersCount = 0;
        do {
            String question = questionInEvenGame();
            Engine.getQuestion(question);
            String answer = Engine.getAnswerFromUser();
            String rightAnswer = rightAnswerInEvenGame(question);

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










