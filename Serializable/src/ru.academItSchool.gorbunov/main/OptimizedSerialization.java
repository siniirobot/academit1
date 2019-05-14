package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.MyClass.SerializationWithOverriding;

import java.io.*;

public class OptimizedSerialization {
    public static void main(String[] args) {
        SerializationWithOverriding myMatrix = new SerializationWithOverriding(new int[][]{
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3}
        });
        System.out.println(myMatrix);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out2.bin"))) {
            out.writeObject(myMatrix);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("out2.bin"))) {
            SerializationWithOverriding a = (SerializationWithOverriding) in.readObject();
            System.out.println(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
