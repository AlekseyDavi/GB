package HW.Lesson6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class HW6 {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        writeText("Text1.txt", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt");
        writeText("Text2.txt", "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        rewriteText("Text1.txt", "TextNew.txt");
        rewriteText("Text2.txt", "TextNew.txt");
        StringBuilder searchText = new StringBuilder();
        writeStringBuilder("TextNew.txt", searchText);
        String searchWord = scanner.nextLine();
        String search = searchText.toString();
        System.out.println(search);
        System.out.println("Слово " + searchWord + " есть в тексте? " + search.contains(searchWord));


    }

    public static void writeText(String nameText, String text) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(nameText);
            PrintStream ps = new PrintStream(fileOutputStream);
            ps.println(text);
            ps.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void rewriteText(String nameTextOut, String nameTextIn) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nameTextOut);
            int inputByteData;
            while ((inputByteData = fileInputStream.read()) != -1) {
                FileOutputStream fileOutputStream = new FileOutputStream(nameTextIn, true);
                PrintStream ps = new PrintStream(fileOutputStream);
                ps.print((char) inputByteData);
                ps.close();
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (IOException ioexception) {
            System.out.println(ioexception.getMessage());
        }

    }

    public static void writeStringBuilder(String nameTextOut, StringBuilder stringBuilderName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nameTextOut);
            int inputByteData;
            while ((inputByteData = fileInputStream.read()) != -1) {
                stringBuilderName.append((char) inputByteData);
            }
        } catch (IOException ioexception) {
            System.out.println(ioexception.getMessage());
        }

    }

}
