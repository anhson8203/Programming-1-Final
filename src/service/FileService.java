package service;

import java.io.*;

public class FileService {
    public Object readFile(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object readObj = objectIn.readObject();
            objectIn.close();
            return readObj;
        } catch (Exception ex) {
            return null;
        }
    }

    public Object writeFile(String filepath, Object fileContent) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(fileContent);
            objectOut.close();
            return 1;
        } catch (Exception ex) {
            return null;
        }
    }
}