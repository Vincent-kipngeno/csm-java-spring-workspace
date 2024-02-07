import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static String filePath = "students.ser";
	static Boolean first = true;
	
	public static void main(String[] args) {
		while (true) {
			System.out.println(
					"MENU:\n"
					+ "1. Store student's information.\n"
					+ "2. Display all students informations.\n"
					+ "3. Exit.");
			System.out.println("Please select an option in the above menu:");
			int option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
				case 1:
					storeStudentInfo();
					break;
				case 2:
					displayStudentInfo();
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
		System.out.println("System exited successfully.");
		System.exit(0);
	}

	private static void displayStudentInfo() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    Student student = (Student) ois.readObject();
                    System.out.println(student);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	private static void storeStudentInfo() {
		System.out.println("Enter student's full name:");
		String name = sc.nextLine();
		System.out.println("Enter student's id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter student's address:");
		String address = sc.nextLine();
		
		Student student = new Student(name, id, address);
		
		if (first) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            oos.writeObject(student);
	            System.out.println("Student object saved to file successfully.");
	            first = false;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		else {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath, true)) {
				protected void writeStreamHeader() throws IOException {
	                reset();
	            }
			}) {
	            oos.writeObject(student);
	            System.out.println("Student object saved to file successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}

}
