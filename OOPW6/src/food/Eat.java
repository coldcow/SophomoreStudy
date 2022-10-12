package food;

import java.util.ArrayList;

import java.util.Scanner;

class Eat {
	Food food;
	int qnty;
	String unit = "개";
	int kcal;

	public void read(Scanner scan, Manager manager) {
		String name = scan.next();
		qnty = scan.nextInt();
		// unit = scan.next();
		food = (Food) manager.findFood(name);
		kcal = getKcal();
	}

	public String toString() {
		return String.format("%s %d%s(%dkcal) - %s", food.name, qnty, unit, kcal, food.getDetail(qnty, unit));
	}

	int getKcal() {
		return food.getKcal(qnty, unit);
	}
}