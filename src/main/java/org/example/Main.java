package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Task 01
        Student student = new Student("Phil", 23, 4);
        System.out.printf("Initial data: %s\n", student);
        FileOutputStream fileOutputStream = new FileOutputStream("data.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
        FileInputStream fileInputStream = new FileInputStream("data.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student student1 = (Student) objectInputStream.readObject();
        System.out.printf("Deserialized data from bin file: %s\n", student1);
        objectOutputStream.close();
        objectInputStream.close();
        System.out.println();
        // Task 02
        Student2 student2 = new Student2("Bob", 19, 4.5);
        System.out.printf("Initial data: %s\n", student2);

        Storage.save(student2);
        System.out.printf("Deserialized from json file: %s\n", Storage.loadJson());
        System.out.printf("Deserialized from xml file: %s\n", Storage.loadXml());

    }
}