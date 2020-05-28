package com.company.model;

import javax.swing.*;
import java.io.*;

public class Serializer {
    public void serialize(Disc disc) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("discSerialized.txt")
            );
            objectOutputStream.writeObject(disc);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Disc deserialize() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("discSerialized.txt"));
            try {
                Disc discRestored = (Disc) objectInputStream.readObject();
                return discRestored;
            } catch (ClassNotFoundException e ) {
                System.out.println("There was an error!");
            }
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
