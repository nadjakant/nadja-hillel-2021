package HW26;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RockScissorsPaper {
    private static final Logger LOGGER_DEBUG = LoggerFactory.getLogger("logger.debug");
    private static final Logger LOGGER_RESULT = LoggerFactory.getLogger("logger.result");
    public Scanner scanner = new Scanner(System.in);

    public void startGame() {
        ResourceBundle resourceBundle;

        Scanner scanner = new Scanner(System.in);
        String neededLocale = scanner.nextLine();
        switch (neededLocale) {
            case ("DE"):
                resourceBundle = ResourceBundle.getBundle("res", new Locale("DE"));
                break;
            case ("EN"):
                resourceBundle = ResourceBundle.getBundle("res", new Locale("EN"));
                break;
            default:
                resourceBundle = ResourceBundle.getBundle("res", new Locale("UA"));
                break;
        }

        int countOfGames;
        System.out.println(resourceBundle.getString("enter_your_name"));

        Player player1 = new Player(scanner.nextLine(), false);
        Player player2 = new Player("computer", true);

        System.out.println(resourceBundle.getString("enter_number_of_games"));
        String str = scanner.nextLine();
        LOGGER_DEBUG.debug("Count of games: " + str);

        while (!str.matches("\\d+")) {
            System.out.println(resourceBundle.getString("please_be_nice_and_enter_a_positive_number"));
            LOGGER_DEBUG.debug("Unsuitable value");
            str = scanner.nextLine();
        }
        countOfGames = Integer.parseInt(str);
        if( countOfGames == 0 ){
            System.out.println(resourceBundle.getString("we_supposed_to_play"));
            LOGGER_DEBUG.debug("User didn't want to play and quit");
            return;
        }
        for (int i = 1; i <= countOfGames; i++) {
            int result = 0;

            while (result == 0) {
                player1.makeMove();
                if (player1.currentMove == null) {
                    System.out.println(player1.NAME + resourceBundle.getString("result_of_play"));
                    LOGGER_DEBUG.debug("User quit the game");
                    return;
                }

                player2.makeMove();

                result = player1.currentMove.compareMoves(player2.currentMove);
                LOGGER_RESULT.debug("Result of the play: ");

                LOGGER_DEBUG.debug("Current move of the first player: "+ player1.currentMove +" - "+"Current move of the second player: "+ player2.currentMove);
                switch (result) {
                    case 1:
                        player1.score++;
                        System.out.println(player1.NAME +" "+resourceBundle.getString("won_round") +i);
                        LOGGER_RESULT.debug(player1.NAME + " won round" + i);
                        LOGGER_DEBUG.debug("Rounds left: " + (countOfGames - i));
                        break;
                    case -1:
                        player2.score++;
                        System.out.println(player2.NAME +" "+resourceBundle.getString("won_round") +i);
                        LOGGER_RESULT.debug(player2.NAME + " won round" + i);
                        LOGGER_DEBUG.debug("Rounds left: " + (countOfGames - i));
                        break;
                    case 0:
                        System.out.println(resourceBundle.getString("another_round_when_draw"));
                        LOGGER_RESULT.debug("It's a draw, let's make another round");
                        LOGGER_DEBUG.debug("Rounds left: " + (countOfGames - i));
                        break;
                }
            }
        }
        System.out.println(resourceBundle.getString("score"));
        LOGGER_RESULT.debug("Score: ");
        LOGGER_RESULT.debug(player1.NAME + ": " + player1.score);
        LOGGER_RESULT.debug(player2.NAME + ": " + player2.score);
        if (player1.score > player2.score) {
            System.out.println(player1.NAME + " "+resourceBundle.getString("won_this_game"));
            LOGGER_RESULT.debug(player1.NAME + " won this game");
        } else if (player2.score > player1.score) {
            System.out.println(player2.NAME +" "+resourceBundle.getString("won_this_game"));
            LOGGER_RESULT.debug(player2.NAME + " won this game");
        } else {
            System.out.println(resourceBundle.getString("tie"));
            LOGGER_RESULT.debug("Tie!");
        }

    }

    class Player {
        private final String NAME;
        private int score;
        private Move currentMove;
        private final boolean IS_COMPUTER;



        public Player(String name, boolean isComputer) {
            this.NAME = name;
            this.IS_COMPUTER = isComputer;
        }

        private void makeMove() {
            if (IS_COMPUTER) {
                Move[] moves = Move.values();

                Random random = new Random();

                int index = random.nextInt(moves.length);
                currentMove = moves[index];
            } else {
                System.out.println(" make a move [r = ROCK, s = SCISSORS, p = PAPER, x = END GAME]");
                String firstLetter = scanner.next();

                switch (firstLetter.toLowerCase()) {
                    case "r":
                        currentMove = Move.ROCK;
                        break;
                    case "p":
                        currentMove = Move.PAPER;
                        break;
                    case "s":
                        currentMove = Move.SCISSORS;
                        break;
                    case "x":
                        currentMove = null;
                        break;
                    default:
                        LOGGER_DEBUG.debug("unknown move, try again");
                        makeMove();
                }
            }
        }
    }
}

