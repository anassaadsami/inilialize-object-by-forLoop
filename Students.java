package inilaizeObjectsByForLoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Students implements Comparable<Students> {
	String name;
	int age;

	public Students() { // another constructor if i need it

	}

	public Students(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// how to initialize objects by forLoop in static method
	public static Students[] addItems(Scanner input) {
		Students[] members = new Students[2];
		for (int i = 0; i < members.length; i++) {
			System.out.print("enter name, age for " + (i + 1) + " object: ");
			String name = input.next();
			int age = input.nextInt();
			members[i] = new Students(name, age); // we can code new Students(input.next(),input.nextIn()) the same
		}
		return members;
	}

	public static void printArrayItem(Students[] x) {
		for (int i = 0; i < x.length; i++) {
			// System.out.println(x[i]); // we get just the address of item
			System.out.println(x[i].toString()); // we get all information of object
		}
		System.out.println();
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Students s) { // to compare objects in array depends on it's name
		return this.name.compareTo(s.name);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Students[] members = null;
		String x;
		try {
			File f = new File("/Users/Hiba/Desktop/dataOfObjects/", "students_members");
		System.out.println("enter your next:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Students s = new Students();     // if the method of Students class is non static so this is the only way to invoke
			// these methods ex s.addItem(input)
//		printArrayItem(addItems(input));     // we can print directly without save the return value in array variable
			x = br.readLine();
			while (!x.equals("exit")) {
				try {
					BufferedWriter bwr = new BufferedWriter(new FileWriter(f, true)); // this constructor which takes
																						// boolean as parameter
					bwr.write(String.valueOf(members = addItems(input)));              // it means we will append to the end of the file
					bwr.newLine();                                                   // overwritten to all old data
																			// otherwise it will be
					printArrayItem(members);
					Arrays.sort(members); // to sort the items in array by it's name
					printArrayItem(members);
					bwr.close();
				} catch (IOException ie) {
					System.out.println(ie);
				}

				x = br.readLine(); // without this code it will be infinite loop ??
				br.close();
				input.close();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
