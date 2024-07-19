
public class Hospital {
    private int num;
    private String code;
    private int day;
    private int age;

    public Hospital(int num, String code, int day, int age) {
        this.num = num;
        this.code = code;
        this.day = day;
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public String getCode() {
        return code;
    }

    public int getDay() {
        return day;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return num + "\t" + getDepartment() + "\t" +
                Calc.getExaminationFee(age) + "\t" +
                Calc.calculateHospitalFee(day) + "\t" +
                Calc.calculateTotalFee(age, day);
    }

    public String getDepartment() {
        switch (code) {
            case "MI": return "외과";
            case "NI": return "내과";
            case "SI": return "피부과";
            case "TI": return "소아과";
            case "VI": return "산부인과";
            case "WI": return "비뇨기과";
            default: return "알수없음";
        }
    }
}
