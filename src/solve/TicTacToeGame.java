package solve;

import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;  // NxN
    private char currentPlayer;
    private boolean gameEnded;
    private int movesCount;
    private final Scanner scanner;
    private final int ROWS = 3;
    private final int COLS = 3;

    // Конструктор класса
    public TicTacToeGame() {
        board = new char[ROWS][COLS];
        currentPlayer = 'X';
        gameEnded = false;
        movesCount = 0;
        scanner = new Scanner(System.in);
        initializeBoard();
    }

    /**
     * Инициализирует игровое поле числами от 1 до 9.
     */
    private void initializeBoard() {
        int cellNumber = 1;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = (char) ('0' + cellNumber++);
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (j < COLS - 1) {
                    System.out.print(board[i][j] + " | ");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            if (i < ROWS - 1) {
                System.out.println("\n---------");
            } else {
                System.out.println();
            }

        }
    }

    /**
     * Запускает игру и управляет игровым циклом.
     */
    private void play() {
        while (!gameEnded) {
            printBoard();
            System.out.println("Игрок " + currentPlayer + ", выберите клетку (1-9): ");
            int cell;
            while (true) {
                String input = scanner.nextLine();
                try {
                    cell = Integer.parseInt(input);
                    if (cell < 1 || cell > 9) {
                        System.out.println("Некорректный номер. Попробуйте снова:");
                        continue;
                    }
                    int row = (cell - 1) / 3;
                    int col = (cell - 1) % 3;
                    if (board[row][col] == 'X' || board[row][col] == 'O') {
                        System.out.println("Клетка уже занята. Выберите другую:");
                    } else {
                        board[row][col] = currentPlayer;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введите число от 1 до 9:");
                }
            }

            movesCount++;
            if (checkWin()) {
                printBoard();
                System.out.println("Игрок " + currentPlayer + " победил!");
                gameEnded = true;
            } else if (movesCount == 9) {
                printBoard();
                System.out.println("Ничья!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkWin() {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                    board[i][1] == currentPlayer &&
                    board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer &&
                    board[1][i] == currentPlayer &&
                    board[2][i] == currentPlayer) return true;
        }


        if (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer) return true;

        return false;
    }

    public static void main(String args[]) {
        TicTacToeGame game = new TicTacToeGame();

        System.out.println("Добро пожаловать в игру 'Крестики-Нолики!'");
        game.play();
    }
}
