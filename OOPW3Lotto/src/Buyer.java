import java.util.*;

public class Buyer {
	String name;
	String phone;
	int [] lottoNum = new int[6];
	int matchingCount = 0;
	int place = 0;
	
	public Buyer () {
		
	}
	

	void read(Scanner scan) {
		name = scan.next();
		phone = scan.next();
	}
	
	void print() {
		System.out.printf("%s ", phone);
		System.out.format("[");
		for (int i = 0; i<6; i++)
			System.out.format("%3d", lottoNum[i]);
		System.out.format("]");
		System.out.format(" ==> (%d°³) %dµî\n", matchingCount, place);
		
	}
}
