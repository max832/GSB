package InterfaceG;

// Classe
public class ObjtVisiteur {
 private String id;
 private String login;
 private String mdp;
 private String fonction;
 private String region;
//****************************************************************
 
 // Constructeur
public ObjtVisiteur(String id, String login, String mdp, String fonction, String region) {

	this.id = id;
	this.login = login;
	this.mdp = mdp;
	this.fonction = fonction;
	this.region = region;
}
public ObjtVisiteur() {
	
}
// Fonction de renvoie des données
//****************************************************************

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
//****************************************************************

public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
//****************************************************************

public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
//****************************************************************

public String getFonction() {
	return fonction;
}
public void setFonction(String fonction) {
	this.fonction = fonction;
}
//****************************************************************

public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}
//****************************************************************

}