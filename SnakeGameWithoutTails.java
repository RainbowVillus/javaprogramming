package kr.easw.lesson3;

import java.util.Random;
import java.util.Scanner;

public class SnakeGameWithoutTails {

    private static final int BOARD_SIZE = 10;
    private static final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private static final Random RANDOM = new Random();
    private static int score = 0;
    private static SnakeLocation location = new SnakeLocation(0, 0);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.print("[우측 (r) | 좌측 (l) | 위 (u) | 아래 (d) | 종료 (0) ] : ");
            String input = scanner.nextLine();
            if (!nextDirection(input)) {
                System.out.println("게임 오버!");
                System.out.printf("점수: %d\n", score);
                break;
            }
            if (!hasItemOnBoard())
                placeRandomItem();
        }
        scanner.close(); // 스캐너를 닫아줍니다.
    }

    private static boolean nextDirection(String keyword) {
        switch (keyword) {
            case "r":
                move(0, 1);
                break;
            case "l":
                move(0, -1);
                break;
            case "u":
                move(-1, 0);
                break;
            case "d":
                move(1, 0);
                break;
            case "0":
                return false;
            default:
                System.out.println("올바른 명령을 입력하세요.");
                return true;
        }
        return true;
    }

    private static void move(int offsetX, int offsetY) {
        int nextX = location.getX() + offsetX;
        int nextY = location.getY() + offsetY;
        if (isValidMove(nextX, nextY)) {
            location = new SnakeLocation(nextX, nextY);
            if (board[nextX][nextY] == 2) {
                score++;
                board[nextX][nextY] = 0;
            }
        } else {
            System.out.println("잘못된 이동입니다. 보드 바깥으로 나가지 않도록 조심하세요!");
        }
    }

    private static boolean isValidMove(int x, int y) {
        return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
    }

    private static void printBoard() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (location.getX() == x && location.getY() == y) {
                    System.out.print("◼ ");
                    continue;
                }
                switch (board[x][y]) {
                    case 0:
                        System.out.print("・ ");
                        break;
                    case 1:
                        System.out.print("◼ ");
                        break;
                    case 2:
                        System.out.print("* ");
                        break;
                }
            }
            System.out.println(); // 한 행이 끝나면 줄바꿈
        }
    }


    private static void placeRandomItem() {
        int toPlace = RANDOM.nextInt(10);
        for (int i = 0; i < toPlace; i++) {
            int retry = 0;
            while (retry < 5) {
                int randomX = RANDOM.nextInt(BOARD_SIZE);
                int randomY = RANDOM.nextInt(BOARD_SIZE);
                if (board[randomX][randomY] != 0) {
                    retry++;
                    continue;
                }
                board[randomX][randomY] = 2;
                break;
            }
        }
    }

    private static boolean hasItemOnBoard() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (board[x][y] == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class SnakeLocation {
        private final int x;
        private final int y;

        public SnakeLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public SnakeLocation adjust(int x, int y) {
            return new SnakeLocation(this.x + x, this.y + y);
        }
    }
}

