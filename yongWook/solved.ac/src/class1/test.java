package class1;

public class test {
	String model;
	String color;
	int yyyy;
	test(){
		this.model = "�¿���";
		this.color = "����";
		this.yyyy = 2020;
		System.out.println("model : " + model);
	}
	test(String model, String color, int yyyy){
		System.out.println("�������µ�?");
		this.model = model;
		this.color = color;
		this.yyyy = yyyy;
		System.out.println("model : " + model);
	}
	
	
	public static void main(String[] args) {
		int yyyy=2020;
		test_test c = new test_test("SUV", "���", ++yyyy);
		System.out.println(", year : "+ c.yyyy);
		System.out.println(yyyy);
	}
	
	

}



