
public class Case {
	private int x;
	private int y;
	
	public Case(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getAbscisse(){
		return x;
	}
	public int getOrdonnee() {
		return y;
	}
	public Case est() {
		return new Case(x+1,y);
	}
	public Case nord() {
		return new Case(x,y-1);
	}
	public Case ouest() {
		return new Case(x-1,y);
	}
	public Case sud() {
		return new Case(x,y+1);
	}
	public Case[] voisines() {
		return new Case[] {ouest(),est(),sud(),nord()};
	}
	public boolean equals(Object o) {
		if(o instanceof Case) {
			return((Case) o).getAbscisse()==x&&((Case) o).getOrdonnee()==y;
		}
		return false;
	}
	public String toString() {
		return "("+x+","+" "+y+")";
	}
	
}
