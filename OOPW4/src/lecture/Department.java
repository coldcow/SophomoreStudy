package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {

	Scanner in = new Scanner(System.in);
	ArrayList<Lecture> lectureList = new ArrayList<>();
	ArrayList<Student> studentList = new ArrayList<>();

	void run() {
		readAllLectures();
		readAll();
		
		searchMenu(in);
//		printAllLectures();
//		printAll();
//		searchStudentsByLecture();
//		searchDay();
//		countLectureStudents();
	}
	
	
	void searchMenu(Scanner scan) {
		String menu;
		int input;
		while (true) {
		System.out.print("(1) 학생 (2) 과목 (3) 연관검색 ");
		input = scan.nextInt();
		switch(input) {
		case 1: printAll();
			break;
		case 2: printAllLectures();
			break;
		case 3: associativeSearch(scan);
			break;
		}
		System.out.println("계속하라면 아무 키나 누르세요. (종료 0): "); 
		menu = scan.next(); 
		if (menu.equals("0"))
			break;	   
			} 
		}
	
	void associativeSearch(Scanner scan) {
		int input;
		System.out.format("연관검색 메뉴 (1) 과목별 수강생 (2) 요일별 수강생 (3) 타학년 과목 수강생수 조사 ");
		input = scan.nextInt();
		switch(input) {
		case 1: searchStudentsByLecture();
		break;
		case 2: searchDay();
		break;
		case 3: countLectureStudents();
		break;
		}
	}
	 
//	void debug() {
//		for (Lecture i : lectureList)
//			System.out.format("%s\n", i.lectureName);
//	}
	
	void countLectureStudents() {
		for (Lecture lec : lectureList) {
			lec.studentCount = 0;
			for (Student st : studentList) {		
				if (lec.year != st.year && st.containsLecture(lec))
					lec.studentCount += 1;
			}
			System.out.printf("[%s] %s %d학년 %s요일/%s %d명\n", lec.code, lec.lectureName, lec.year,
					lec.day, lec.time, lec.studentCount);
		}
		
	}

	void readAll() {
		int id = 0;
		while (true) {
			id = in.nextInt();
			if (id == 0)
				break;

			Student st = new Student(id);

			st.read(in, this);
			studentList.add(st);
		}
	}

	void printAll() {
		for (Student st : studentList) {
			st.print();
		}
	}

	Student findStudent(int num) {
		if (num <= 0 || num > studentList.size())
			return null;
		return studentList.get(num - 1);

	}

	void readAllLectures() {

		String code = null;
		while (true) {
			code = in.next();
			if (code.equals("end"))
				break;
			Lecture lec = new Lecture(code);
			lec.read(in);
			lectureList.add(lec);
		}
	}

	void printAllLectures() {
		System.out.println();
		for (Lecture lec : lectureList) {
			lec.print();
		}
		System.out.println();
	}

	public Lecture findLecture(String code) {
		for (Lecture lec : lectureList) {
			if (lec.matches(code))
				return lec;
		}
		return null;
	}

	/*
	 * void search() { String kwd; kwd=in.nextLine(); String[] kwdArr;
	 * 
	 * while (true) { System.out.print("팀 검색 키워드"); kwd = in.nextLine();
	 * 
	 * for (Team t: teamList) { if (t.matches(kwd)) { t.print(); } } } }
	 */
	



	void searchStudentsByLecture() {
		String kwd;
		
		System.out.print("검색할 과목: ");
		kwd = in.next();
		Lecture lecture = null;
		for (Lecture lec : lectureList) {
			if (lec.matches(kwd))
				lecture = lec;			
		}
		if (lecture == null) 
		{
				System.out.println("없는 과목명입니다");
				return;
		}
		lecture.print();
		
			for (Student st : studentList) {
				if (st.containsLecture(lecture)) {
					st.print();
				}
			}
		}
	
	
	void searchDay() {
		String kwd;
		
		System.out.print("검색할 요일: ");
		kwd = in.next();
		Lecture lecture = null;
		System.out.printf("%s요일 과목을 수강하는 학생:",kwd);
		for (Student st : studentList) {
			if (st.matchesDay(kwd))
				st.printStudent();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department m = new Department();
		m.run();
	}

}