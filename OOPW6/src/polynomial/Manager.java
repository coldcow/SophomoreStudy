package polynomial;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	ArrayList<Manageable> polynomials = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void run(Factory fac) {

		Manageable p = null;
		while (true) {
			System.out.print("$ ");
			String command = sc.next();
			if (command.equals("exit")) // 종료
				break;
			// 항의 생성
			if (command.equals("create")) {
				// p = new Polynomial();
				Manageable poly = null;
				poly = fac.create();
				poly.read(sc);
				polynomials.add(poly);

				continue;
			}
			p = find(sc); // 그 이외의 경우는 이름을 입력받음
			if (p == null) { // 이름의 다항식이 없으면 오류
				sc.nextLine(); // 이름 오류이므로 뒤 부분 읽어 버림
				continue;
			}
			switch (command) {
			case "add": // 다항식에 새로운 항 (c x ^ e)를 더함
				p.add(sc);

				break;
			case "calc": // 입력한 수로 f(x)를 계산
				int n = sc.nextInt();
				int result = p.calc(n);
				break;
			case "print": // 다항식 출력.
				p.print();
			default:
				sc.nextLine();
				break;
			}
		}
	}

	Manageable find(Scanner sc) {
		String name = sc.next();
		for (Manageable p : polynomials) {
			if (p.compare(name))
				return p;
		}
		return null;
	}
}
