package book;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String pub;
    String isbn;
    int year;
    int price;
    ArrayList<String> authors = new ArrayList<>();
    String url;
    String format;

    Book(String tkn) {
        title = tkn;
    }

    void read(Scanner scan) {
        // title = scan.next();
        pub = scan.next();
        isbn = scan.next();
        year = scan.nextInt();
        String token = null;
        while (true) {
            token = scan.next();
            if (token.contentEquals("0"))
                break;
            authors.add(token);
        }
        price = scan.nextInt();
    }

    void print() {
        System.out.format("%s (%s/%s/%d년) [%d원] 저자:", title, pub, isbn, year, price);
        for (String a : authors)
            System.out.print(a + " ");
        System.out.println();
    }

    boolean matches(String kwd) {
        if (title.contains(kwd))
            return true;
        if (isbn.equals(kwd))
            return true;
        return false;
    }

}

//class EBook extends Book {
//    EBook(String tkn) {
//        super(tkn);
//    }
//    String url;
//    String format;
//
//    @Override
//    void read(Scanner scan) {
//        super.read(scan);
//        url = scan.next();
//        format = scan.next();
//    }
//
//    @Override
//    void print() {
//        super.print();
//    }
//
//    @Override
//    boolean matches(String kwd) {
//        if (super.matches(kwd))
//            return true;
//        if (url.contains(kwd))
//            return true;
//        if (format.equals(kwd))
//            return true;
//        return false;
//    }
//}