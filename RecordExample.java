package kr.easw.lesson08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 해당 클래스는 레코드를 사용한 예제입니다.
 *
 * 레코드는 자바 16부터 추가된 기능으로, DTO를 대체하는 용도로 많이 사용합니다.
 * 클래스 이름 뒤에 소괄호를 붙여 생성자를 대체하며, 레코드 클래스에서 생성자에 선언한 변수는 필드 변수가 됩니다.
 */
public class RecordExample {

    // 예제로 선언된 레코드 클래스입니다.
    // 레코드 클래스는 Object 대신 Record 클래스를 상속받으며,
    // 생성자에 선언된 변수는 필드 변수로 사용됩니다.
    // 선언된 모든 변수는 final로 취급되어 재선언할 수 없습니다.
    //
    // 이 클래스는 필드 변수로 name과 score를 가집니다.
    record ScoreRecord(String name, int score) {
    }

    // 레코드 클래스는 생성자가 대체되었다는것을 제외하면 일반 클래스와 동일하게 사용이 가능합니다.
    private static final List<ScoreRecord> scores = new ArrayList<>();

    // 이 예제는 학생의 이름과 점수를 입력받아 리스트에 저장하고, 저장된 학생들의 점수를 출력하는 예제입니다.
    public static void main(String[] args) {
        // 콘솔 창에서 입력을 받는 Scanner 객체를 생성합니다.
        Scanner scanner = new Scanner(System.in);
        // 다음 입력을 받을 학생의 수를 입력받습니다.
        System.out.print("Type student count: ");
        // 입력받을 학생의 수를 선언합니다.
        int next = scanner.nextInt();
        // 입력받은 학생의 수만큼 반복합니다.
        for (int i = 0; i < next; i++) {
            System.out.println((next - i) + " students left.");
            System.out.print("Type student name: ");
            String name = scanner.next();
            System.out.print("Type student score: ");
            int score = scanner.nextInt();
            // 레코드는 선언법만 일반 클래스와 다르고, 사용은 완전히 동일합니다.
            // 객체 생성 또한 new 키워드를 사용하여 생성합니다.
            scores.add(new ScoreRecord(name, score));
        }
        System.out.println("All students are recorded.");
        System.out.println("Student list:");
        int total = 0;
        for (ScoreRecord record : scores) {
            // 레코드 클래스의 변수 또한 일반 클래스와 동일하게 사용이 가능합니다.
            total += record.score;
            // 레코드 클래스는 getter를 자동으로 생성하여, 변수 이름과 동일한 메서드를 사용하여 값을 가져올 수 있습니다.
            System.out.println("Student " + record.name() + " scored " + record.score() + " points.");
        }
        System.out.println("Average score: " + ((double) total / scores.size()) + " points.");
    }

}
