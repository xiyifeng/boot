package boot;

import java.lang.reflect.Field;

public class Ja {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		try {
			Class nd = Ja.class;
			Field dd = nd.getDeclaredField("name");
			System.out.println(dd);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
