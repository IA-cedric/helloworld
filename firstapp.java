import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.utility.Delay;



public class firstapp {
	

	public static void main(String[] args) {
		GraphicsLCD g = BrickFinder.getDefault().getGraphicsLCD();
		g.drawString("bonjour monde",0,0,GraphicsLCD.VCENTER | GraphicsLCD.LEFT);
		Delay.msDelay(5000);
	}

}
