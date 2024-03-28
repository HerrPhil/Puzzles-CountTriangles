import java.util.*;

public class OptimizedCountTriangles {

    public static void main(String [] args) {
        System.out.printf("Hello optimized count triangles solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java OptimizedCountTriangles%n");
        }
        int [] A = new int [] {10, 2, 5, 1, 8, 12};
        OptimizedCountTriangles solution = new OptimizedCountTriangles();
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

        // use the built-in sort algorithm which can perform worst cas
        // O(N*log(N)) time complexity

        System.out.printf("array before sort%s%n", Arrays.toString(A));
        Arrays.sort(A);
        System.out.printf("array after sort%s%n", Arrays.toString(A));

        int result = 0;

        int iterations = 0;

        int comparisons = 0;

        for (int k = N - 1; k > 2; k--) {

            System.out.printf("for next k before while-loop%n");

            iterations++;

            for (int j = k - 1; j > 1; j--) {

                iterations++;

                int i = j - 1;

                System.out.printf("for next j before while-loop%n");

                System.out.printf("(P, Q, R) values are (%d, %d, %d)%n", i, j, k);
                if (i >= 0) {
                    System.out.printf("(A[P], A[Q], A[R]) values are (%d, %d, %d)%n", A[i], A[j], A[k]);
                } else {
                    System.out.printf("i value and (A[Q], A[R])  values are %d and (%d, %d)%n", i, A[j], A[k]);
                }

                // for every j and k we figure out the minimal i that can be a
                // triangular, and when we decrease j the former i would still
                // be a triangular because of the sorted array, so we just need
                // to count the number of triangular between i and j.

                while (i >= 0 && A[i] + A[j] > A[k]) {

                    iterations++;

                    comparisons += 2; // i >= 0 and A[i] + A[j] > A[k]

                    System.out.printf("while-loop before i-decrement%n");
                    System.out.printf("(P, Q, R) values are (%d, %d, %d)%n", i, j, k);
                    System.out.printf("(A[P], A[Q], A[R]) values are (%d, %d, %d)%n", A[i], A[j], A[k]);
                    
                    i--;

                    System.out.printf("while-loop after i-decrement%n");
                    System.out.printf("(P, Q, R) values are (%d, %d, %d)%n", i, j, k);
                    if (i >= 0) {
                        System.out.printf("(A[P], A[Q], A[R]) values are (%d, %d, %d)%n", A[i], A[j], A[k]);
                    } else {
                        System.out.printf("i value and (A[Q], A[R])  values are %d and (%d, %d)%n", i, A[j], A[k]);
                    }
                }


                System.out.printf("result before j - i - 1 = %d - %d - 1 change is %d%n", j, i, result);
                result = result + (j - i - 1);
                System.out.printf("result after j - i - 1 = %d - %d - 1 change is %d%n", j, i, result);

            }

        }

        System.out.printf("Performance: iterations is %d%n", iterations);
        System.out.printf("Performance: comparisons is %d%n", comparisons);

        return result;
    }

}
