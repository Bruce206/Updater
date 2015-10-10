package de.eins.updater;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Start {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

		Thread.sleep(3000);

		// PrintStream out = new PrintStream(new FileOutputStream("log.txt"));
		// System.setOut(out);
		// System.setErr(out);

		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();

		// benötigte Daten:
		String jarPath = args[0].replace('\\', '/');
		File jarFile = new File(jarPath);

		File newJar = FileSearch.findNewJar(dir);

		Files.move(newJar.toPath(), jarFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarPath);
		pb.start();

	}
}
