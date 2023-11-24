public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz();
        testFizzBuzz();
    }

    public static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void testFizzBuzz() {
        System.out.println("Testing fizzBuzz method:");

        System.out.println("Case 1:");
        fizzBuzz();

        System.out.println("Test completed.");
    }

}