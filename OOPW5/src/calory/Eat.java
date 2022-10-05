package calory;

import java.util.ArrayList;
import java.util.Scanner;

class Eat {
	Food food;
	int qnty;
	String unit;
	int kcal;
	int amount = 0;
	String amountUnit;
	
	void read(Scanner scan, Dine main) {
		String name = scan.next();
		food = main.findFood(name);
		qnty = scan.nextInt();
		amount = food.amount;
		amountUnit = scan.next();
		if (unitCheck()) {
			amount = qnty;
			qnty = 1;
}
		kcal = getKcal();
		unit = food.unit;
	}
	
	boolean unitCheck() {
		return amountUnit.equals("g") ||
				amountUnit.equals("cc") ||
				amountUnit.equals("ml");
	}
	
	@Override
	public String toString() {
		if (unitCheck())
			return String.format("%s %d%s(%dkcal) - %s -> %dkcal*%d/%d%s=%dkcal", 
					food.name, amount, amountUnit, kcal, food.getDetail(qnty, unit),
					food.cal, amount, food.amount, amountUnit, kcal);
		return String.format("%s %d%s(%dkcal) - %s", 
				food.name, qnty, unit, kcal, food.getDetail(qnty, unit));
	}
	
	int getKcal() {
		return food.getKcal(qnty, amount, unit);
	}
}