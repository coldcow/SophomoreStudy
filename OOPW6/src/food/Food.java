package food;

import java.util.Scanner;

public class Food implements Manageable {
	static int serialNo = 0;
	int id;
	String type;
	public String name;
	String unit;
	int cal;

	public Food(String type) {
		id = ++serialNo;
		this.type = type;
	}

	public void read(Scanner scan) {
		// type = scan.next();
		name = scan.next();
		unit = scan.next();
		cal = scan.nextInt();
		// m.foodMap.put(name, m);
	}

	@Override
	public String toString() {
		return String.format("[%2d] %s-%s (%dkcal/%s)", id, type, name, cal, unit);
	}

	int getKcal(int s, String u) {
		return s * cal;
	}

	String getDetail(int n, String unit) {
		return String.format("%dkcal/%d%s", cal, 1, this.unit);
	}

	public String getFoodname() {
		return this.name;
	}
}

//
//class DFood extends Food {
//	String dunit;
//	int size;
//	DFood(String s) {
//		super(s);
//	}
//	@Override
//	void read(Scanner scan) {
//		super.read(scan);
//		size = scan.nextInt();
//		dunit = scan.next();
//	}
//	@Override
//	public String toString() {
//		return super.toString()
//				+ String.format(" %d%s", size, dunit);
//	}
//	@Override
//	int getKcal(int s, String u) {
//		if (unit.equals(u))
//			return super.getKcal(s, u);
//		if (dunit.equals(u))
//			return cal*s/size;
//		return 0;
//	}
//	@Override
//	String getDetail(int n, String unit) {
//		String common = super.getDetail(n,  unit);
//		if (dunit.equals(unit))
//			return common 
//					+ String.format(" -> %dkcal*%d/%d%s=%dkcal", 
//					cal, n, size, dunit, getKcal(n, unit));
//		return common;
//	}
// }
