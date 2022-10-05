package phone;

import java.util.ArrayList;
import java.util.Scanner;

import snack.Customer;
import snack.Snack;
import snack.Store;

public class PhoneManage {
	Scanner scan = new Scanner(System.in);
	ArrayList<Phone> phoneList = new ArrayList<>();

	// 이름 전화번호 형식으로 입력
	void run() {
		readAll();
		printAll();
		menu();
	}


	private void menu() {
		// TODO Auto-generated method stub
		int n;
		while (true) {
			System.out.println("(1) 이름으로 검색 (2) 전화번호로 검색 (3) 추가 등록 (종료: 0) ");
			n = scan.nextInt();
			if (n == 0)
				break;
			switch (n) {
			case 1:
				findByName();
				break;
			case 2:
				findByNum();			
				break;
			case 3:
				newRegister();
				break;
			default:
				break;
			}
		}
	}

	private void newRegister() {
		System.out.println("새로 등록할 이름과 전화번호를 입력하세요 ");
		Phone ph = null;
		String name = null;
		while (true) {
			name = scan.next();
			if (name.equals("0"))
				break;
			ph = new Phone(name);
			ph.read(scan);
			phoneList.add(ph);
		}
	}

	private void findByName() {
		// TODO Auto-generated method stub
		String kwd;
		System.out.println("이름 입력: ");
		kwd = scan.next();
		for (Phone ph : phoneList) {
			if (ph.name.equals(kwd)) {
				ph.print();
				return;
			}
		}
		System.out.println("해당하는 이름이 없습니다.\n");

	}

	private void findByNum() {
		// TODO Auto-generated method stub
		String kwd;
		System.out.println("전화번호 입력: ");
		kwd = scan.next();
		for (Phone ph : phoneList) {
			if (ph.phoneNum.equals(kwd)) {
				ph.print();
				return;
			}
		}
		System.out.println("해당하는 전화번호가 없습니다.\n");
	}

	void readAll() {
		Phone ph = null;
		String name = null;
		int index = 1;
		while (true) {
			name = scan.next();
			if (name.equals("0"))
				break;
			ph = new Phone(name);
			ph.read(scan);
			phoneList.add(ph);
			index++;
		}
	}

	void printAll() {
		for (Phone ph : phoneList) {
			ph.print();
		}
	}

	public static void main(String[] args) {
		PhoneManage phone = new PhoneManage();
		phone.run();
	}

}
