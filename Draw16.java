import java.util.*;
import java.io.*;

public class Draw16 {
	LinkedList<Club> pool1; 
	LinkedList<Club> pool2;
	int sum;
	
	// Post: create a new instance
	public Draw16() {
		this.pool1 = new LinkedList<Club>();
		this.pool2 = new LinkedList<Club>();
		this.sum = 0;
	}
	
	// Post: add the top 16 clubs to the pool
	public void getData() {
		pool1.add(new Club("ManUnited", "England", 1, 'A'));
		pool2.add(new Club("Basel", "Swiss", 2, 'A'));
		
		pool1.add(new Club("ParisSG", "France", 1, 'B'));
		pool2.add(new Club("Bayern", "Germany", 2, 'B'));
		
		pool1.add(new Club("ASRoma", "Italy", 1, 'C'));
		pool2.add(new Club("Chelsea", "England", 2, 'C'));
		
		pool1.add(new Club("Barcelona", "Spain", 1, 'D'));
		pool2.add(new Club("Juventus", "Italy", 2, 'D'));
		
		pool1.add(new Club("Liverpool", "England", 1, 'E'));
		pool2.add(new Club("Servilla", "Spain", 2, 'E'));
		
		pool1.add(new Club("ManCity", "England", 1, 'F'));
		pool2.add(new Club("Donetsk", "Ukraine", 2, 'F'));
		
		pool1.add(new Club("Besiktas", "Turkey", 1, 'G'));
		pool2.add(new Club("Porto", "Portugal", 2, 'G'));
		
		pool1.add(new Club("Tottenham", "England", 1, 'H'));
		pool2.add(new Club("RealMadrid", "Spain", 2, 'H'));
		
		
	}
	
	// Post: explore all possible combinations and print out with the given output PrintStream
	public void draw(PrintStream output) {
		drawHelper(pool1, pool2, new LinkedList<Club>(), output);
	}
	
	// Post: helper method of draw
	private void drawHelper(LinkedList<Club> p1, LinkedList<Club> p2, LinkedList<Club> chosen, PrintStream output) {
		if (p1.isEmpty() && p2.isEmpty()) {
			printHelper(chosen, output);
		} else {
			Club c1 = p1.removeFirst();
			for (int i = 0; i < p2.size(); i++) {
				Club c2 = p2.remove(i);
				if (c1.canPlayAgainst(c2)) {
					chosen.add(c1);
					chosen.add(c2);
					drawHelper(p1, p2, chosen, output);
					chosen.removeLast();
					chosen.removeLast();
				}
				p2.add(i, c2);
			}
			p1.addFirst(c1);
		}
	}
	
	// Post: for one chosen combination, print it in standard format with given PrintStream output
	private void printHelper(LinkedList<Club> chosen, PrintStream output) {
		for (int i = 0; i < chosen.size() / 2; i++) {
			output.println(chosen.get(i * 2) + " VS " + chosen.get(i * 2 + 1));
		}
		output.println();
	}
	
	public void printProb(File inputFile) throws FileNotFoundException {
		Scanner input = new Scanner(inputFile);
		int[][] allPair = new int[pool1.size()][pool2.size()];
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (!line.isEmpty()) {
				String[] c = line.split(" ");
				int i = c[0].charAt(c[0].length() - 3) - 'A';
				int j = c[2].charAt(c[2].length() - 3) - 'A';
				allPair[i][j]++;
			} else {
				sum++;
			}
		}
		System.out.println("Sum = " + sum);
		System.out.print("            ");
		for (int i = 0; i < pool2.size(); i++) {
			String c2 = pool2.get(i).toString();
			System.out.printf("%-10s", c2.substring(0, c2.length() - 4));
		}
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < pool1.size(); i++) {
			String c1 = pool1.get(i).toString();
			System.out.printf("%-12s", c1.substring(0, c1.length() - 4));
			for (int j = 0; j < pool2.size(); j++) {
				System.out.printf("%-10.6f", allPair[i][j] * 1.0 / sum);
			}
			System.out.println();
			System.out.println();
		}
	}
	
	// Post: for testing and printing
	public static void main(String[] args) throws FileNotFoundException {
		Draw16 obj = new Draw16();
		obj.getData();
		File ballot = new File("draws.txt");
		obj.draw(new PrintStream(ballot));
		obj.printProb(ballot);
	}
}
