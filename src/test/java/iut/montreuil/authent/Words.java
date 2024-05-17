package iut.montreuil.authent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Words {
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    static void generate(StringBuilder sb, int n) throws IOException {
        if (n == sb.length()) {
            writeStringIntoFile(sb.toString());
            return;
        }
        for (char letter : alphabet) {
            sb.setCharAt(n, letter);
            generate(sb, n + 1);
        }
    }

    public static void methodOne() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int length = 2; length <= 12; length++) {
            sb.setLength(length);
            generate(sb, 0);
        }
    }
    public static void main(String[] args) throws IOException {
        //Words.printWords(10);
        Words.methodOne();
    }

    public static void writeStringIntoFile(String word) throws IOException {
        FileWriter fileName = new FileWriter("C:\\JohnTheRipper\\pwd.txt", true);
        BufferedWriter writer = new BufferedWriter(fileName);
        writer.append(' ');
        writer.write(word);
        writer.close();
    }
    public static void printWords(int length) throws IOException {
        if (length < 1)
            throw new IllegalArgumentException();
        printWordsRec("", length);
    }

    private static void printWordsRec(String base, int length) throws IOException {
        for (char c = 'a'; c <= 'z'; c++) {
            if (length == 1) {
                writeStringIntoFile(base + c);
            } else {
                printWordsRec(base + c, length - 1);
            }
        }
    }
}
