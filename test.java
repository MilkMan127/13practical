import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;

public class timeMethods {

    static class Node {
        int key;
        String data;

        Node(int k, String d) {
            key = k;
            data = d;
        }
    }
    public static int N = 32654;   
    public static Node[] records;
    public static int actualSize = 0;

    public static void main(String args[]) throws Exception {

        readFile("ulysses.numbered");

        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double time;

        int repetitions = 30;
        Random rand = new Random();

        double linearTime = 0, linearTime2 = 0;
        double binaryTime = 0, binaryTime2 = 0;

        for (int r = 0; r < repetitions; r++) {

            int randomKey = rand.nextInt(32654) + 1;
