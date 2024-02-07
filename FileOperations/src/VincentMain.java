import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class VincentMain {
	
	static Scanner sc = new Scanner(System.in);
	static String mainFolderPath = "main/";

    static File mainFolder;

	public static void main(String[] args) {
		mainFolder = new File(mainFolderPath);

        if (!mainFolder.exists()) {
            boolean folderCreated = mainFolder.mkdirs();

            if (folderCreated) {
                System.out.println("Main folder created successfully.");
            } else {
                System.out.println("Failed to create the main folder.");
            }
        }
        
		System.out.println("Welcome!!");
		while(true) {
			System.out.println(
					"MENU:\n"
					+ "1. Retrieve all files inside main folder.\n"
					+ "2. Display Secondary Menu to perform file operations.\n"
					+ "3. Exit.");
			System.out.println("Please select an option in the above menu:");
			int option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
				case 1:
					retrieveAllFiles();
					break;
				case 2:
					displaySecondaryMenu();
					break;
				case 3:
					exit();
					break;
				default:
					System.out.println("Input correct menu entry and retry.");
					break;
			}
		}
	}

	private static void exit() {
		System.exit(0);
	}

	private static void displaySecondaryMenu() {
		Boolean flag = true;
		
		while (flag) {
			System.out.println(
					"SECONDARY MENU:\n"
					+ "1. Add file to main folder.\n"
					+ "2. Delete file from main folder.\n"
					+ "3. List files by search term.\n"
					+ "4. Return to previous menu.\n"
					+ "5. Exit.\n");
			System.out.println("Please select an option in the above menu:");
			
			int option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
				case 1:
					addFile();
					break;
				case 2:
					deleteFile();
					break;
				case 3:
					searchFiles();
					break;
				case 4:
					flag = false;
					break;
				case 5:
					exit();
					break;
				default:
					System.out.println("Input correct menu entry and retry.");
					break;
			}
		}
	}

	private static void searchFiles() {
		System.out.println("Enter filename to search: ");
		String keyword = sc.nextLine().strip();
		
		if (mainFolder.exists() && mainFolder.isDirectory()) {
            FilenameFilter filenameFilter = (dir, name) -> name.startsWith(keyword);

            String[] matchingFiles = mainFolder.list(filenameFilter);

            if (matchingFiles != null && matchingFiles.length > 0) {
                System.out.println("Matching files:");
                for (String fileName : matchingFiles) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("No files found with the specified keyword.");
            }
        } else {
            System.out.println("The specified folder does not exist or is not a directory.");
        }
	}

	private static void deleteFile() {
		System.out.println("Enter filename to delete: ");
		String fileName = sc.nextLine().strip();
		
		File targetFile = new File(mainFolderPath, fileName);

        if (targetFile.exists()) {
            boolean fileDeleted = targetFile.delete();

            if (fileDeleted) {
                System.out.println("File '" + fileName + "' has been successfully deleted.");
            } else {
                System.out.println("Failed to delete the file '" + fileName + "'.");
            }
        } else {
            System.out.println("The specified file does not exist.");
        }
	}

	private static void addFile() {
		System.out.println("Enter filename to add: ");
		String filename = sc.nextLine().strip();

        if (mainFolder.exists() && mainFolder.isDirectory()) {
            File newFile = new File(mainFolderPath, filename);

            try {
                boolean fileCreated = newFile.createNewFile();

                if (fileCreated) {
                    System.out.println("File '" + filename + "' has been successfully added to the folder.");
                } else {
                    System.out.println("File '" + filename + "' already exists in the folder.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file: " + e.getMessage());
            }
        } else {
            System.out.println("The specified target folder does not exist or is not a directory.");
        }
		
	}

	private static void retrieveAllFiles() {

        if (mainFolder.exists() && mainFolder.isDirectory()) {
            File[] files = mainFolder.listFiles();

            Arrays.sort(files);

            System.out.println("Files in ascending order:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("The specified main folder does not exist or is not a directory.");
        }	
      
	}

}
