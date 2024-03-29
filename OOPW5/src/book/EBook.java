package book;

import java.util.Scanner;

public class EBook extends Book {

	EBook(String tkn) {
		super(tkn);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void read(Scanner scan) {
		super.read(scan);
		url = scan.next();
		format = scan.next();
	}

	@Override
	void print() {
		super.print();
		System.out.printf("%s [%s]\n", url, format);
	}
	@Override
	boolean matches(String kwd) {
		if (super.matches(kwd))
			return true;
		if (kwd.contentEquals("전자책"))
			return true;
		if (url.contains(kwd))
			return true;
		if (format.contentEquals(kwd))
			return true;
		return false;
	}
}
