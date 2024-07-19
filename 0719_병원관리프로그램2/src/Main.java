import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int MAX_PATIENTS = 5;
        List<Hospital> hospitalsList = Input.getInput(MAX_PATIENTS);

        Sort sort = new Sort(hospitalsList);
        sort.quickSort();

        Output.printHeader();
        Output.printDetails(hospitalsList);
    }
}
