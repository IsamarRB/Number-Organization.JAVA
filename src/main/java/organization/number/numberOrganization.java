package organization.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class numberOrganization {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Integer> numbers = new ArrayList<>();
            String option;

            // Prompt the user to enter numbers
            System.out.println("Enter numbers (one by one). To stop entering numbers, type 'end':");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("end")) {
                    break;
                }
                try {
                    int number = Integer.parseInt(input);
                    if (number == 4) {
                        System.out.println("The number 4 is not allowed. Try again.");
                    } else {
                        numbers.add(number);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            // Ask for the order of the list
            System.out.println("Do you want to sort the list in ascending or descending order? (asc/desc):");
            option = scanner.nextLine();

            // Sort the list according to the user's option
            if (option.equalsIgnoreCase("asc")) {
                bubbleSort(numbers, true);
            } else if (option.equalsIgnoreCase("desc")) {
                bubbleSort(numbers, false);
            } else {
                System.out.println("Invalid option. The list will be sorted in ascending order by default.");
                bubbleSort(numbers, true);
            }

            // Display the sorted list
            System.out.println("Sorted list: " + numbers);
        }
    }

    // Method to sort the list using the bubble sort algorithm
    public static void bubbleSort(ArrayList<Integer> list, boolean ascending) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending) {
                    if (list.get(j) > list.get(j + 1)) {
                        Collections.swap(list, j, j + 1);
                    }
                } else {
                    if (list.get(j) < list.get(j + 1)) {
                        Collections.swap(list, j, j + 1);
                    }
                }
            }
        }
    }
}
