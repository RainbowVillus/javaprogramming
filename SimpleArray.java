package kr.easw.lesson3;

import java.util.Scanner;

public class SimpleArray {
    private static int[] arrays = new int[10];
    private static int[] answer = new int[]{0, 1, 4, 16, 25, 49, 64, 81, 121, 144};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("배열의 값을 입력하세요:");
        for (int i = 0; i < 10; i++) {
            arrays[i] = scanner.nextInt();
        }

        scanner.close();

        checkAnswer();
    }

    private static void checkAnswer() {
        boolean isMatched = true;
        for (int i = 0; i < 10; i++) {
            if (arrays[i] != answer[i]) {
                System.out.printf("값이 일치하지 않습니다. (인덱스 %d)\n", i);
                isMatched = false;
            }
        }

        if (isMatched) {
            System.out.println("정답입니다.");
        } else {
            System.out.println("오답입니다.");
        }
    }
}
