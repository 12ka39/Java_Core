import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static List<Hospital> getInput(int maxPatients) {
        Scanner scanner = new Scanner(System.in);
        List<Hospital> hospitalList = new ArrayList<>();
        String i_o = null;

        while (hospitalList.size() < maxPatients) {
            System.out.print("번호: ");
            int num = scanner.nextInt();
            System.out.print("진료코드: ");
            String code = scanner.next();
            System.out.print("입원일수: ");
            int day = scanner.nextInt();
            System.out.print("나이: ");
            int age = scanner.nextInt();

            hospitalList.add(new Hospital(num, code, day, age));

            System.out.print("입력/출력(I/O)? ");
            i_o = scanner.next();

            if (i_o.equalsIgnoreCase("O")) {
                break;
            }
        }

        return hospitalList; // List<Hospital>을 반환
    }
}
