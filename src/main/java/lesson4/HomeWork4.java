package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    private static Scanner scanner;
    private static Random random;
    private static char[][] map;

    private static final int SIZE = 5;
    private static final int WIN = 3;

    private static final char MAP_ELEMENT_EMPTY = '_';
    private static final char MAP_ELEMENT_X = 'X';
    private static final char MAP_ELEMENT_O = 'O';

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();
        initMap();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (checkWin(MAP_ELEMENT_X)) {
                System.out.println("Игра окончена. Победил Игрок!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Игра окончена! Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(MAP_ELEMENT_O)) {
                System.out.println("Игра окончена. Победил AI!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Игра окончена! Ничья!");
                break;
            }
        }
    }

    public static boolean checkWin(char element) {
        int countHorizontal = 0;
        int countVertical = 0;
        int diagonalUp = 0;
        int diagonalDown = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != element) {
                    countHorizontal = 0;
                } else {
                    countHorizontal++;
                    if (countHorizontal == WIN) {
                        return true;
                    }
                    if (j == SIZE - 1) {
                        countHorizontal = 0;
                    }
                }
                if (map[j][i] != element) {
                    countVertical = 0;
                } else {
                    countVertical++;
                    if (countVertical == WIN) {
                        return true;
                    }
                    if (i == SIZE - 1) {
                        countVertical = 0;
                    }
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            diagonalDown = 0;
            diagonalUp = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == element) {
                    for (int k = i, o = j; k >=0 && o <SIZE; k--, o++) {
                        if (map[k][o] != element) {
                            diagonalUp = 0;
                        } else {
                            diagonalUp++;
                            if (diagonalUp == WIN) return true;
                        }
                    }
                    for (int k = i, o = j; k < SIZE && o < SIZE; k++, o++) {
                        if (map[k][o] != element) {
                            diagonalDown = 0;
                        } else {
                            diagonalDown++;
                            if (diagonalDown == WIN) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == MAP_ELEMENT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isMoveValid(x, y));

        map[x][y] = MAP_ELEMENT_O;
        System.out.println("AI походил в клетку [ " + (x + 1) + ", " + (y + 1) + " ]");
    }

    public static void playerTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты вашего хода ('X Y')");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isMoveValid(x, y));

        map[x][y] = MAP_ELEMENT_X;
    }

    public static boolean isMoveValid(int x, int y) {
        if(x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        if(map[x][y] != MAP_ELEMENT_EMPTY) {
            return false;
        }
        return true;
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = MAP_ELEMENT_EMPTY;
            }
        }
    }
}
