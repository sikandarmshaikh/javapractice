package com.fp.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialization in Java example
 * Output:
 * 4
 * 5
 * 0
 * Here since the area variable is marked as transient, hence it is not stored in the Serialized file
 * Hence when deserialization happens its value is set to default value which 0 for int
 */
public class SerializableExample implements Serializable {
	int length, breadth;
	transient int area;
	public SerializableExample(int input1,int input2) {
		this.length = input1;
		this.breadth = input2;
		area = input1*input2;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//Serializing the Object
		FileOutputStream fos = new FileOutputStream("SerializableExample.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new SerializableExample(4, 5));
		oos.close();
		
		//Deserializing the Object
		FileInputStream fis = new FileInputStream("SerializableExample.ser");
		ObjectInputStream ois  = new ObjectInputStream(fis);
		SerializableExample se = (SerializableExample) ois.readObject();
		ois.close();
		System.out.println(se.length);
		System.out.println(se.breadth);
		System.out.println(se.area);
	}
}
