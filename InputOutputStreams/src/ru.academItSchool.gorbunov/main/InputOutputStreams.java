package ru.academItSchool.gorbunov.main;

import java.io.*;

public class InputOutputStreams {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream inputStream =
                     new BufferedInputStream(
                             new FileInputStream("ГарриПоттер.txt"));
             BufferedOutputStream bufferedOutputStream =
                     new BufferedOutputStream(
                             new FileOutputStream("ГарриКопия.txt"));
             PrintWriter out = new PrintWriter("Строки.txt")) {
            int read;
            byte[] res = new byte[1000000];
            while ((read = inputStream.read(res)) != -1) {
                bufferedOutputStream.write(res,0,read);
                bufferedOutputStream.flush();
            }

            for (int i = 1; i <= 100; i++ ) {
                out.println("Строка " + i);
            }
            out.print("Это последняя строка.");
            out.println("Но это еще не конец.");
            out.printf("Тут %d строка",101);
        }
    }
}
