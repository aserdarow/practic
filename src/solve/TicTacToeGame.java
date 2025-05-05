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
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                // Изначально все клетки пустые и отображаются как числа (1–9)
            }
        }
    }

    /**
     * Запускает игру и управляет игровым циклом.
     */
    private void play() {
    }

    public static void main(String args[]) {
        TicTacToeGame game = new TicTacToeGame();

        System.out.println("Добро пожаловать в игру 'Крестики-Нолики!'");
        game.play();
    }
}
