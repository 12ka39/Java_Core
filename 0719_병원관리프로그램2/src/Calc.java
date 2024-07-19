public class Calc {
	
	 public static String getDepartment(String code) {
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

    // 진찰비
    public static int getExaminationFee(int age) {
        if (age < 10) {
            return 7000;
        } else if (age < 20) {
            return 5000;
        } else if (age < 30) {
            return 8000;
        } else if (age < 40) {
            return 7000;
        } else if (age < 50) {
            return 4500;
        } else {
            return 2300;
        }
    }

    // 입원비
    public static int calculateHospitalFee(int days) {
        int dailyRateOverThreeDays = 25000; // 3일 초과 시 1일 입원비
        int dailyRateThreeDaysOrLess = 30000; // 3일 이하 입원 시 1일 입원비

        // 총입원비 계산
        int totalFee;
        if (days <= 3) {
            totalFee = dailyRateThreeDaysOrLess * days; // 3일 이하의 경우
        } else {
            totalFee = dailyRateOverThreeDays * days; // 4일 이상인 경우
        }

        // 할인율 적용
        double discount;
        if (days < 10) {
            discount = 1.00;
        } else if (days < 15) {
            discount = 0.85;
        } else if (days < 20) {
            discount = 0.80;
        } else if (days < 30) {
            discount = 0.77;
        } else if (days < 100) {
            discount = 0.72;
        } else {
            discount = 0.68;
        }

        return (int) (totalFee * discount);
    }

    // 진료비를 계산하는 메소드
    public static int calculateTotalFee(int age, int days) {
        int examinationFee = getExaminationFee(age);
        int hospitalFee = calculateHospitalFee(days);
        return examinationFee + hospitalFee;
    }
}
