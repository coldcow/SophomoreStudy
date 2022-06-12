import java.util.*;

public class JavaStudy {
	public static void main(String[] args) {
		HashMap<String, Double> manage = new HashMap<String, Double>();
		Set<String> key = manage.keySet();
		Iterator<String> it = key.iterator();
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<5; i++) {
			System.out.println("name and grade >> ");
			String name = sc.next();
			double grade = sc.nextDouble();
			manage.put(name, grade);
		}
		System.out.println("Scholarship criteria >> ");
		double criteria = sc.nextDouble();
		
		while(it.hasNext()) {
			String stName = it.next();
			if (manage.get(stName) > criteria) {
				System.out.println(stName);
			}
		}
		
	}
}

// EXERCISE 3
//Vector<Integer> precipitation = new Vector<Integer>();
//Scanner sc = new Scanner(System.in);
//
//while (true) {
//	int sum = 0;
//	System.out.println("Input precipitation (Exit on input 0) >> ");
//	int input = sc.nextInt();
//	if (input == 0)
//		break;
//	precipitation.add(input);
//	
//	for (int i=0; i<precipitation.size(); i++) {
//		sum += precipitation.get(i);
//		System.out.println(precipitation.get(i));
//	}
//	System.out.println("Average " + sum / precipitation.size());
//}

// EXERCISE 2
//HashMap<String, Integer> country = new HashMap<String, Integer>();
//Scanner sc = new Scanner(System.in);
//
//while (true) {
//	System.out.println("Country name, Population >> ");
//	String countryName = sc.next();
//	if (countryName.equals("Stop"))
//		break;
//	int population = sc.nextInt();
//	country.put(countryName, population);
//}
//
//while (true) {
//	System.out.println("Search >> ");
//	String countryName = sc.next();
//	if (countryName.equals("Stop"))
//		break;
//	if (country.containsKey(countryName))
//		System.out.println(country.get(countryName));
//	else
//		System.out.println("No information");
//}
//System.out.println("Program end");

// EXERCISE 1
//ArrayList<Character> grade = new ArrayList<Character>();
//Scanner sc = new Scanner(System.in);
//float sum = 0;
//System.out.println("6개의 학점 입력 >>");
//String input = sc.nextLine().replace(" ", "");
//
//for(int i=0; i<6; i++) {
//	grade.add(input.charAt(i));
//	char c = grade.get(i);
//	switch(c) {
//	case 'A':
//		sum += 4;
//		break;
//	case 'B':
//		sum += 3;
//		break;
//	case 'C':
//		sum += 2;
//		break;
//	case 'D':
//		sum += 1;
//		break;
//	}
//}
//System.out.println(sum / 6);