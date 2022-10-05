package book;

import java.util.ArrayList;
import java.util.Scanner;

class BookStore {
	Scanner scan = new Scanner(System.in);
	ArrayList<Book> bookList = new ArrayList<>();

	void run() {
		readAllBooks();
		printAllBooks();
		search();
	}

	private void printAllBooks() {
		for (Book b : bookList)
			b.print();
	}

	void readAllBooks() {
		String tmp = null;
		Book b = null;
		while (true) {
			int n = scan.nextInt();
			if (n == 0) {
				break;
			}
			tmp = scan.next();
			switch (n) {
			case 1:
				b = new Book(tmp);
				break;
			case 2:
				b = new EBook(tmp);
				break;
			case 3:
				b = new ABook(tmp);
				break;
			default:
				break;
			}
			b.read(scan);
			bookList.add(b);
		}
	}

	void search() {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			for (Book b : bookList)
				if (b.matches(kwd))
					b.print();
		}
	}

	public static void main(String[] args) {
		BookStore b = new BookStore();
		b.run();
	}
	
}