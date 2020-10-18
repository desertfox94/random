package de.desertfox.random;

import de.desertfox.random.names.Names;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Utils {

	public static List<String> load(String name) {
		ClassLoader classLoader = Names.class.getClassLoader();
		File file = new File(classLoader.getResource(name).getFile());
		Path path = file.toPath();
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
