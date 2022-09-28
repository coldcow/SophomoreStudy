package lecture;

import java.util.Scanner;

public class Lecture {
    String code;
    String lectureName;
    int year;
    String day;
    String time;
    int studentCount;
    
    Lecture(String code) {
        this.code = code;
    }

    void read(Scanner scan) {

        lectureName = scan.next();
        year = scan.nextInt();
        day = scan.next();
        time = scan.next();

    }

    void print() {
        System.out.printf("[%s] %s %d학년 %s요일 %s\n", code, lectureName, year, day, time);
    }

    boolean matches(String kwd) {
        if (code.contains(kwd))
            return true;
        if (lectureName.contains(kwd))
            return true;
        if (kwd.contentEquals("" + year))
            return true;
        if (kwd.contentEquals(day))
            return true;
        if (kwd.contentEquals(time))
            return true;
        return false;
    }

}