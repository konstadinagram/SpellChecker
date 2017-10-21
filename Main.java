import java.util.*;
public class Main {
    public static void s() {
		Scanner input=new Scanner(System.in);
		String t=input.nextLine();
		ArrayList <String> te=new ArrayList <String>();
		int counter_0=0;
		for(int i=0;i<t.length();i++) {
			int j=0;
			if(Character.isWhitespace(t.charAt(i))){
			counter_0++; }
		}
		System.out.println(counter_0);
		String[] parts = t.split(" ");
		String part1 = parts[0];
        String part2 = parts[1];
		//System.out.println(parts[0]);
		//System.out.println(parts[1]);
	}
	public static void main(String args[]) {
		System.out.println("hi");
		s();
	}
}