package de.eins.updater;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Start {

	public static void main(String[] args) throws URISyntaxException, IOException {

		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();

		// benötigte Daten:
		String jarDir = args[0];
		String jarName = args[1];
		File newJar = FileSearch.findNewJar(dir);

		String path = dir.toString();

		System.out.println(f.getName());
		System.out.println(path);

		File file = new File(path + "/test" + args[0] + ".txt");
		file.createNewFile();

		ProcessBuilder pb = new ProcessBuilder("java", "-jar", path + args[1], "123", "welt");
		pb.start();

	}
}
