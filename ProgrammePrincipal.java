import java.util.Arrays;

public class ProgrammePrincipal {
	public static void main (String args[]) {
		Espace e= new Espace(10,7);
		Chenille c1 = new Chenille(e,5);
		Chenille c2 = new Chenille(e,9);
		System.out.println(e);
		for(int i=0;i<20;i++) {
			
			c1.avance();
			c2.avance();
			System.out.println(i+1);
			System.out.println(c1);
			System.out.println(c2);
			System.out.println(e);
		}
		
		
		
	}
}
