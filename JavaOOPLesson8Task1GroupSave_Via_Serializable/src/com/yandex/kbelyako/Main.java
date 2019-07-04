/*3. Усовершенствуйте класс, описывающий группу студентов, добавив возможность сохранения группы в файл.
4. Реализовать обратный процесс. Т.е. считать данные о группе из файла, и на их основе создать объект типа группа.*/


package com.yandex.kbelyako;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Human person1 = new Human();
		//Human person2 = new Human("Petr", "Ivanovich", "Ivanov", 19, "male");
	//	System.out.println(person2);
		
		// student1=person2;
	//System.out.println(student1);
		Group testGroup = new Group();
		//System.out.println(testGroup);
		
		Student student1 = new Student("Petr", "Ivanovich", "Ivanov", 19,
				"male");
		System.out.println(student1.toString());

		Student student2 = new Student("Evgeniy", "Ivanovich", "Gurin", 19,
				"male");
		
		Student student3 = new Student("Vasiliy", "Aleksandrovich", "Arbuzov",
				19, "male");
		student3.setfName("Alex");
		Student student4 = new Student("Aleksey", "Olegovich", "Vasiliyev", 19,
				"male");
		Student student5 = new Student("Dmitri", "Ivanovich", "Ivanov", 18,
				"male");
		Student student6 = new Student("Olga", "Petrovna", "Kravtsova", 21,
				"female");
		Student student7 = new Student("Petr", "Ivanovich", "Bublikov", 22,
				"male");
		Student student8 = new Student("Vasiliy", "Aleksandrovich", "Kaverin",
				19, "male");
		Student student9 = new Student("Aleksey", "Ivanovich", "Ivanov", 17,
				"male");
		Student student10 = new Student("Dmitri", "Olegovich", "Afanasiev", 18,"male");
				
		Student student11 = new Student("Olga", "Petrovna", "Romashkina", 19,
				"female");
		
			testGroup.addstudent(student1, 1);
			testGroup.addstudent(student2, 2);
			testGroup.addstudent(student10, 10);
			testGroup.addstudent(student3, 3);
			testGroup.addstudent(student5, 5);
			testGroup.addstudent(student9, 9);
		/*	testGroup.addstudent(student4, 4);
			
			testGroup.addstudent(student6, 6);
			testGroup.addstudent(student7, 7);
			testGroup.addstudent(student8, 8);
			
	
			testGroup.addstudent(student11, 11);
			testGroup.addstudent(student11, 12);
			testGroup.addstudent(student11, 13);
			testGroup.addstudent(student1, 1);*/
	
		System.out.println(testGroup);
		//testGroup.addstudent(student11, 13);

/*		try {

			testGroup.addstudent(student1, 1);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}*/
testGroup.rmvStudent(-11);
//System.out.println(testGroup);
//testGroup.rmvStudent(1);
//testGroup.rmvStudent(1);


testGroup.addstudent(student4, 4);
testGroup.addstudent(student6, 6);
testGroup.addstudent(student7, 7);
//testGroup.addstudent(student8, 8);

//testGroup.sorbysName();
//testGroup.toStringTable();
//
//testGroup.sortByParam(1);
//
//
//testGroup.toStringTable();
//
//testGroup.sortByParam(2);
//testGroup.rmvStudent(5);
//
//
//testGroup.toStringTable();
//testGroup.sortByParam(3);
//testGroup.sortByParam(-83);
//testGroup.addstudentInteractive(5);
//testGroup.toStringTable();


//testGroup.getMilReadyStudents();

//testGroup.addstudent(student3, 3);


testGroup.setName("testGroup1");
testGroup.toStringTable();
testGroup.saveToFile();

Group  groupFromFile1 = new Group("GroupfromFile1");
File t = new File("testGroup1.txt");
groupFromFile1=Group.loadGroup(t);
groupFromFile1.toStringTable();

try(ObjectOutputStream OOS=new ObjectOutputStream(new FileOutputStream("fil"))){
OOS.writeObject(testGroup);
} catch(IOException e){
System.out.println("ERROR save group !!!");
}

Group  groupFromFile2 = new Group("GroupfromFile2");
groupFromFile2=null;

try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream("fil"))){
	groupFromFile2=(Group)OIS.readObject();
} catch(IOException |
ClassNotFoundException e){
System.out.println("ERROR load group !!!");
}

groupFromFile2.toStringTable();



	}

}