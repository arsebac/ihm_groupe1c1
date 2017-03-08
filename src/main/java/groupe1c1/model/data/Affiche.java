package groupe1c1.model.data;

/**
 * @author Hasaghi
 * @date 06/03/2017
 */
public class Affiche{
	private String path;
	private String name;

	public Affiche(String name, String path) {
		this.path = path;
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Affiche{" +
				"path='" + path + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
