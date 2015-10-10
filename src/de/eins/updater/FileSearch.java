package de.eins.updater;

import java.io.File;

public class FileSearch {
	public static File findNewJar(File dir) {
		File[] list = dir.listFiles();

		if (list != null) {
			for (File file : list) {
				if (file.getName() != null && file.getName().endsWith(".jar")) {
					return file;
				}
			}
		}
		return null;
	}
}
