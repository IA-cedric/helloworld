import java.util.Random;
import java.util.Arrays;
public class Chenille {
	Case[] caseOccupe;
	Espace espace;
	int taille;
	
	public Chenille(Espace e) {
		this(e,10);
	}
	public Chenille(Espace e, int x) {
		this(e,x,e.caseLibreAuHasard());
	}
	public Chenille(Espace e, int x, Case c) {
		espace=e;
		caseOccupe= new Case[x];
		caseOccupe[taille]=c;
		taille++;
		espace.addChenille(this);
	}
	public boolean estSur(Case c) {
		for(int i=0;i<taille;i++) {
			if(c.equals(caseOccupe[i])) {
				return true;
			}
		}
		return false;
	}
	public Case[] getCases() {
		return caseOccupe;
	}
	public boolean caseVoisineLibre(Case[] voisins) {
		for(int i=0; i<voisins.length;i++) {
			if((!espace.caseOccupee(voisins[i]))&&espace.contient(voisins[i])) {
				return true;
			}
		}
		return false;
	}
	public void avance() {
		Case[] voisins = caseOccupe[0].voisines();
		if(!caseVoisineLibre(voisins)) {
			throw new RuntimeException("La chenille ne peut plus avancer.");
		}
		Random r = new Random();
		Case c;
		int x;
		if(taille==caseOccupe.length) {
			x=taille-2;
		}else {
			x=taille-1;
			taille++;
		}
		for(int i=x; i>=0;i--) {
			caseOccupe[i+1]=caseOccupe[i];
		}
		for(int i=0;i<1;i=i) {
			c=voisins[r.nextInt(4)];
			if((!espace.caseOccupee(c))&&espace.contient(c)) {
				caseOccupe[0]=c;
				i++;
			}
		}
	}
	public String toString() {
		return "Chenille("+taille+"/"+caseOccupe.length+") : "+Arrays.deepToString(caseOccupe);
	}
}
