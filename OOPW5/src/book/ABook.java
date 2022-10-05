package book;

import java.util.Scanner;
import java.util.ArrayList;

public class ABook extends Book {
	ArrayList<String> appendix = new ArrayList<>();
		
	ABook(String tkn) {
		super(tkn);
		// TODO Auto-generated constructor stub
	}

	@Override
	void read(Scanner scan) {
		super.read(scan);
		String tmp = null;
		int n = scan.nextInt();
		for (int i =0; i< n; i++) {
			tmp = scan.next();
			appendix.add(tmp);
		}
//			
//		url = scan.next();
//		format = scan.next();
	}

	@Override
	void print() {
		super.print();
		System.out.print("\t");
		for (String tmp: appendix)
			System.out.print(tmp + " ");
//		System.out.printf("%s [%s]\n", url, format);
	}

	@Override
	boolean matches(String kwd) {
		if (super.matches(kwd))
			return true;
		if (kwd.contentEquals("부록책"))
			return true;
		for (String tmp:appendix)
			if (tmp.contains(kwd))
				return true;
		return false;
	}
}
