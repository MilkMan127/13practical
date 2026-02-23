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
            start = System.nanoTime();
            linearSearch(randomKey);
            finish = System.nanoTime();

            time = (finish - start) / 1_000_000.0; 
            linearTime += time;
            linearTime2 += time * time;

            // ----- Binary Search Timing -----
            start = System.nanoTime();
            binarySearch(randomKey);
            finish = System.nanoTime();

            time = (finish - start) / 1_000_000.0; 
            binaryTime += time;
            binaryTime2 += time * time;
        }
         double linearAvg = linearTime / repetitions;
        double linearStd = Math.sqrt(
                (linearTime2 - repetitions * linearAvg * linearAvg)
                        / (repetitions - 1));

        double binaryAvg = binaryTime / repetitions;
        double binaryStd = Math.sqrt(
                (binaryTime2 - repetitions * binaryAvg * binaryAvg)
                        / (repetitions - 1));

        System.out.println("\nRESULTS");
        System.out.println("=====================================");
        System.out.println("Linear Search Average (ms): " + fiveD.format(linearAvg));
        System.out.println("Linear Search Std Dev (ms): " + fourD.format(linearStd));
        System.out.println();
        System.out.println("Binary Search Average (ms): " + fiveD.format(binaryAvg));
        System.out.println("Binary Search Std Dev (ms): " + fourD.format(binaryStd));
        System.out.println("=====================================");
    }
     public static void readFile(String filename) throws Exception {

        records = new Node[N];

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+", 2);
            int key = Integer.parseInt(parts[0]);
            String data = parts.length > 1 ? parts[1] : "";
            records[actualSize++] = new Node(key, data);
        }

        br.close();
    }
public static Node linearSearch(int key) {
        for (int i = 0; i < actualSize; i++) {
            if (records[i].key == key) {
                return records[i];
            }
        }
        return null;
    }
    public static Node binarySearch(int key) {

        int low = 0;
        int high = actualSize - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (records[mid].key == key)
                return records[mid];
            else if (records[mid].key < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }
}

