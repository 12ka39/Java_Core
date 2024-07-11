
public class Employee {
	String sabun;
	double salary;
	
	// 나 this
	// 부모 super
	
	// this()   내가 나의 또 다른 생성자 호출
	
	// 필드에서는 클래스를 설계한 사람과
	// 이 클래스를 사용할 사람이 다를 확률이 높다. 
	
	// 그래서 생성자 나올 수 있는 모든 경우의 수 다 만들어뒀는데,
	// 사번만 있고 돈 안 받거나, 돈은 받는데 사번이 없는 사원은 존재하지 않는다
	// 그래서 뭘 호출하든 상황에 맞게 해야 하는데
	// this로 커뮤니케이션을 해야 한다
	
	public Employee() { //this.sabun = null; this.salary = 0.0; 
		//new Employee("임시사번", 10_000_000); // ThisDemo1에서의 min의 주소값과 다르다
		this("UnsettedSabun", 10_000_000); // min의 this   23줄 코드로 간다.
		// this메소드는 생성자 안에서만 사용할 수 있고, 반드시 생성자 맨 앞줄에 와야 한다.
		// 일반 메소드는 사용 불가
	}
	
	
	public Employee(String sabun) { 
		this(sabun, 10_000_000);
	}	
	
	
	public Employee(double salary) { 
		this("UnsettedSabun", salary);
	}	
	
	
	public Employee(String sabun, double salary) {
		this.sabun = sabun;
		this.salary = salary;
	}
}
