package polynomial;

import java.util.Scanner;

public interface Manageable {
	void read(Scanner scan);

	void print();

	void add(Scanner scan);

	int calc(int x);

	boolean compare(String name);
}
