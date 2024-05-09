package kr.easw.lesson07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 해당 클래스는 List 컬렉션에 대해 조금 더 친숙해지기 위해 구성된 예제입니다.
 *
 * 주석을 보고, 코드를 실행한 후 다음 문제를 해결해보세요.
 */
public class ListCollectionExample {
    // List 컬렉션은 배열과 비슷한 개념이지만, 배열과 달리 크기가 가변적입니다.
    // 배열은 고정된 크기를 선언하여 사용하지만, List 컬렉션은 요소가 추가될 때마다 크기가 자동으로 늘어납니다.
    // 예를 들어, ArrayList는 내부적으로 배열을 사용하며, 요소가 추가될 때마다 배열의 크기를 늘리는 방식으로 동작합니다.
    // 만약 내부적으로 할당된 크기가 10이고, 11번째 요소를 추가하려고 할 경우, ArrayList는 내부적으로 크기를 증가시킵니다.
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many students are there?");
        System.out.print("> ");
        int next = scanner.nextInt();
        for (int i = 0; i < next; i++) {
            System.out.println("Enter the name of the student.");
            System.out.print("> ");
            String name = scanner.next();
            System.out.println("Enter the age of the student.");
            System.out.print("> ");
            int age = scanner.nextInt();
            // List는 배열과 다르게 크기에 대해 신경 쓸 필요가 없습니다.
            // 이는 다르게 말해, 내부적으로 늘어난 배열의 크기의 관리가 불가능하다는 말과도 같기 떄문에
            // 과도하게 큰 배열을 사용할 경우, 메모리 낭비가 발생할 수 있습니다.
            students.add(new Student(name, age));
        }
        System.out.println("There's " + students.size() + " students.");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Age: " + student.getAge());
        }
    }

    static class Student {
        private final String name;
        private final int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
