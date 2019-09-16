import java.util.Random;
public class Espace {
	private int largeur;
	private int hauteur;
	private Chenille[] tabChenille;
	int nbChenille;
	public Espace() {
		largeur=10;
		hauteur=10;
		nbChenille=0;
		tabChenille= new Chenille[5];
	}
	public Espace(int x) {
		largeur=x;
		hauteur=x;
		nbChenille=0;
		tabChenille= new Chenille[5];
	}
	public Espace(int x, int y) {
		largeur=x;
		hauteur=y;
		nbChenille=0;
		tabChenille= new Chenille[5];
	}
	public void addChenille(Chenille c) {
		if(nbChenille==tabChenille.length) {
			Chenille[] tabChenilleBis = tabChenille;
			tabChenille = new Chenille[tabChenilleBis.length+5];
			for(int i=0;i<nbChenille;i++) {
				tabChenille[i]=tabChenilleBis[i];
			}
		}
		tabChenille[nbChenille]=c;
		nbChenille++;
	}
	public boolean contient(Case c) {
		return((c.getAbscisse()>=0)
				&&(c.getAbscisse()<largeur)
				&&(c.getOrdonnee()>=0)
				&&(c.getOrdonnee()<hauteur));
	}
	public boolean caseOccupee (Case c) {
		for(int i =0; i<nbChenille;i++) {
			if(tabChenille[i].estSur(c)) return true;
		}
		return false;
	}
	public Case caseAuHasard() {
		Random r = new Random();
		int x = r.nextInt(largeur);
		int y = r.nextInt(hauteur);
		return new Case(x,y);
		
	}
	public Case caseLibreAuHasard() {
		Case c = caseAuHasard();
		if (!caseOccupee(c)) {
			return c;
		}
		return caseLibreAuHasard();
	}
	public String toString() {
		String ch= "";
		Case c;
		for(int i =0; i<hauteur;i++) {
			for(int j= 0; j<largeur;j++) {
				c = new Case(j,i);
				if(caseOccupee(c)) {
					for(int x =0;x<nbChenille;x++) {
						if(tabChenille[x].estSur(c)) {	
							if(c.equals(tabChenille[x].getCases()[0])) {
								ch=ch+ (char) (65+x);
							}else {
								ch=ch+ (char) (97+x);
							}
							x=nbChenille;
						}
							
					}
				}else {
					ch=ch+".";
				}
			}
			ch=ch+"\n";
		}
		return ch;
	}
	
}
