package com.yandex.kbelyako;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Group implements  Comparator<Human>, Military,Serializable {

	private Student[] group1 = new Student[10];

	public Group() {
		super();

	}

	public Student[] getGroup1() {
		return group1;
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public void setGroup1(Student[] group1) {
		this.group1 = group1;
	}

	public Group(Student[] group1) {
		super();
		this.group1 = group1;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toStringSorted() {

		return "Group [group1=" + Arrays.toString(sort(group1)) + "]";

	}

	@Override
	public String toString() {

		return "Group [group1=" + Arrays.toString(group1) + "]";
	}

	public void toStringTable() {
		System.out.println("Group name: " + getName());
		for (int i = 0; i <= 9; i++) {
			System.out.println(i + 1 + " " + group1[i]);

		}

	}

	public void addstudent(Student student, int i) {

		if (i - 1 > 10) {
			try {
				throw new MyException();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (i - 1 < 10) {
			if (group1[i - 1] == null) {
				group1[i - 1] = student;
			} else
				System.out
						.println("Position "
								+ i
								+ " is already busy in this group, please delete student from this position first or try to add student to another position");

		}
	}

	public void addstudentInteractive(int i) {

		Student newStudent = new Student();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		try {
			newStudent.setfName(in.next());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("Enter student last name: ");
		newStudent.setlNname(in.next());
		System.out.print("Enter student patronymic: ");
		newStudent.setPatronymic(in.next());
		System.out.print("Enter student sex: ");
		newStudent.setSex(in.next());
		System.out.print("Enter student age: ");
		newStudent.setAge(in.nextInt());
		if (i - 1 > 10) {
			try {
				throw new MyException();
			} catch (MyException e) {

				e.printStackTrace();
			}
		}

		if (i - 1 < 10) {
			if (group1[i - 1] == null) {
				group1[i - 1] = newStudent;
			} else
				System.out
						.println("Position "
								+ i
								+ " is already busy in this group, please delete student from this position first or try to add student to another position");

		}
	}

	public void rmvStudent(int i) {
		try {
			if (group1[i - 1] != null) {
				group1[i - 1] = null;
			} else
				System.out.println("Position " + i
						+ " is already empty in this group");

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out
					.println("Not possible to delete student from this position, because it's out of range 1..10");
		}
	}

	public Student[] sortNulls(Student[] group) {
		Student[] groupNew = group;
		boolean isSorted = false;
		Student buf;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < groupNew.length - 1; i++) {
				if ((groupNew[i] == null) && (groupNew[i + 1] != null)) {
					isSorted = false;
					buf = groupNew[i];
					groupNew[i] = groupNew[i + 1];
					groupNew[i + 1] = buf;
				} else {
					continue;
				}
			}
		}
		return groupNew;

	}

	public Student[] sort(Student[] group) {

		Student[] groupNew = sortNulls(group);

		boolean isSorted = false;
		Student buf;

		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < groupNew.length - 1; i++) {
				if ((groupNew[i] != null) && (groupNew[i + 1] != null)) {
					if (groupNew[i].getlName().charAt(0) > groupNew[i + 1]
							.getlName().charAt(0)) {
						isSorted = false;
						buf = groupNew[i];
						groupNew[i] = groupNew[i + 1];
						groupNew[i + 1] = buf;
					}
				}

				else {
					continue;
				}
			}
		}
		return groupNew;
	}

	public void sorbysName() {
		Arrays.sort(group1);

	}

	@Override
	public int compare(Human o1, Human o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void sortByParam(int option) {

		Comparator<Human> ageComparator = new Comparator<Human>() {

			@Override
			public int compare(Human h1, Human h2) {
				return (int) (h1.getAge() - h2.getAge());
			}
		};

		Comparator<Human> fNameComparator = new Comparator<Human>() {

			@Override
			public int compare(Human h1, Human h2) {
				return h1.getfName().compareTo(h2.getfName());
			}
		};
		if (option == 1) {
			Arrays.sort(group1, ageComparator);
		}

		if (option == 2) {
			Arrays.sort(group1, fNameComparator);
		}

		else {
			System.out.println("Wrong sort option !!!");
		}
		;

	}

	public String findStudentOutString(String lName) {
		Student result = null;
		int counter = 0;

		String strResult = "Search result for last name " + lName + ":";
		for (int i = 0; i <= 9; i++) {
			if (group1[i] != null) {
				if (group1[i].getlName() == lName) {
					result = group1[i];
					counter = counter + 1;
					strResult = strResult + (char) 0x0D + result.toString();

				}
			} else
				continue;

		}
		if (result == null) {
			strResult = strResult + (char) 0x0D
					+ "No such student in this group";
		}
		return strResult;

	}

	public Student[] findStudent(String lName) {
		int counter = -1;
		Student[] fresult = new Student[10];
		for (int i = 0; i <= 9; i++) {

			if (group1[i] != null) {
				if (group1[i].getlName() == lName) {
					counter = counter + 1;
					fresult[counter] = group1[i];
				}
			}
		}
		Student[] ffresult = new Student[counter + 1];
		java.lang.System.arraycopy(fresult, 0, ffresult, 0, counter + 1);

		return ffresult;
	}

	@Override
	public Student[] getMilReadyStudents() {
		Student[] fresult = new Student[10];
		int i = 0;
		for (Student student : group1) {
			if (student == null) {
				continue;
			} else {
				if (student.getSex() == "male" && student.getAge() >= 18) {
					fresult[i] = student;
					i = i + 1;
				}
			}
		}
		System.out.println(Arrays.toString(fresult));
		return fresult;
	}

	public void saveToFile() {
		String fileName = "";
		Scanner in = new Scanner(System.in);
		if (getName() == null) {
			System.out.print("Group has no name, please enter group name: ");
			fileName = (in.next());
			setName(fileName);
		} else
			fileName = (getName());

		try (PrintWriter a = new PrintWriter(fileName + ".txt")) {
			for (int i = 0; i < group1.length; i++) {
				if (group1[i] == null)
					a.println();
				else
					a.println(group1[i].toStringToFile());
				// a.println("Green Lamp");
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}

	}

	public static String FiletoString(File f) {
		String[] strinArray = new String[10];
		String str2 = "";
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String str1 = "";
			for (; (str1 = br.readLine()) != null;) {
				if (str2 != "")
					str2 = str2 + ";" + str1;
				else
					str2 = str2 + str1;
			}
		} catch (IOException e) {
			e.printStackTrace();
			// System.out.println("ERROR");
		}
		return str2;

	}

	public static Student studentFromString(String inputString) {

		Student student = new Student("Dummy", "Dummy", "Dummy", 19, "Dummy");

		if (inputString != "") {
			String[] parametrs = inputString.split(" ");

			student.setfName(parametrs[0]);
			student.setlNname(parametrs[2]);
			student.setPatronymic(parametrs[1]);
			student.setSex(parametrs[4]);
			student.setAge(Integer.parseInt(parametrs[3]));
		} else
			student = null;

		return student;
	}

	public static Group groupFromString(String inputString) {
		Group resGroup = new Group();
		String[] array = inputString.split(";");
		// System.out.println("Array: "+Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(""))
				continue;
			else {
				// System.out.println("������� ������� �������:"+" "+i+" "+array[i]);
				resGroup.addstudent(Group.studentFromString(array[i]), i + 1);
			}
			//
		}
		return resGroup;
	}

	public static  Group loadGroup(File inputFile) {
		Group resGroup = new Group();
		//resGroup.setName(name);
		resGroup = Group.groupFromString(Group.FiletoString(inputFile));
		 resGroup.setName(stripExtension(inputFile.getName()));
		return resGroup;
	}

	static String stripExtension(String str) {
		if (str == null)
			return null;
		int pos = str.lastIndexOf(".");
		if (pos == -1)
			return str;
		return str.substring(0, pos);

	}

}