package com.app.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesUtil {	
	public static List<String> readTextFileByLines(String filename) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filename));
		return lines;
	}
	
	public static void writeToTextFile(String filename, String dataName) throws IOException {
		Files.write(Paths.get(filename), dataName.getBytes());
	}
	
}
