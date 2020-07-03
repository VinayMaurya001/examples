package com.examples.programs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadAFileOfSizeGreaterThan1Gb {

	public static void main(String[] args) {
		try (FileInputStream inputStream = new FileInputStream("e:/abc.DAT");
				Scanner sc = new Scanner(inputStream, "UTF-8")) {
			int i = 0;
			while (sc.hasNextLine()) {
				i++;
				String line = sc.nextLine();
				if (i % 1000000 == 0)
					System.out.println(line);
			}
			System.out.println("ended");
			// Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
