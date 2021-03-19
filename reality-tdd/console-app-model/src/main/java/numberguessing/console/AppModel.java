package numberguessing.console;

import numberguessing.PositiveIntegerGenerator;

import java.util.stream.Stream;

public final class AppModel {

    private final static String NEW_LINE = System.lineSeparator();

    private final StringBuffer outputBuffer;
    private static final String SELECT_MODE = "1: Single player game" + NEW_LINE + "2: Multiplayer game" + NEW_LINE + "3: Exit";

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
        outputBuffer = new StringBuffer(SELECT_MODE);
    }

    public boolean isCompleted() {
        return completed;
    }

    private void println(String s) {
        outputBuffer.append(s).append(NEW_LINE);
    }

    private void print(String message) {
        outputBuffer.append(message);
    }

    private Processor processModeSelection(String input) {
        if (input.equals("1")) {
            println("Single player game");
            println("I'm thinking of a number between 1 and 100.");
            print("Enter your guess: ");
            int answer = generator.generateLessThanOrEqualToHundread();
            return getSinglePlayerGameProcessor(answer, 1);
        } else if (input.equals("2")) {
            println("Multiplayer game");
            print("Enter player names separated with commas: ");

            return startMultiPlayerGame();
        } else {
            completed = true;
            return null;
        }
    }

    private Processor getSinglePlayerGameProcessor(int answer, int tries) {
        return input -> {
            int guess = Integer.parseInt(input);
            if (guess < answer) {
                println("Your guess is too low.");
                print("Enter your guess: ");
                return getSinglePlayerGameProcessor(answer, tries + 1);
            } else if (guess > answer) {
                println("Your guess is too high.");
                print("Enter your guess: ");
                return getSinglePlayerGameProcessor(answer, tries + 1);
            } else {
                println("Correct! " + tries + (tries == 1 ? " guess." : " guesses."));
                println(SELECT_MODE);
                print("Enter selection: ");
                return this::processModeSelection;
            }
        };
    }

    private Processor startMultiPlayerGame() {
        return input -> {
            Object[] players = Stream.of(input.split(",")).map(String::trim).toArray();
            println("I'm thinking of a number between 1 and 100.");
            int answer = generator.generateLessThanOrEqualToHundread();
            return getMultiPlayerGameProcessor(players, answer, 1);
        };
    }

    private Processor getMultiPlayerGameProcessor(Object[] players, int answer, int tries) {
        Object player = players[(tries - 1) % players.length];
        print("Enter " + player + "'s guess: ");
        return input -> {
            int guess = Integer.parseInt(input);
            if (guess < answer) {
                println(player + "'s guess is too low.");
                return getMultiPlayerGameProcessor(players, answer, tries + 1);
            } else if (guess > answer) {
                println(player + "'s guess is too high.");
                return getMultiPlayerGameProcessor(players, answer, tries + 1);
            } else {
                print("Correct! ");
                println(player + " wins.");
                println("1: Single player game");
                println("2: Multiplayer game");
                println("3: Exit");
                print("Enter selection: ");
                return this::processModeSelection;
            }
        };
    }

    public String flushOutput() {
        String s = outputBuffer.toString();
        outputBuffer.setLength(0);
        return s;
    }

    public void processInput(String input) {
        processor = processor.run(input);
    }
}