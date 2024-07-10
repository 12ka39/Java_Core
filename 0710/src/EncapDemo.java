
public class EncapDemo {

	public static void main(String[] args) {
		Car sonata = new Car();
		//sonata. = "현대 소나타"; // private 라 접근 못 함
		//sonata.price = 30_000_000;
		  
		sonata.setName("현대 소나타");
		sonata.setPrice(30_000_000);
		//System.out.printf("이름 = %s, 가격=%d%n", sonata.name, sonata.price); 오류. private라서 이렇게는 못 가져온다
		System.out.printf("이름 = %s, 가격 = %d%n", sonata.getName(), sonata.getPrice());
		
	}

}

class Car{
	
	private String name; //데이터 함부로 수정 안 되도록 private
	private int price;
	
	// 게터 세터
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name; // this. 자기 자신의 주소. 나의
		// 이름을 '나의' 이름에 넣자
		// this.name 은 멤버변수 = name (지역변수)
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

}