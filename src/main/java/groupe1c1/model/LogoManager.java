package groupe1c1.model;

import groupe1c1.utils.LocatedImage;

/**
 * @author Hasaghi
 * @date 13/03/2017
 */
public class LogoManager {
	private static LogoManager ourInstance = new LogoManager();
	private static String path;
	private static LocatedImage logo;
	private LogoManager() {
		path = "/images/logo2.png";
		logo = LocatedImage.create(path);
	}

	public static LogoManager getInstance() {
		return ourInstance;
	}

	public static LocatedImage getImage() {
		return logo;
	}
}
