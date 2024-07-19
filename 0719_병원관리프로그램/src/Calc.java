import java.util.List;
/**
 * @author N
 * 작성일: 2024-07-19
 * 작성목적: 병원관리 프로그램 Calc
 * 작성환경: Windows 11
 * 				JDK 17.0.11.
 * 				Eclipse IDE for Java Developer Version: 2024-06
 */
public class Calc {
	private List<Hospital> list;
	private int count;
	
	public Calc(List<Hospital> list, int count) {
		this.list = list;
		this.count = count;
	}
	
	public void calc() {
		
		//for (int i=0; i<count; i++) {
			//Hospital p = this.list[i];
		
		for (Hospital p : list) {
			// 총입원비
			int total_ipwon = total_ipwon(p.getDay());
			
			//입원비
			long ipwon = ipwon(total_ipwon, p.getDay());
			p.setIbwon(ipwon);
			
			
			//진찰비
			long jinchal = jinchal(p.getAge());
			p.setJinchal(jinchal);
			
			//진료비
			long jinryo = jinryo(p.getAge(), p.getIbwon());
			p.setJinryo(jinryo);
		}
	}
	
	
	// 총입원비
	private int total_ipwon(int day) {
		int total_ipwon=0;
		if(day <=3) {
			total_ipwon = day * 30000;
		} else {
			total_ipwon = day * 25000;
		}
		return total_ipwon;
	}
	
	
	
	// 입원비 = 총입원비 X 입원일수 할인비율
	private long ipwon(int total_ipwon, int day) {
		double discount = 0.0; 
		if(day <10) { discount = 1.00;
		}else if(day>=10 && day <15) {
			discount = 0.85;
		}else if(day>=15 && day <20) {
			discount = 0.80;
		}else if(day >= 20 && day <30) {
			discount = 0.77;
		}else if(day >= 30 && day <100) {
			discount = 0.72;
		} else {
			discount = 0.68;
		}
		
		return (long) discount;
	}
	
	
	
	//진찰비
	private long jinchal(int age) {
		int jinchal = 0;
		if (age < 10) {
			jinchal = 7000;
		} else if(age >=10 && age<20) {
			jinchal = 5000;
		} else if(age >=20 && age<30) {
			jinchal = 8000;
		} else if(age >=30 && age<40) {
			jinchal = 7000;
		} else if(age >=40 && age<50) {
			jinchal = 4500;
		} else {
			jinchal = 2300;
		}
		return jinchal;
	}
	
	
	// 진료비 = 진찰비 + 입원비
	private long jinryo(int jinchal, long ibwon) {
		long jinryo = jinchal + ibwon;
		return jinryo;
	}
}
