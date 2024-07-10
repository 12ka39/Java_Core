package prac;

public class Methods {
//	4. 처리조건
//	   1) 판매금액 = 수량 * 판매단가
//	   2) 매입금액 = 수량 * 매입단가
//	   3) 이익금 =판매금액 - (매입금액 + 운송료)
//	   4) 이익율 = 이익금 / 매입금액 * 100
//	   5) 이익율은 소수점 이하 셋째 자리에서 반올림하여 둘째 자리까지 구한다.
	
	int sell_tot (Product pd) {
		int sell_tot = pd.getNumber() * pd.getSell_price();
		return sell_tot;
	}
	
	int buy_tot(Product pd) {
		int buy_tot = pd.getNumber() * pd.getBuy_price();
		return buy_tot;
	}
	
	int profit(Product pd) {
		int sell_tot = sell_tot(pd);
		int buy_tot = buy_tot(pd);
		int profit = sell_tot - (buy_tot + pd.getUnsong());
		return profit;
	}
	
	
	int profit_rate(Product pd) {
		int buy_tot = buy_tot(pd);
		int profit = profit(pd);
		
		int profit_rate = (profit / buy_tot) * 100;
		return profit_rate;
	}
}
