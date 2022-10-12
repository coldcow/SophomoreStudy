package food;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
	Scanner scan = new Scanner(System.in);
	ArrayList<Manageable> foods = new ArrayList<>();
	HashMap<String, Manageable> foodMap = new HashMap<>();

	public void readEats(Factory fac) {

		int day, month;
		String eatType;
		Eat eat = null;
		// ArrayList<Manageable> eatlist = new ArrayList<>();
		ArrayList<Eat> eatlist = new ArrayList<>();
		int totalCal = 0;
		while (true) {
			month = scan.nextInt();
			if (month == 0)
				return;
			day = scan.nextInt();
			eatType = scan.next();
			int cc = scan.nextInt();
			for (int i = 0; i < cc; i++) {
				// Manageable m = null;
				Eat et = new Eat();
				et.read(scan, this);
				eatlist.add(et);
				totalCal += et.getKcal();
			}
			System.out.printf("%d/%d %s ", month, day, eatType);
			System.out.printf("총 칼로리: %dkcal\n", totalCal);
			;
			// for (Manageable f : eatlist)
			for (Eat f : eatlist)
				System.out.println("  " + f);
		}
	}

	public void readFoods(Factory fac) {
		Manageable m = null;

		String type;
		String k;
		while (true) {
			type = scan.next();
			if (type.equals("0"))
				break;
//			type = scan.next();
//			if (k == 1)
//				m = fac.create(type);
//			else
			m = fac.create(type);
			m.read(scan);

			Food food = (Food) m;
			foods.add(m);
			foodMap.put(food.name, m);
		}
		for (Manageable f : foods) {
			System.out.println(f);
		}
	}

	Manageable findFood(String n) {
		Manageable f = foodMap.get(n);
		if (f == null) {
			System.out.println("find null => " + n);
			throw new NullPointerException();
		}
		return f;
	}
}
