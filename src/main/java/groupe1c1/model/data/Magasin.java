package groupe1c1.model.data;

import java.io.Serializable;

/**
 * Représentation d'un magasin
 * @author David LANG
 */
public class Magasin implements Serializable {

    private String Name;
    private String pathImage;
    private String horaires;
    private String adresse;

    public Magasin(String name, String pathImage, String horaires, String adresse) {
        Name = name;
        this.pathImage = pathImage;
        this.horaires = horaires;
        this.adresse = adresse;
    }

    public String getName() {
        return Name;
    }

    public final String getPathImage() {
        return pathImage;
    }

    public final String getHoraires() {
        return horaires;
    }

    public final String getAdresse() {
        return adresse;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
