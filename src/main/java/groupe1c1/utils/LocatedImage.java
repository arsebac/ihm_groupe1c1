package groupe1c1.utils;

import groupe1c1.CreateEnseigne;
import javafx.scene.image.Image;

import java.io.InputStream;

/**
 * @author Hasaghi
 * @date 06/03/2017
 */
public class LocatedImage extends Image {

	private final String urlLocated;

	public LocatedImage(InputStream stream, String url) {
		super(stream);
		this.urlLocated = url;
	}
	public String getUrl(){
		return urlLocated;
	}
	public static LocatedImage create(String url){
		return new LocatedImage(CreateEnseigne.class.getResourceAsStream(url),url);
	}
}
