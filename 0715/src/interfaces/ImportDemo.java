package interfaces;


import kr.seoul.sesac.util.libs.*;

import com.example.libs.Car;

public class ImportDemo extends Car {

	public static void main(String[] args) {
		Finance f = new Finance();
		HumanResource hr = new HumanResource();
		System.out.println(f.money);
		System.out.println(hr.salary);
		
		// 여기까지는 mylib.jar 파일로 한 거
		
		
		
		
		new com.example.libs.Car(); // 이게 너무 길다
		Car car = new Car();
		System.out.println(car.name);
		
		
		ImportDemo id = new ImportDemo();
		System.out.println(id.price);
		
	}

}
