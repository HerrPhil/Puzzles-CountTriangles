import java.util.*;

public class NaiveCountTriangles {

    public static void main(String [] args) {
        System.out.printf("Hello naive count triangles solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java NaiveCountTriangles%n");
        }
        int [] A = new int [] {10, 2, 5, 1, 8, 12};
        NaiveCountTriangles solution = new NaiveCountTriangles();
        int triangles = solution.countTriangles(A);
        System.out.printf("The number of triangles is %d%n", triangles);
    }


    public int countTriangles(int [] A) {
        // The time complexity in the simplest 3-loop algorithm is O(n^2),
        // because for every i the values of j and k increase O(n) number of times.

        int N = A.length;
        if (N < 3) {
            return 0;
        }

        System.out.printf("array input is %s%n", Arrays.toString(A));

        int result = 0;

        int iterations = 0;

        int comparisons = 0;

        for (int i = 0; i < N - 2; i++) {

            System.out.printf("for next i %d%n", i);

            iterations++;

            for (int j = i + 1; j < N - 1; j++) {

                iterations++;

                System.out.printf("for next j %d%n", j);

                for (int k = j + 1; k < N; k++) {

                    iterations++;

                    boolean triangularTest1 = A[i] + A[j] > A[k];
                    boolean triangularTest2 = A[j] + A[k] > A[i];
                    boolean triangularTest3 = A[i] + A[k] > A[j];

                    comparisons += 3;

                    // when all 3 tests pass, then the triplet is triangular
                    boolean isTriangular = triangularTest1 && triangularTest2 && triangularTest3;
                    if (isTriangular) {
                        System.out.printf("triplet (P, Q, R) = (%d, %d, %d)%n", i, j, k);
                        System.out.printf("(A[P], A[Q], A[R]) = (%d, %d, %d)%n", A[i], A[j], A[k]);
                        System.out.printf("is triangular!%n");
                        result++;
                    }
                }

            }

        }

        System.out.printf("Performance: iterations is %d%n", iterations);
        System.out.printf("Performance: comparisons is %d%n", comparisons);

        return result;
    }

}
