package kr.easw.lesson08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 해당 클래스는 Map 컬렉션을 사용한 예제입니다.
 * <p>
 * Map 컬렉션은 키와 값을 가지는 컬렉션입니다.
 * 키-값 쌍을 내부적으로 저장하고 있으며, 키를 통해 값을 불러올 수 있습니다.
 * <p>
 * 이 중에서 HashMap은 키를 해시 함수를 통해 해시값으로 변환하여 저장하고 있습니다.
 * 해시 함수는 객체를 Int 형태로 변환하며, 단순 객체 비교가 아닌 이진 트리 형식을 통해 일반적인 리스트의 선회 구조보다 압도적인 검색 속도를 보장합니다.
 */
public class MapCollectionExample {
    // 계정 정보를 저장할 Map 객체를 선언합니다.
    // HashMap은 Map을 상속받음으로, Map 객체로 캐스팅될 수 있습니다.
    private static final Map<String, String> accounts = new HashMap<>();

    public static void main(String[] args) {
        // 콘솔 창에서 입력을 받는 Scanner 객체를 생성합니다.
        Scanner scanner = new Scanner(System.in);
        // 사용자에게 로그인 또는 회원가입을 선택하도록 안내합니다.
        System.out.println("Login or Register?");
        // 사용자의 입력을 받습니다.
        String nextWord = scanner.nextLine();
        while (true) {
            // switch문을 통해 사용자의 입력을 분기합니다.
            // switch는 Switch Table이라는 내부 구조를 사용하기에, if문보다 빠르게 작동합니다.
            switch (nextWord) {
                // 로그인이 입력되었을 경우,
                case "Login" -> {
                    // 사용자에게서 ID와 비밀번호를 받습니다.
                    System.out.print("Type your ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Type your password: ");
                    String password = scanner.nextLine();
                    // 만약 ID가 존재한다면,
                    if (accounts.containsKey(id)) {
                        // ID와 비밀번호를 비교합니다.
                        // Map 컬렉션은 키가 존재하지 않는다면 null 값을 반환하기 떄문에, null을 포함한 비교를 하거나
                        // containsKey() 메서드를 사용하여 키가 존재하는지 사전 확인하는 것이 좋습니다.
                        if (accounts.get(id).equals(password)) {
                            // 비밀번호가 일치한다면, 로그인 성공 메시지를 출력합니다.
                            System.out.println("Login successful.");
                        } else {
                            // 비밀번호가 일치하지 않는다면, 비밀번호 오류 메시지를 출력합니다.
                            System.out.println("Invalid password.");
                        }
                    } else {
                        // ID가 존재하지 않는다면, ID 오류 메시지를 출력합니다.
                        System.out.println("Invalid ID.");
                    }
                }
                // 회원가입이 입력되었을 경우,
                case "Register" -> {
                    // 사용자에게서 ID와 비밀번호를 받습니다.
                    System.out.print("Type your ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Type your password: ");
                    String password = scanner.nextLine();
                    // 만약 ID가 이미 존재한다면,
                    if (accounts.containsKey(id)) {
                        // ID 중복 오류 메시지를 출력합니다.
                        System.out.println("ID already exists.");
                        break;
                    }
                    // ID가 존재하지 않는다면, Map에 데이터를 추가하고 회원가입 성공 메시지를 출력합니다.
                    accounts.put(id, password);
                    System.out.println("Account created.");
                }
                // 종료 명령이 입력되었을 경우,
                case "exit" -> {
                    // 프로그램을 종료합니다.
                    return;
                }
                // 그 외의 명령이 입력되었을 경우, 잘못된 명령임을 알리는 메시지를 출력합니다.
                default -> System.out.println("Invalid command. Please type 'Login' or 'Register' or 'exit' to exit.");
            }
            // 사용자에게 다음 명령을 입력받습니다.
            System.out.println("Login or Register?");
            nextWord = scanner.nextLine();
        }
    }


}
