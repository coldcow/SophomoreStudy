import java.util.*;

public class Lotto {
	Scanner scan = new Scanner(System.in);
	ArrayList<Buyer> buyerList = new ArrayList<>();
	Random random = new Random();
	static int[] lottery = new int[6];

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		
		lotto.readAll();
		lotto.lottoDraw();
		lotto.matchCount();
		lotto.checkPlace();
		lotto.printLottery();
		lotto.printAll();	
	}

	void readAll() {
		Buyer buyer = null;
		int input;
		while (true) {
			try {
				input = scan.nextInt();
				if (input == 0) {
					break;
				}
			} catch (Exception e) {
				buyer = new Buyer();
				lottoGenerate(buyer);
				buyer.read(scan);
				buyerList.add(buyer);
			}
		}
	}

	void lottoGenerate(Buyer buyer) {
		
		for (int i = 0; i < 6; i++) {
			int randNum = random.nextInt(45) + 1;
			buyer.lottoNum[i] = randNum;
			for (int j = 0; j < i; j++) {
				int num = buyer.lottoNum[j];
				if (randNum == num) {
					i--;
					break;
				}
			}
		}
// 		±³¼ö´Ô ÄÚµå		
//		int i =0;
//		int n;
//		while(i < 6) {
//			n = random.nextInt(45) + 1;
//			if (contains(buyer.lottoNum, n, i))
//				continue;
//			buyer.lottoNum[i++] = n;
//		}
		
	}

	void lottoDraw() {
		
		for (int i =0; i< 6; i++) {
			int randNum = random.nextInt(45) + 1;
			lottery[i] = randNum;
			for (int j = 0; j < i; j++) {
				if (randNum == lottery[j]) {
					i--;
					break;
				}
			}			
		}
	}
	
	void printLottery() {
		System.out.format("ÃßÃ·¹øÈ£ [");
		for (int i=0; i<6; i++)
			System.out.format("%3d", lottery[i]);
		System.out.format("]\n");
	}

	void printAll() {
		for (Buyer buyer : buyerList) {
			buyer.print();
		}
	}

	void matchCount() {
		for (Buyer buyer : buyerList) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
				if (buyer.lottoNum[j] == lottery[i])
					buyer.matchingCount++;
				}
			}
		}
	}

	void checkPlace() {
		for (Buyer buyer : buyerList) {
			switch (buyer.matchingCount) {
			case 3:
				buyer.place = 5;
				break;
			case 4:
				buyer.place = 4;
				break;
			case 5:
				buyer.place = 3;
				break;
			case 6:
				buyer.place = 1;
				break;
			}
		}
	}

}