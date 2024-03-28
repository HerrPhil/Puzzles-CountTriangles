import java.util.*;

public class CountTriangles {

    public static void main(String [] args) {
        System.out.printf("Hello count triangles solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java CountTriangles%n");
        }
        int [] A = new int [] {10, 2, 5, 1, 8, 12};
        CountTriangles solution = new CountTriangles();
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

        for (int i = 0; i < N; i++) {


            for (int j = i + 1; j < N; j++) {

                int k = i + 1;

                System.out.printf("for next j before while-loop%n");
                System.out.printf("(P, Q, R) values are (%d, %d, %d)%n", i, j, k);
                System.out.printf("(A[P], A[Q], A[R]) values are (%d, %d, %d)%n", A[i], A[j], A[k]);

                // for every i and j we figure out the maximal k that can be a
                // triangular, and when we increase j the former k would still
                // be a triangular because of the sorted array, so we just need
                // to count the number of triangular between j and k.

                while (k < N && A[i] + A[j] > A[k]) {

                    iterations++;

                    System.out.printf("while-loop before k-increment%n");
                    System.out.printf("(P, Q, R) values are (%d, %d, %d)%n", i, j, k);
                    System.out.printf("(A[P], A[Q], A[R]) values are (%d, %d, %d)%n", A[i], A[j], A[k]);
                    
                    k++;

                    System.out.printf("while-loop after k-increment%n");
                    System.out.printf("(P, Q, R) values are (%d, %d, %d)%n", i, j, k);
                    if (k < N) {
                        System.out.printf("(A[P], A[Q], A[R]) values are (%d, %d, %d)%n", A[i], A[j], A[k]);
                    }
                }

                System.out.printf("result before k - j - 1 change is %d%n", result);
                result = result + (k - j - 1);
                System.out.printf("result after k - j - 1 change is %d%n", result);

            }

        }

        System.out.printf("Performance: iterations is %d%n", iterations);

        return result;
    }

}
