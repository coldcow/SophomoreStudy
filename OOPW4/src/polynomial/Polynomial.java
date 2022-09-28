package polynomial;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial {
	ArrayList<Term> termArray = new ArrayList<>();
	char name;
	int cof;
	int exp;

	public void read(Scanner sc) {
		name = sc.next().charAt(0);

		Term t = null;
		t = new Term();

		t.read(sc);
		termArray.add(t);
	}

	public void print() {
		System.out.format("%c = ", name);
		for (Term t : termArray) {
			t.printTerm();

			System.out.format(" + ");
		}

		System.out.format("0\n");
	}

	void addTerm(Scanner sc) {

		int c = sc.nextInt();
		int e = sc.nextInt();
		int index = findPolynomial(e);
		Term t = new Term(c, e);// add f 3 3

		if (index != -1) {
			termArray.get(index).add(c);

		} else {
			int length = termArray.size() - 1;

			for (int i = 0; i <= length; i++) {
				if (termArray.get(i).exponent < t.exponent) {
					termArray.add(i, t);
					break;
				} else if (i == length) {
					termArray.add(t);
				}
			}
		}
	}

	int findPolynomial(int e) {
		for(Term t : termArray) {
			if (t.exponent == e)
				return termArray.indexOf(t);
		}
		return -1;
	}

	int calcPolynomial(int x) {
		int result = 0;
		for (Term t : termArray) {
			result += t.calc(x);
		}
		return result;
	}

	boolean matches(char kwd) {
		return kwd == name;
	}

}