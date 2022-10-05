package phone;

import java.util.Scanner;

public class Phone {
		Scanner scan = new Scanner(System.in);
		String name;
		String phoneNum;
//		int index;
		
		public Phone(String name) {
//			this.index = index;
			this.name = name;
		}
		

		public void read(Scanner scan) {
			// TODO Auto-generated method stub
			// name = scan.next();
			phoneNum = scan.next();
		}

		public void print() {
			// TODO Auto-generated method stub
			System.out.printf("이름: %s 전화번호: %s\n", 
					name, phoneNum);
		}

		

}
