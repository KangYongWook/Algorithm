package class4_1;

public class test {
	public static void main(String[] args) {
			
		
	        //팩토리 패턴 
			ShapeFactory factory = new ShapeFactory();

	        Shape shape1 = factory.createShape("circle");
	        shape1.draw(); // 원을 그립니다.

	        Shape shape2 = factory.createShape("rectangle");
	        shape2.draw(); // 사각형을 그립니다.

	        
	        
	        //스트레티지 패턴
	        Duck mallard = new Duck(new FlyWithWings());
	        mallard.performFly(); // 날개로 훨훨 날아요!

	        mallard.setFlyBehavior(new FlyNoWay());
	        mallard.performFly(); // 저는 못 날아요...

		
	}
}  
