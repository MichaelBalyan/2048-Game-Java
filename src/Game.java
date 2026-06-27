import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Integer> list = new ArrayList<>();

    public boolean freeField(int[][] board){
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }

    public boolean isPlayable(int[][] board) {
        boolean canPlay = freeField(board);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    canPlay = true;
                    break;
                }
            }
            if (canPlay) {
                break;
            }
        }

        if (!canPlay) {
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 3; i++) {
                    if (board[i][j] == board[i + 1][j]) {
                        canPlay = true;
                        break;
                    }
                }
                if (canPlay) {
                    break;
                }
            }
        }
        return canPlay;
    }

    public int[][] addRandomNumber(int[][] board) {
        boolean canAdd = freeField(board);

        if (canAdd) {
            Random rnd = new Random();
            int probabillity = rnd.nextInt(1, 6);
            int num = 4;
            if (probabillity < 3) {
                num = 2;
            }

            int index_i = rnd.nextInt(0, 4);
            int index_j = rnd.nextInt(0, 4);

            while (board[index_i][index_j] != 0) {
                index_i = rnd.nextInt(0, 4);
                index_j = rnd.nextInt(0, 4);
            }

            board[index_i][index_j] = num;
        }
        return board;
    }

    public int[][] fill(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 0;
            }
        }

        board = addRandomNumber(board);
        board = addRandomNumber(board);

        return board;
    }

    public boolean isWinning(int[][] board) {
        boolean win = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 2048) {
                    win = true;
                }
            }
        }

        return win;
    }

    public void print(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    System.out.print(". " + "\t\t");
                } else {
                    System.out.print(board[i][j] + "\t\t");
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public int[][] moveUp(int[][] board) {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (board[i][j] != 0) {
                    list.add(board[i][j]);
                }
            }

            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).equals(list.get(i + 1))) {
                    list.set(i, list.get(i) * 2);
                    list.remove(i + 1);
                }
            }

            while (list.size() < 4) {
                list.add(0);
            }

            for (int i = 0; i < 4; i++) {
                board[i][j] = list.get(i);
            }

            list.clear();
        }

        board = addRandomNumber(board);

        return board;
    }

    public int[][] moveDown(int[][] board) {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (board[i][j] != 0) {
                    list.add(board[i][j]);
                }
            }

            for (int i = list.size() - 1; i >= 1; i--) {
                if (list.get(i).equals(list.get(i - 1))) {
                    list.set(i, list.get(i) * 2);
                    list.remove(i - 1);
                    i--;
                }
            }

            while (list.size() < 4) {
                list.add(0, 0);
            }

            for (int i = 0; i < 4; i++) {
                board[i][j] = list.get(i);
            }

            list.clear();
        }

        board = addRandomNumber(board);

        return board;
    }

    public int[][] moveLeft(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    list.add(board[i][j]);
                }
            }

            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).equals(list.get(j + 1))) {
                    list.set(j, list.get(j) * 2);
                    list.remove(j + 1);
                }
            }

            while (list.size() < 4) {
                list.add(0);
            }

            for (int j = 0; j < 4; j++) {
                board[i][j] = list.get(j);
            }

            list.clear();
        }

        board = addRandomNumber(board);

        return board;
    }

    public int[][] moveRight(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    list.add(board[i][j]);
                }
            }

            for (int j = list.size() - 1; j >= 1; j--) {
                if (list.get(j).equals(list.get(j - 1))) {
                    list.set(j, list.get(j) * 2);
                    list.remove(j - 1);
                    j--;
                }
            }

            while (list.size() < 4) {
                list.add(0, 0);
            }

            for (int j = 0; j < 4; j++) {
                board[i][j] = list.get(j);
            }

            list.clear();
        }

        board = addRandomNumber(board);

        return board;
    }
}
