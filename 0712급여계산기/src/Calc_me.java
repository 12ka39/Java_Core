/*
public class Calc_me {
	private Person [] array;
	
	int [] grade1 = {95000, 92000, 89000, 86000, 83000};
	int [] grade2 = {80000, 75000, 70000, 65000, 60000};
	
	double [] taxRate = {0, 0.005, 0.007, 0.012};
	int [] jojung = {0, 300, 500, 1000};
	
	
	public Calc_me(Person [] array) {
		this.array = array;
	}
	

	void calc(){
		for (Person p : this.array) {
			
			// 급여 구하기
			if (p.getGrade() == 1) { // 급 가져와서
				switch(p.getHo()) { // 호 찾기
					case 1: p.setSal(grade1[0]); break;
					case 2: p.setSal(grade1[1]); break;
					case 3: p.setSal(grade1[2]); break;
					case 4: p.setSal(grade1[3]); break;
					case 5: p.setSal(grade1[4]); break;
					}
			} else if (p.getGrade() == 2) {
				switch(p.getHo()) { // 호 
					case 1: p.setSal(grade2[0]); break;
					case 2: p.setSal(grade2[1]); break;
					case 3: p.setSal(grade2[2]); break;
					case 4: p.setSal(grade2[3]); break;
					case 5: p.setSal(grade2[4]); break;
				}
			}
			
			// 지급액 = 급여 + 수당
			int pay = p.getSal() + p.getMoney(); 
			
                               			
			// 세금 = (지급액 * 세율) - 조정액
			if(pay >=90000) {
				int tax = (int) (pay * taxRate[3]) -  jojung[3];
				p.setTax(tax);
			}else if(pay >=80000){
				int tax = (int) (pay * taxRate[2]) -  jojung[2];
				p.setTax(tax);
			}else if(pay >=70000){
				int tax = (int) (pay * taxRate[1]) -  jojung[1];
				p.setTax(tax);
			} else { 
				int tax = 0;
				p.setTax(tax);
			}
			
 			
			// 차인지급액 = 지급액 - 세급
			int taxpay = pay - p.getTax();
			
			p.setPay(pay);
			p.setTax(taxpay);
		}
		  
	}
}
*/