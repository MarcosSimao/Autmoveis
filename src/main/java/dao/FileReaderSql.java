package dao;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderSql {
	private static  StringBuilder msg;

	public static String read(String fileName) {
        msg=new StringBuilder();
		File file = new File("sqls\\"+fileName+".sql");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				msg.append(sc.nextLine());
			}
			return msg.toString();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return null;

	}
	
}
