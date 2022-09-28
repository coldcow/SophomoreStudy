package lecture;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Student {
    String name;
    int id;
    String phone;
    int year;
    
    static Random rand = new Random();
    
    ArrayList<Lecture> registeredList = new ArrayList<>();
    public Student(int idCode) {
        id = idCode;
    }
    
    void read(Scanner scan,Department department) {
        name=scan.next();
        phone = scan.next();
        year = scan.nextInt();
        String code=null;
        Lecture lecture = null;
        while (true) {
            code= scan.next();
            if (code.contentEquals("0"))
                break;
            lecture= department.findLecture(code);
            if(lecture==null)
                {System.out.println("잘못된 코드입니다. "+code);
                continue;}
            registeredList.add(lecture);
        }
    }

    void print() {
        
        System.out.printf("%d %s %s (%d학년)", id, name, phone, year);
        System.out.println();
        for (Lecture mylec: registeredList) {
            System.out.print("\t");
            mylec.print();
            }
        }
    void printStudent() {
        System.out.printf("%s " ,name);
    }
    boolean matches(String kwd) {
        if(name.contains(kwd))
            return true;
        if(kwd.length()>3 && (id +"").contains(kwd))
            return true;
        if(kwd.length()>3 && phone.contains(kwd))
            return true;
        if((year +"").contentEquals(kwd))
            return true;
        return false;
    }
    
    boolean matches(String[] kwds) {
        for (String kwd : kwds) {
            if (kwd.charAt(0) == '-' && matches(kwd.substring(1)))
            return false;
            
            if(kwd.charAt(0)!= '-' && !matches(kwd))
                return false;
        }
        return true;
    }

    boolean containsLecture(Lecture lec) {
        return registeredList.contains(lec);
        
    }
    public boolean matchesDay(String kwd) {
        for(Lecture lec : registeredList) {
            if(lec.matches(kwd))
                return true;
        }
        return false;
    }
    

    
    
}