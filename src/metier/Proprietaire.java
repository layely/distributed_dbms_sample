package metier;

public class Proprietaire {

    private int numProprietaire;
    private String nom;
    private String prenom;
    private String address;
    private String tel;
    private String mail;
    private String password;

    public int getNumProprietaire() {
        return numProprietaire;
    }

    public void setNumProprietaire(int numProprietaire) {
        this.numProprietaire = numProprietaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
