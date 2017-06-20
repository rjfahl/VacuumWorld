import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		staticWorldExample1();
		staticWorldExample2();
		random();
	}
	
	public static void random(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Floor width: ");
		int x = scan.nextInt();
		
		System.out.print("Enter Floor height: ");
		int y = scan.nextInt();
		
		Vacuum vac = new Vacuum();
		new Environment(vac, x, y);
		scan.close();
	}
	
	public static void staticWorldExample1(){
		Square s1 = new Square(true);
		Square s2 = new Square(true);
		Square s3 = new Square(true);
		Square s4 = new Square(true);
		Square w1[][] = { { s1, null, null }, { s2, s3, s4 } };
		s1.setSouth(s2);
		s2.setNorth(s1);
		s2.setEast(s3);
		s3.setWest(s2);
		s3.setEast(s4);
		s4.setEast(s3);
		
		Vacuum vac = new Vacuum();
		new Environment(vac, w1);
	}
	
	public static void staticWorldExample2(){
		Square s1 = new Square(false);
		Square s2 = new Square(true);
		Square s3 = new Square(false);
		Square s4 = new Square(true);
		Square s5 = new Square(false);
		Square s6 = new Square(true);
		Square s7 = new Square(false);
		Square s8 = new Square(true);
		Square w2[][] = { { s1, s2, s3 }, { s4, null, s5 }, { s6, s7, s8 }};
		s1.setEast(s2);
		s2.setWest(s1);
		s2.setEast(s3);
		s3.setWest(s2);
		s1.setSouth(s4);
		s4.setNorth(s1);
		s3.setSouth(s5);
		s5.setNorth(s3);
		s6.setEast(s7);
		s7.setWest(s6);
		s7.setEast(s8);
		s8.setWest(s7);
		s6.setSouth(s4);
		s4.setNorth(s6);
		s5.setSouth(s8);
		s8.setNorth(s5);
		
		Vacuum vac = new Vacuum();
		new Environment(vac, w2);
		}

}