package calory;

import java.util.ArrayList;
import java.util.Scanner;

public class AmountOfFood extends Food {
	ArrayList<String> appendix = new ArrayList<>();
	
	
	AmountOfFood(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void read(Scanner scan) {
		//type = scan.next();
		name = scan.next();
		unit = scan.next();
		cal = scan.nextInt();
		amount = scan.nextInt();
		String amountUnit = scan.next();	
		}
	
	@Override
	public String toString() {
		return String.format("[%2d] %s-%s (%dkcal/%s) %dg",
				id, type, name, cal, unit, amount);
	}
	
	@Override
//	int getKcal(int s, String u) {
//		if (amount == 0) {
//			System.out.println("result: " + s*cal);
//			return s*cal;
//		}
//		return s/amount*cal;
//	}
		
	String getDetail(int n, String unit) {
		return String.format("%dkcal/%d%s", 
				cal, 1, this.unit);
	}	

}
