package polynomial;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial implements Manageable {
	// 다항식의 항을 가지는 리스트
	ArrayList<Term> terms = new ArrayList<>();
	char name; // 다항식의 이름

	// 입력에서 다항식의 이름과 계수, 지수를 받아 이름 저장 및 항을 하나 생성
	// 입력: f 3 4
	public void read(Scanner scan) {
		name = scan.next().charAt(0);
		add(scan);
	}

	public boolean compare(String name2) {
		// TODO Auto-generated method stub
		return name == name2.charAt(0);
	}

	// 이 다항식을 f = 3 x ^ 4 + 2 x + 6 형태로 출력
	public void print() {
		System.out.print(name + " = ");
		for (Term t : terms) {
			t.print();
			System.out.print(" + ");
		}
		System.out.println(0);
	}

	// x의 값을 받아 다항식을 계산한 결과를 반환
	public int calc(int x) {
		int result = 0;
		for (Term t : terms)
			result += t.calc(x);
		System.out.format("%c(%d) = %d\n", name, x, result);
		return result;
	}

	// 항을 하나 입력받아 이 다항식에 내림차순으로 더한다. 항은 계수와 지수를 입력함
	public void add(Scanner scan) {
		int c = scan.nextInt();
		int e = scan.nextInt();
		addTerm(c, e);
	}

	// 항을 추가하거나 항을 찾는 함수 private
	private void addTerm(int c, int e) {
		Term t = findTerm(e);
		if (t != null) {
			t.add(c);
			return;
		}
		t = new Term(c, e);
		int i = 0;
		for (i = 0; i < terms.size(); i++) {
			if (terms.get(i).compare(e) < 0) {
				break;
			}
		}
		terms.add(i, t);
	}

	private Term findTerm(int e) {
		for (Term t : terms)
			if (t.equals(e))
				return t;
		return null;
	}
}
