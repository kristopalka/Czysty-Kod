package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSort_SOLUTION {
    private static ArrayList<Integer> input, output;

    public static void sort() {
        getDataFromUser();
        sortAscending();
        writeData();
    }

    private static void getDataFromUser() {
        Scanner scanner = new Scanner(System.in);
        input = new ArrayList<>();

        System.out.print("Type number of elements: ");
        int numberOfElements = scanner.nextInt();

        System.out.println("Type all elements:");
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            int number = scanner.nextInt();
            data.add(number);
        }
    }

    private static void sortAscending() {
        output = new ArrayList<>();

        int numberOfElements = input.size();
        for (int i = 0; i < numberOfElements; i++) {
            findMinAndRewrite();
        }
    }

    private static void findMinAndRewrite() {
        int indexOfMin = indexOfMinElement(input);
        int alementToRevrite = input.get(indexOfMin);

        output.add(alementToRevrite);
        input.remove(indexOfMin);
    }

    private static int indexOfMinElement(ArrayList<Integer> list)
    {
        int indexOfMin = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < list.get(indexOfMin)) {
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    private static void writeData() {
        System.out.println("Sorted data:");
        for (int element : output) {
            System.out.print(element + " ");
        }
    }

}
