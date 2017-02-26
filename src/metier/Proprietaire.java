package metier;

public class Proprietaire {
	private int numProprietaire;
	private String nomP;
	private String prenomP;
	private String address;
	private String tel;
	private String mail;
	public Proprietaire(int numProprietaire, String nomP, String prenomP,
			String address, String tel, String mail) {
		super();
		this.numProprietaire = numProprietaire;
		this.nomP = nomP;
		this.prenomP = prenomP;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
	}
	public int getNumProprietaire() {
		return numProprietaire;
	}
	public void setNumProprietaire(int numProprietaire) {
		this.numProprietaire = numProprietaire;
	}
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	public String getPrenomP() {
		return prenomP;
	}
	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
