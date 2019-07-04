package com.yandex.kbelyako;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Faculty {

	private Group[] faculty;
	private String name;

	public void saveGroupToFile(Group group, String fileName) {

		try (ObjectOutputStream OOS = new ObjectOutputStream(
				new FileOutputStream(fileName))) {
			OOS.writeObject(group);
		} catch (IOException e) {
			System.out.println("ERROR save group !!!");
		}

	}

	public void loadGroupFromFile(Group group, String fileName) {

		try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream(fileName))){
			group=(Group)OIS.readObject();
		} catch(IOException |
		ClassNotFoundException e){
		System.out.println("ERROR load group !!!");
		}

	}
	
}
