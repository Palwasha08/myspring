
package edu.hccs.myspring;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MyspringApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(MyspringApplication.class, args);
		System.out.println("\nWelcome to Palwasha's Application!\n");
		List<Student> students = readStudents("https://hccs-advancejava.s3.amazonaws.com/student_course.json");
		Scanner sc = new Scanner(System.in);
		int choice;
		String flag = null;
		do {
			System.out.println(
					"\nPlease enter your choice\n" + "1: Search Student\n" + "2: Search Course\n" + "3: View GPA\n");
			do {
				choice = sc.nextInt();
				if (choice != 1 && choice != 2 && choice != 3)
					System.out.println("Please make a correct choice..");
			} while (choice != 1 && choice != 2 && choice != 3);

			if (choice == 1) {
				// finding a student
				System.out.println("Enter a student name to search: ");
				Boolean check = true;
				String name = sc.next();
				System.out.println("\nSearching ...\n");
				for (Student student : students) {
					if (student.getFirst_name().equalsIgnoreCase(name)) {
						System.out.println("Found!\n");
						System.out.println(student.toString());
						check = false;
						break;
					}
				}
				if (check)
					System.out.println("No Student Found!");
				System.out.println("\nPress 'Y' to go back to the Menu or 'N' to End Application");
				flag = sc.next();
			}
			if (choice == 2) {
				// finding a course
				Boolean check = true;
				System.out.println("Enter a course number to search: ");
				String course = sc.next();
				System.out.println("\nSearching ...\n");
				for (Student student : students) {
					if (student.getCourse() != null) {
						for (Course cr : student.getCourse()) {
							if (course.equalsIgnoreCase(cr.getCourseNo())) {
								System.out.println("Course found!");
								System.out.println(cr.toString());
								check = false;
								break;
							}
						}
					}
				}
				if (check)
					System.out.println("No Course Found!");
				System.out.println("\nPress 'Y' to go back to the Menu or 'N' to End Application");
				flag = sc.next();
			}
			if (choice == 3) {
				System.out.println("GPA of each student:");
				for (Student student : students) {
					double total = 0;
					if (student.getCourse() != null) {
						for (Course course : student.getCourse()) {
							total += getMarksFromGrades(course.getGrade());
						}
					}

					// getting the number of courses a student has
					int count = student.getCourse() == null ? 0 : student.getCourse().size();

					// calculating the average
					if (count != 0) {
						total = total / count;
					}
					System.out.printf("GPA of %s is %.2f\n", student.getFirst_name(), total);
				}
				System.out.println("\nPress 'Y' to go back to the Menu or 'N' to End Application");
				flag = sc.next();
			}
		} while (flag.equals("y") || flag.equals("Y"));
		System.out.println("Thank You!!");
		sc.close();
		ctx.close();
	}

	// this function reads the Students data from URL and returns Student List
	public static List<Student> readStudents(String url) {
		List<Student> students = null;
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<java.util.List<Student>> typeReference = new TypeReference<java.util.List<Student>>() {
		};
		try {
			students = mapper.readValue(new URL(url), typeReference);
			for (int index = 0; index < students.size(); index++) {
				System.out.println(students.get(index).toString());
			}
			System.out.println("Students data read successfully!");
		} catch (IOException e) {
			System.out.println("Unable to read Students data: " + e.getMessage());
		}
		return students;
	}

	// function to get marks from a given grade
	private static int getMarksFromGrades(String grade) {
		if (grade == null)
			return 0;
		// returns marks according to grads
		switch (grade) {
		case "A":
			return 4;
		case "B":
			return 3;
		case "C":
			return 2;
		default:
			return 0;
		}

	}
}
