package workshop.animal.entity;

public class Spider extends Animal{
	public Spider() {
		super(8);
	}
	
	@Override
	public void eat() {
		System.out.println("Spider은 작은 곤충을 먹는다");		
	}
}