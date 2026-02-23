import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;

class Node {
    int key;
    String data;

    Node(int k, String d) {
        key = k;
        data = d;
    }
}
public class timeMethods {

    public static int N = 32654;   // number of records

    static Node[] array = new Node[N];

    public static void main(String[] args) throws Exception {

        DecimalFormat fiveD = new DecimalFormat("0.00000");
        DecimalFormat fourD = new DecimalFormat("0.0000");
    }
}
BufferedReader br = new BufferedReader(
                new FileReader("ulysses.numbered"));

        String line;
        int index = 0;

        while ((line = br.readLine()) != null && index < N) {

            // assuming format: key space data
            String[] parts = line.split(" ", 2);

            int key = Integer.parseInt(parts[0]);
            String data = parts[1];

            array[index++] = new Node(key, data);
        }

        br.close();
 int repetitions = 30;
        Random rand = new Random();

        double linearTime = 0, linearTime2 = 0;
        double binaryTime = 0, binaryTime2 = 0;

        for (int i = 0; i < repetitions; i++) {

            int randomKey = 1 + rand.nextInt(32654);
