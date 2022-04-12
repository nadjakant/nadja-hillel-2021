package HW16;

//Написать консольную игру камень ножницы бумага
//пользователь должен выбирать количество игр и ввести свое имя
//пользователь должен иметь возможность прервать игру
//после прекращения игры пользователь должен увидеть результат
//Функционал игры должен быть покрыт тестами - надо написать тест на метод который будет определять победителя
//Игру упаковать в .jar file и приложить его к ДЗ + линка на исходный код

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {
    public Scanner scanner = new Scanner(System.in);

    public void startGame() throws IOException {
        int countOfGames;
        saveGameResults("_______________________________");
        saveGameResults("START GAME");
        System.out.println("Введите имя игрока:");

        Player player1 = new Player(scanner.nextLine(), false);
        Player player2 = new Player("computer", true);

        System.out.println("Введите количество игр:");
        String str = scanner.nextLine();

        while (!str.matches("\\d+")) {
            System.out.println("введите число!");
            str = scanner.nextLine();
        }
        countOfGames = Integer.parseInt(str);
        if( countOfGames == 0 ){
            System.out.println("We supposed to play!");
            return;
        }
        for (int i = 1; i <= countOfGames; i++) {
            int result = 0;

            while (result == 0) {
                player1.makeMove();
                if (player1.currentMove == null) {
                    System.out.println(player1.NAME + " refused to play. Get out of here!");
                    return;
                }

                player2.makeMove();

                result = player1.currentMove.compareMoves(player2.currentMove);

                System.out.println(player1.currentMove +" - "+player2.currentMove);
                switch (result) {
                    case 1:
                        player1.score++;
                        System.out.println(player1.NAME + " won round" + i);
                        break;
                    case -1:
                        player2.score++;
                        System.out.println(player2.NAME + " won round" + i);
                        break;
                    case 0:
                        System.out.println("It's a draw, let's make another round");
                        break;
                }
            }
        }

        saveGameResults("Score: ");
        saveGameResults(player1.NAME + ": " + player1.score);
        saveGameResults(player2.NAME + ": " + player2.score);
        if (player1.score > player2.score) {
            saveGameResults(player1.NAME + " won this game");
        } else if (player2.score > player1.score) {
            saveGameResults(player2.NAME + " won this game");
        } else {
            saveGameResults("Tie!");
        }
        saveGameResults("END GAME");
        saveGameResults("_______________________________");
    }

    private class Player {
        private final String NAME;
        private int score;
        private Move currentMove;
        private final boolean IS_COMPUTER;

        public Player(String name, boolean isComputer) {
            this.NAME = name;
            this.IS_COMPUTER = isComputer;
        }

        private void makeMove() throws IOException {
            if (IS_COMPUTER) {
                Move[] moves = Move.values();

                Random random = new Random();

                int index = random.nextInt(moves.length);
                currentMove = moves[index];
            } else {
                saveGameResults(" make a move [r = ROCK, s = SCISSORS, p = PAPER, x = END GAME]");
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
                        saveGameResults("unknown move, try again");
                        saveGameResults("END GAME");
                        makeMove();
                }
            }
        }
    }

    private void saveGameResults(String textToSave) throws IOException {
        final String fileName = "GAME_RESULT.sav";
        String jarPath = "";
        try {

            // Get path of the JAR file
            jarPath = RockScissorsPaper.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath();
            // Get name of the JAR file
            jarPath = jarPath.substring(0, jarPath.lastIndexOf("/"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try{
            OutputStream outputStream =
                    new FileOutputStream(jarPath + "/" + fileName, true);
            outputStream.write((textToSave + "\n").getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            System.out.println(textToSave);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }





}




