import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] board = new int[4][4];
        boolean win = false;
        boolean canPlay = true;

        Game game = new Game();
        board = game.fill(board);

        while (canPlay && !win) {
            try {
                System.out.println("=== Game 2048 ===");
                System.out.println();
                System.out.println("Press 'w', 'a', 's', 'd' for moves.");
                System.out.println("Press 'p' for end.");
                System.out.println();
                System.out.println();
                game.print(board);
                System.out.println("> ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.next();
                System.out.print("");

                if (input.equalsIgnoreCase("p")) {
                    System.out.println("You have break the game!");
                    break;
                }

                switch (input) {
                    case "w":
                        board = game.moveUp(board);
                        break;
                    case "s":
                        board = game.moveDown(board);
                        break;
                    case "a":
                        board = game.moveLeft(board);
                        break;
                    case "d":
                        board = game.moveRight(board);
                        break;
                }

                win = game.isWinning(board);
                canPlay = game.isPlayable(board);

            } catch (Exception exception) {
                System.out.println("Error!");
            }
        }
        if (win) {
            game.print(board);
            System.out.println("Great! You have WON this game!!!");
        }
        if (!canPlay) {
            game.print(board);
            System.out.println("Oops! You have lose the game...");
        }

    }
}


