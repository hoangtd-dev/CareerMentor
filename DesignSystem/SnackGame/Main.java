import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static class SnackPosition {
        public int row;
        public int column;

        public SnackPosition(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static int WIDTH_SIZE = 10;
    public static int HEIGHT_SIZE = 10;
    public static int BOOM_ID = -1;
    public static int FRUIT_ID = 1;
    public static int CELL_EMPTY = 0;
    public static int SNACK_ID = 2;
    public static int[][] map = new int[WIDTH_SIZE][HEIGHT_SIZE];
    public static LinkedList<SnackPosition> snackPositions = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isGameContinue = true;
        snackPositions.add(new SnackPosition(0, 0));
        // Add Boom
        map[1][1] = BOOM_ID;
        map[2][3] = BOOM_ID;
        map[8][8] = BOOM_ID;

        // Add Fruit
        map[1][3] = FRUIT_ID;
        map[5][3] = FRUIT_ID;
        map[7][7] = FRUIT_ID;

        display();
        while (isGameContinue && !isFull()) {
            String input = scanner.next();

            switch (input) {
                case "w":
                    isGameContinue = up();
                    break;
                case "s":
                    isGameContinue = down();
                    break;
                case "a":
                    isGameContinue = left();
                    break;
                case "d":
                    isGameContinue = right();
                    break;
                default:
                    break;
            }
            System.out.println("-------------------------");
            display();
        }
        System.out.println("GAME OVER !!!");
    }

    public static boolean hasBoom(int row, int column) {
        if (map[row][column] == BOOM_ID)
            return true;

        return false;
    }

    public static boolean hasFruit(int row, int column) {
        if (map[row][column] == FRUIT_ID)
            return true;

        return false;
    }

    public static boolean isFull() {
        return snackPositions.size() == HEIGHT_SIZE * WIDTH_SIZE - 1;
    }

    public static boolean move(int row, int column) {
        boolean hasBoom = hasBoom(row, column);
        boolean hasFruit = hasFruit(row, column);

        if (hasBoom) {
            snackPositions.pollLast();
        }

        if (snackPositions.size() == 0) {
            return false;
        }

        snackPositions.addFirst(new SnackPosition(row, column));
        SnackPosition last = snackPositions.pollLast();

        if (hasFruit) {
            snackPositions.addLast(last);
        }

        if (hasBoom || hasFruit) {
            map[row][column] = CELL_EMPTY;
        }

        return true;
    }

    public static boolean up() {
        SnackPosition head = snackPositions.getFirst();
        int newY = head.column - 1;
        if (newY < 0)
            return false;

        return move(head.row, newY);
    }

    public static boolean down() {
        SnackPosition head = snackPositions.getFirst();
        int newY = head.column + 1;
        if (newY >= HEIGHT_SIZE)
            return false;

        return move(head.row, newY);
    }

    public static boolean left() {
        SnackPosition head = snackPositions.getFirst();
        int newX = head.row - 1;
        if (newX < 0)
            return false;

        return move(newX, head.column);
    }

    public static boolean right() {
        SnackPosition head = snackPositions.getFirst();
        int newX = head.row + 1;
        if (newX >= WIDTH_SIZE)
            return false;

        return move(newX, head.column);
    }

    public static void display() {
        int[][] newArr = new int[WIDTH_SIZE][HEIGHT_SIZE];
        for (int i = 0; i < map.length; i++) {
            newArr[i] = Arrays.copyOf(map[i], map[i].length);
        }

        for (SnackPosition position : snackPositions) {
            newArr[position.row][position.column] = SNACK_ID;
        }

        for (int column = 0; column < HEIGHT_SIZE; column++) {
            for (int row = 0; row < WIDTH_SIZE; row++) {
                if (newArr[row][column] == FRUIT_ID) {
                    System.out.print("+ ");
                } else if (newArr[row][column] == BOOM_ID) {
                    System.out.print("o ");
                } else if (newArr[row][column] == SNACK_ID) {
                    System.out.print("S ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}