package kyu7_8;

public class EvenorOdd {
    public static String evenOrOdd(int number) {
        if (number % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static void main(String[] args) {
        System.out.println(evenOrOdd(4)); // Example usage
        System.out.println(evenOrOdd(7)); // Example usage
    }
}
