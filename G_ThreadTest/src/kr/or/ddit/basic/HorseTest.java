package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorseTest {
	static int horseRank = 0;
	// static String strRank = "";

	public static void main(String[] args) {
		Horse[] horse = new Horse[] { new Horse("1번말"), new Horse("2번말"), new Horse("3번말"), new Horse("4번말"),
				new Horse("5번말"), new Horse("6번말"), new Horse("7번말"), new Horse("8번말"), new Horse("9번말"),
				new Horse("10번말")

		};

		for (int i = 0; i < horse.length; i++) {
			horse[i].start();
		}

		for (Horse hor : horse) {
			try {
				hor.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("경기 끝..");
		System.out.println("--------------------------------------");
		System.out.println();

		List<Horse> list = new ArrayList<>();
		for (Horse hor : horse) {
			list.add(hor);
		}

		System.out.println("경기 결과");

		Collections.sort(list);

		for (Horse hor : list) {
			System.out.println(hor);
		}
		System.out.println("================================");

	}

}

class Horse extends Thread implements Comparable<Horse> {
	private String name;
	private int rank;

	public Horse(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Horse hor) {
		if (this.rank > hor.rank) {
			return 1;
		} else if (this.rank == hor.rank) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return rank + "등 : " + name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep((int) (Math.random() * 301 + 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// System.out.println(name + "이 " + i + "구간을 달리고 있습니다.");
			System.out.print(name);
			for (int j = 0; j < 10; j++) {
				if (i == j) {
					System.out.print(">");
				} else {
					System.out.print("-");

				}
			}
			System.out.println("|");

		}

		HorseTest.horseRank++;

		this.rank = HorseTest.horseRank;
		System.out.println(name + " 출력 끝...");
		// HorseTest.strRank += name + " ";

	}
}
