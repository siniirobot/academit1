package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.MyClass.SerializationWithOverriding;
import ru.academItSchool.gorbunov.MyClass.SerializationWithoutOverriding;

import java.io.*;

public class FullSerializable {
    public static void main(String[] args) {
        SerializationWithoutOverriding myMatrix = new SerializationWithoutOverriding(new int[][]{
                {0, 1, 0, 1, 0, 0, 0, -1},
                {1, 0, 1, 0, 0, 0, -1, 0},
                {0, 1, 0, 1, 0, -1, 0, 0},
                {1, 0, 1, 0, -1, 0, 0, 0},
                {0, 0, 0, -1, 0, 1, 0, 1},
                {0, 0, -1, 0, 1, 0, 1, 0},
                {0, -1, 0, 0, 0, 1, 0, 1},
                {-1, 0, 0, 0, 1, 0, 1, 0}
        });

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.bin"))) {
            out.writeObject(myMatrix);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.bin"))) {
            SerializationWithoutOverriding a = (SerializationWithoutOverriding) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
