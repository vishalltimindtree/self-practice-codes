import java.util.*;

public class Test {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Set<Integer> numbers = new HashSet<>();
            
            System.out.print("Enter number of data:");
            int data = scanner.nextInt();
            System.out.println("Enter " + data + " integers:");
            while (data != 0) {
                numbers.add(scanner.nextInt());
                data--;
            }

            System.out.println("Initial list: " + numbers);

            System.out.println("Enter a number to search:");
            int num = scanner.nextInt();

            if (numbers.contains(num)) {
                numbers.remove(num);
                System.out.println(num + " found and removed from the list.");
            } else {
                numbers.add(num);
                System.out.println(num + " not found and added to the list.");
            }

            System.out.println("Updated list: " + numbers);
        }
    }
}