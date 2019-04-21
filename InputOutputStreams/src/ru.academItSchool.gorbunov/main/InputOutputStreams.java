package ru.academItSchool.gorbunov.main;

import java.io.*;

public class InputOutputStreams {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream inputStream =
                     new BufferedInputStream(
                             new FileInputStream("Властелин колец.txt"));
             BufferedOutputStream bufferedOutputStream =
                     new BufferedOutputStream(
                             new FileOutputStream("ГарриКопия.txt"))) {
            int read = 0;
            int off = 0;
            byte[] res = new byte[1000000];
            while ((read = inputStream.read(res, off, res.length - off)) != -1) {
                off += read;
            }
            bufferedOutputStream.write(res);
        }
    }
}
