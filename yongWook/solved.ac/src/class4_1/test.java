package class4_1;

public class test {
	public static void main(String[] args) {
			
		
	        //���丮 ���� 
			ShapeFactory factory = new ShapeFactory();

	        Shape shape1 = factory.createShape("circle");
	        shape1.draw(); // ���� �׸��ϴ�.

	        Shape shape2 = factory.createShape("rectangle");
	        shape2.draw(); // �簢���� �׸��ϴ�.

	        
	        
	        //��Ʈ��Ƽ�� ����
	        Duck mallard = new Duck(new FlyWithWings());
	        mallard.performFly(); // ������ ���� ���ƿ�!

	        mallard.setFlyBehavior(new FlyNoWay());
	        mallard.performFly(); // ���� �� ���ƿ�...

		
	}
}  
