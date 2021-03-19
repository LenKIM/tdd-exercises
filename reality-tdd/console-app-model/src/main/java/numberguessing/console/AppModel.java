package numberguessing.console;

import numberguessing.PositiveIntegerGenerator;

public final class AppModel {

    private final static String NEW_LINE = System.lineSeparator();

    private String output = "1: Single player game" + NEW_LINE + "2: Multiplayer game" + NEW_LINE + "3: Exit" + NEW_LINE + "Enter selection: ";
    private static final String SELECT_MODE = "1: Single player game" + NEW_LINE + "2: Multiplayer game" + NEW_LINE + "3: Exit";

    private int answer;

    private boolean completed = false;
    private final PositiveIntegerGenerator generator;

    Processor processor;

    interface Processor {
        Processor run(String input);
    }

    public AppModel(PositiveIntegerGenerator generator) {
        this.generator = generator;
        processor = new Processor() {
            @Override
            public Processor run(String input) {
                return processModeSelection(input);
            }
        };
    }

    public boolean isCompleted() {

        return completed;
    }


    private Processor processModeSelection(String input) {
        if (input.equals("1")) {
            output = "Single player game" + NEW_LINE + "I'm thinking of a number between 1 and 100."
                    + NEW_LINE + "Enter your guess: ";
            answer = generator.generateLessThanOrEqualToHundread();
            return getSinglePlayerGameProcessor(answer,1);
        } else {
            completed = true;
            return null;
        }
    }

    private Processor getSinglePlayerGameProcessor(int answer, int tries) {
        return input -> {
            int guess = Integer.parseInt(input);
            if (guess < answer) {
                output = "Your guess is too low." + NEW_LINE + "Enter your guess: ";
                return getSinglePlayerGameProcessor(answer, tries + 1);
            } else if (guess > answer) {
                output = "Your guess is too high." + NEW_LINE + "Enter your guess: ";
                return getSinglePlayerGameProcessor(answer, tries + 1);
            } else {
                output = "Correct! " + tries + (tries == 1 ? " guess." : " guesses.") + NEW_LINE + SELECT_MODE
                        + NEW_LINE + "Enter selection: ";
                return this::processModeSelection;
            }
        };
    }

    public String flushOutput() {
        return output;
    }

    public void processInput(String input) {
        processor = processor.run(input);
    }
}