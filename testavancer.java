import java.util.Scanner;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import lejos.hardware.motor.BaseRegulatedMotor;


public class testavancer {
	
	static RegulatedMotor m1 = new EV3LargeRegulatedMotor(MotorPort.A);
	static RegulatedMotor m2 = new EV3LargeRegulatedMotor(MotorPort.C);
	
	static RegulatedMotor [] synclist = {m2};
	

	
	public static void tournerD() {
		m2.flt();
		m1.rotate(420);

	}
	public static void tournerG() {
		m1.flt();
		m2.rotate(420);

	}
	public static void demiTG(){
		m1.flt();
		m2.rotate(830);
		
	}
	public static void demiTD() {
		m2.flt();
		m1.rotate(830);
	}
	public static void avancer1() {
		m1.startSynchronization();
		m1.forward();
		m2.forward();
		m1.endSynchronization();
		Delay.msDelay(5000);
		ralentir();
	}
	public static void avancer2() {
		m1.startSynchronization();
		m1.forward();
		m2.forward();
		m1.endSynchronization();
		Delay.msDelay(10000);
		ralentir();
	}
	public static void avancer3() {
		m1.startSynchronization();
		m1.forward();
		m2.forward();
		m1.endSynchronization();
		Delay.msDelay(15000);
		ralentir();
	}
	public static void ralentir() {
		m1.startSynchronization();
		m1.flt();
		m2.flt();
		m1.endSynchronization();
	}
	public static void arretT() {
		m1.startSynchronization();
		m1.stop();
		m2.stop();
		m1.endSynchronization();
	}
	public static void commander(int c) {
		switch(c) {
		case 1 : avancer1(); break;
		case 2 : avancer2(); break;
		case 3 : tournerD(); break;
		case 4 : tournerG(); break;
		case 5 : arretT(); break;
		}
	}
	public static void vitesse() {
		m1.startSynchronization();
		m1.setSpeed((int) m1.getMaxSpeed());
		m2.setSpeed((int) m2.getMaxSpeed());
	}
	public static void commandeEnTempsReel() {
		int i =1;
		Scanner s = new Scanner(System.in);
		int commande;
		while(i!= 0) {
			System.out.println("que doit faire cedric ?");
			System.out.println("1 = avancer1 / 2 = avancer2");
			System.out.println("3 = tournerD / 4 = tournerG");
			System.out.println("5 = arretT / 6 = sortir");
			commande = s.nextInt();
			if(commande == 6) {
				i=0;
			}
			else if(commande == 1 || commande == 2 || commande ==3 || commande == 4 || commande == 5) {
				commander(commande);
			}
			else {
				System.out.println("Mauvaise entre veuillez recommencer ! ");
			}
		}
	}

	public static void main(String[] args) {
		m1.synchronizeWith(synclist);
		avancer1();
		tournerD();
		tournerD();
		avancer1();
		demiTD();
		arretT();
			
		
        
		

	}

}
