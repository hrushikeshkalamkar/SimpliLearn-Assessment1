package Assessments;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AssessmentOne {
	public static void main(String[] args) {
		LockedMe();
	}

	public static void LockedMe() {

		String fileName = "";
		int choice;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("****************************\n");
		System.out.println("****Welcome to LockedMe****\n");
		System.out.println("****************************");

		do {
			System.out.println("");
			System.out.println("1. Retrieve files in Ascending order");
			System.out.println("2. Business Level Operation");
			System.out.println("3. Exit\n");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				File directory = new File("D:\\SimpliLearn\\");
				String files[] = directory.list();
				Arrays.sort(files);
				System.out.println("Existing files in the directory :");
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i]);
				}
				System.out.println();
				break;
			case 2:
				while (true) {
					System.out.println("1. Create a new File");
					System.out.println("2. Remove a File");
					System.out.println("3. Search");
					System.out.println("4. Return to Main Menu\n");
					int ch = sc.nextInt();
					if (ch == 1) {
						System.out.println("Please enter the file name\n");
						fileName = sc.next();
						File file = new File("D:\\SimpliLearn\\" + fileName + ".txt");

						if (file.exists()) {
							System.out.println("File already exists\n");
						} else {
							try {
								file.createNewFile();
								System.out.println("File created successfully\n");
							} catch (IOException e) {
								System.out.println("Please enter a valid file name");
								e.printStackTrace();
							}
						}

					} else if (ch == 2) {
						System.out.println("Enter the file name which you want to delete");
						fileName = sc.next();

						File file = new File("D:\\SimpliLearn\\" + fileName + ".txt");
						if (file.delete()) {
							System.out.println("File deleted successfully\n");
						} else {
							System.out.println("Failed to delete the file\n");
							System.out.println("File Not Found\ns");

						}

					} else if (ch == 3) {
						System.out.println("Enter the file  name with .txt extention to search\n");
						fileName = sc.next();
						File dir = new File("D:\\SimpliLearn\\");
						int count = 0;
						String files1[] = dir.list();
						for (String string : files1) {
							if (string.equalsIgnoreCase(fileName)) {
								System.out.println("File Found: "+fileName);
								count++;
								break;
							}
						}
						if (count == 0) {
							System.out.println("File Not Found");

						}
					} else if (ch == 4) {
						break;
					} else {
						System.out.println("Invalid option");
					}
				}
				break;
			case 3:
				System.out.println("Thank You for visiting LockedMe.com");
				break;
			default:
				System.out.println("Invalid option");
			}
		} while (choice != 3);

	}

}
