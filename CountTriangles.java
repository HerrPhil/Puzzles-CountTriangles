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
        int result = 0;

        return result;
    }

}
