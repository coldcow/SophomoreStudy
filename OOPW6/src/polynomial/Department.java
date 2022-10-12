package polynomial;

import java.util.ArrayList;
import java.util.Scanner;

public class Department extends Manager implements Factory {
	/*
	 * === 사용법 === create f 3 4 : f = 3 x ^ 4 다항식 생성 add f 2 1 : f에 2 x 항을 생성, f = 3
	 * x ^ 4 + 2 x calc f 3 : f(3) = 249 을 계산해서 결과 출력 add f 6 0 : f = 3 x ^ 4 + 2 x
	 * + 6 print f : f(x) = 3 x ^ 4 + 2 x + 6 + 0출력 exit : 종료
	 */

	public static void main(String[] args) {
		Department calc = new Department();
		calc.run(calc);
	}

	@Override
	public Manageable create() {
		// TODO Auto-generated method stub
		return new Polynomial();
	}

}
