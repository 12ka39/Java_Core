import java.util.List;

public class Output {
    public static void printHeader() {
        System.out.println("번호 \t 진찰부서 \t 진찰비 \t 입원비 \t 진료비");
    }

    public static void printDetails(List<Hospital> hospitals) {
        for (Hospital hospital : hospitals) {
            System.out.println(hospital);
        }
    }
}
