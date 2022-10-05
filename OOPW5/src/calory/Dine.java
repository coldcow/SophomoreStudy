package calory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dine {
	public static void main(String[] args) {
		Dine a = new Dine();
		a.mymain();
	}

	ArrayList<Food> foods = new ArrayList<>();
	HashMap<String, Food> foodMap = new HashMap<>();
	Scanner scan = new Scanner(System.in);

	void mymain() {
		readFoods();
		readEats();
	}

	ArrayList<Eat> eatlist = new ArrayList<>();

	void readEats() {
		int day, month;
		String eatType;
		Eat eat = null;
		int totalCal = 0;
		month = scan.nextInt();
		day = scan.nextInt();
		eatType = scan.next();
		int cc = scan.nextInt();
		for (int i = 0; i < cc; i++) {
			//String foodName = scan.next();
			Eat et = new Eat();

			et.read(scan, this);
			eatlist.add(et);
			totalCal += et.getKcal();
		}

		System.out.printf("%d/%d %s ", month, day, eatType);
		System.out.printf("총칼로리: %dkcal\n", totalCal);
		;
		for (Eat f : eatlist)
			System.out.println("  " + f);
	}

	void readFoods() {
		Food m = null;
		String type;
		while (true) {
			String n = scan.next();
			if (n.equals("0")) 
				break;
			
			type = scan.next();
			switch (n) {
			case "1":
				m = new Food(type);
				break;
			case "2":
				m = new AmountOfFood(type);
				break;
			}
			m.read(scan);
			foods.add(m);
			foodMap.put(m.name, m);
			System.out.println(m);
		}
		for (Food f : foods) {
			System.out.println(f);
		}
	}

	Food findFood(String n) {
		Food f = foodMap.get(n);
		if (f == null) {
			System.out.println("find null => " + n);
			throw new NullPointerException();
		}
		return f;
	}
}