// 📊 4. Survey Analysis Tool
// Problem Statement:
// Write a program to collect user responses to a single-question survey (e.g., "How satisfied are you on a scale of 1–5?") and analyze the results.
// Constraints:
// Use a frequency array of size 5 (indices 0 to 4 for ratings 1 to 5).
// Accept up to 100 responses.
// Must validate responses (only 1 to 5 allowed).
// Output:
// Count of each rating
// Percentage of users per rating
// Visual bar chart (e.g., Rating 4: ****)
import java.util.*;

class surveyanalysistool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> freqmap = new HashMap<>();
        int responseCount = 0;
        while (responseCount < 10) {
            System.out.print("How satisfied are you on a scale of 1-5: ");
            int rating = sc.nextInt();
            if (rating > 5 || rating < 1) {
                System.out.print("Try again. Not in between 1 to 5.");
                rating = sc.nextInt();
                continue;
            } else {
                freqmap.put(rating, freqmap.getOrDefault(rating, 0) + 1);
                responseCount++;
                if (responseCount < 10) {
                    System.out.print("How satisfied are you on a scale of 1-5: ");
                    rating = sc.nextInt();
                }
            }
        }
        // Display results
        for (int i = 1; i <= 5; i++) {
            int count = freqmap.getOrDefault(i, 0);
            System.out.println("Rating " + i + ": " + count);
        }

        // Percentage of users per rating
        int total = 0;
        for (int i = 1; i <= 5; i++) {
            total += freqmap.getOrDefault(i, 0);
        }
        for (int i = 1; i <= 5; i++) {
            int count = freqmap.getOrDefault(i, 0);
            double percent = (count * 100.0) / total;
            System.out.printf("Rating %d: %.2f%%\n", i, percent);
        }
        sc.close();

        // visual bar chart
        for (int i = 1; i <= 5; i++) {
            int count = freqmap.getOrDefault(i, 0);
            System.out.print("Rating " + i + ": ");
            for (int j = 0; j < count; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
