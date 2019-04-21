package ru.academItSchool.gorbunov.main;

import java.io.*;

public class InputOutputStreams {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream inputStream =
                     new BufferedInputStream(
                             new FileInputStream("ГарриПоттер.txt"));
             BufferedOutputStream bufferedOutputStream =
                     new BufferedOutputStream(
                             new FileOutputStream("ГарриКопия.txt"))) {
            int read = 0;
            int off = 0;
            byte[] res = new byte[10];
            while ((read = inputStream.read(res, off, res.length - off)) != -1) {
                off += read;
                bufferedOutputStream.write(res);
                bufferedOutputStream.flush();
            }
        }
    }
}
