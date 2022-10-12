package food;

public class Department extends Manager implements Factory {

	@Override
	public Manageable create(String kwd) {
		// TODO Auto-generated method stub
		return new Food(kwd);
	}

	void run() {
		readFoods(this);
		readEats(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department d = new Department();
		d.run();

	}
}
