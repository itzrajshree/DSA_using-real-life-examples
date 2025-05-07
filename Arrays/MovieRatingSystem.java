/*🎬 3. Movie Rating System
Problem Statement:
Design a system where users can rate multiple movies. Calculate the average rating of each movie and find the top-rated movie.

Constraints:
Use a 2D array, where rows represent users (max 10), and columns represent movies (max 5).
Ratings range from 1 to 5.
Must handle missing ratings (e.g., if a user didn't rate a movie).
Output should include average rating per movie and identify top-rated movie.*/
import java.util.*;

public class Movieratingsystem {
    static Scanner sc = new Scanner(System.in);
    private int users;
    private int movies;
    private int[][] movie_rating;

    Movieratingsystem(int users, int movies) {
        this.users = users;
        this.movies = movies;
        movie_rating = new int[users][movies];
    }

    void add_ratings() {
        for (int i = 0; i < users; i++) {
            System.out.println("Enter ratings for User " + (i + 1) + ":");
            for (int j = 0; j < movies; j++) {
                System.out.print("Movie " + (j + 1) + " Rating (1-5, or 0 if not rated): ");
                int rating = sc.nextInt();
                while (rating < 0 || rating > 5) {
                    System.out.print("Invalid rating. Enter again (1-5, or 0 if not rated): ");
                    rating = sc.nextInt();
                }
                movie_rating[i][j] = rating;
            }
        }
        System.out.println("Ratings added successfully.\n");
    }

    void avg_rating() {
        int highestAvg = -1;
        int topMovieIndex = -1;

        for (int j = 0; j < movies; j++) {
            int total = 0;
            int count = 0;
            for (int i = 0; i < users; i++) {
                int rating = movie_rating[i][j];
                if (rating != 0) {
                    total += rating;
                    count++;
                }
            }

            if (count == 0) {
                System.out.println("Movie " + (j + 1) + " has not been rated by any user.");
                continue;
            }

            int avg = total / count;
            System.out.printf("Movie %d Average Rating: %d\n", j + 1, avg);

            if (avg > highestAvg) {
                highestAvg = avg;
                topMovieIndex = j;
            }
        }

        if (topMovieIndex != -1) {
            System.out.println("Top-rated movie: Movie " + (topMovieIndex + 1));
        } else {
            System.out.println("No movies have been rated.");
        }
    }

    public static void main(String[] args) {
        System.out.print("Number of users (max 10): ");
        int users = sc.nextInt();
        System.out.print("Number of movies (max 5): ");
        int movies = sc.nextInt();

        if (users > 10 || movies > 5 || users <= 0 || movies <= 0) {
            System.out.println("Invalid input. Max users = 10, max movies = 5.");
            return;
        }

        Movieratingsystem mv = new Movieratingsystem(users, movies);
        mv.add_ratings();
        mv.avg_rating();
    }
}
