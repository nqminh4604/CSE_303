import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Interview {

    static Map<String, Integer> statics = new HashMap<>();

    public static String spinWheel() {
        // Elements to choose from (can be anything)
        String[] elements = {
                "Giai nhat", "Giai nhi", "Giai 3", "Giai 4",
                "Giai 5", "Giai 6", "Giai 7", "Giai 8"
        };

        // Corresponding probabilities (percentages)
        int[] probabilities = { 1, 4, 10, 15, 15, 15, 15, 25 };

        // Step 1: Create cumulative probability ranges
        int[] cumulativeProbabilities = new int[probabilities.length];
        int cumulativeSum = 0;
        for (int i = 0; i < probabilities.length; i++) {
            cumulativeSum += probabilities[i];
            cumulativeProbabilities[i] = cumulativeSum;
        }

        // Step 2: Generate a random number between 0 and 100
        Random random = new Random();
        int randNum = random.nextInt(100) + 1; // Random number between 1 and 100 (inclusive)

        // Step 3: Find which range the random number falls into
        for (int i = 0; i < cumulativeProbabilities.length; i++) {
            if (randNum <= cumulativeProbabilities[i]) {
                return elements[i];
            }
        }

        // Fallback, though it should never be reached if probabilities sum to 100
        return elements[elements.length - 1];
    }

    public static void main(String[] args) {
        // Test the function
        for (int i = 0; i < 100; i++) {
            String result = spinWheel();
            statics.put(result, statics.getOrDefault(result, 0) + 1);
            // System.out.println("The result of the spin is: " + result);
        }

        for (Map.Entry<String, Integer> e : statics.entrySet()) {
            System.out.println(e.getKey() +  " " + e.getValue());
        }
    }
}
