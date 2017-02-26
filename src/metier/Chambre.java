package metier;

public class Chambre extends Logement{
	private int numChambre;
	private boolean avecBalcon;
	private boolean avectoilette;
	public int getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(int numChambre) {
		this.numChambre = numChambre;
	}
	public boolean isAvecBalcon() {
		return avecBalcon;
	}
	public void setAvecBalcon(boolean avecBalcon) {
		this.avecBalcon = avecBalcon;
	}
	public boolean isAvectoilette() {
		return avectoilette;
	}
	public void setAvectoilette(boolean avectoilette) {
		this.avectoilette = avectoilette;
	}
	public Chambre(int numChambre) {
		super();
		this.numChambre = numChambre;
	}
	
}
