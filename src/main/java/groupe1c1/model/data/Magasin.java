package groupe1c1.model.data;

import java.io.Serializable;

/**
 * Représentation d'un magasin
 *
 * @author David LANG
 */
public class Magasin implements Serializable {

	private String Name;
	private String pathImage;
	private String centreCommercial;
	private String adresse;
	private String telephone;
	private String mail;
	private String siteWeb;

	public Magasin(String name, String pathImage, String centreCommercial, String adresse, String telephone, String mail, String siteWeb) {
		Name = name;
		this.pathImage = pathImage;
		this.centreCommercial = centreCommercial;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
		this.siteWeb = siteWeb;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public final String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public final String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCentreCommercial() {
		return centreCommercial;
	}

	public void setCentreCommercial(String centreCommercial) {
		this.centreCommercial = centreCommercial;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
}
