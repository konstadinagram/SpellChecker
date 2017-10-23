import java.util.*;
public class Main {
    public static void s() {
		Scanner input=new Scanner(System.in);
		String t=input.nextLine();
		ArrayList <String> te=new ArrayList <String>();
	        ArrayList <Integer> location0 = new ArrayList <Integer>();
		int counter_0=0;
		for(int i=0;i<t.length();i++) {
			int j=0;
			if(Character.isWhitespace(t.charAt(i)))
			counter_0++; }
		}
	        for (int i=0; i<location0.length; i++) {
		    if(location0.contains(i)==false)
		        i=i+1; }
			else 
			word.add(t.charAt(i));
		System.out.println(counter_0);
		String[] parts = t.split(" ");
		String part1 = parts[0];
        String part2 = parts[1];
		//System.out.println(parts[0]);
		//System.out.println(parts[1]);
	}
		
    public static void main( String[] args){
	    /**h main stin opoia o xrhsths dinei ena keimeno aperiorisths xwritikothtas kai auto ektupwnetai sthn othonh */
      try {
        System.out.println("Please write a text");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        System.out.println("Your text is: ");
        System.out.println(text);
}    catch(InputMismatchException e){
	System.err.println("Please try again");
}
    s();
}
		
	}
}
