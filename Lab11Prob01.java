
/**
* File: Lab11Prob1.java
* Class: CSCI 1302
* Author: Logan Galindo
* Created on: Nov 11, 2026
* Last Modified: Nov 11, 2026
* Description: Read the Binary file person.dat, display every record, and write a copy
*/
import java.io.*;

public class Lab11Prob01 {
	public static void main(String[] args) {
		try (
			DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/people-copy.dat")));
			DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("src/people.dat")));) {
			int age = 0;
			String name = " ";
			String address = " ";
			int zipCode = 0;
			double salary = 0;
			while (true) {
				age = input.readInt();
				name = input.readUTF();
				address = input.readUTF();
				zipCode = input.readInt();
				salary = input.readDouble();

				System.out.printf("%d %s %s %d %.2f%n", age, name, address, zipCode, salary);

				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(address);
				output.writeInt(zipCode);
				output.writeDouble(salary);
			}

		} catch (EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
