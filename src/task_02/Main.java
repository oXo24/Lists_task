package task_02;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        LOGGER.info("\n" + chooser());
    }

    private static final Logger LOGGER = Logger.getLogger(task_01.Main.class.getName());

    public static String chooser() {
        Scanner scanner = new Scanner(System.in);
        String border = "══════════════════════════" + "\n";
        System.out.println("""
                What do you want to do?
                1-Show initial list;
                2-Show part of the list;
                3-Show both list and a part of it;
                Enter a action number:""");
        int answer = scanner.nextInt();
        if (answer == 1) {
            return printInitialList(providedData());
        } else if (answer == 2) {
            return printCroppedList(providedData(), chooseFirstIndex(), chooseSecondIndex());
        } else if (answer == 3) {
            return printInitialList(providedData()) + border + printCroppedList(providedData(),
                    chooseFirstIndex(), chooseSecondIndex());
        } else return "Error occured";
    }

    private static ArrayList<String> providedData() {

        ArrayList<String> list = new ArrayList<>();
        list.add("Orange");
        list.add("Mango");
        list.add("Banana");
        list.add("Apple");
        list.add("Kiwi");
        list.add("Cherry");
        return list;
    }

    private static String printInitialList(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String element : list) {
            count++;
            sb.append(count).append(") ").append(element).append("\n");
        }
        return sb.toString();
    }

    private static String printCroppedList(ArrayList<String> list, int firstIndex, int secondIndex) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String element : list.subList(firstIndex, secondIndex)) {
            count++;
            sb.append(count).append(") ").append(element).append("\n");
        }
        return sb.toString();
    }

    public static int chooseFirstIndex() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Enter first index of cropped list""");
        return scanner.nextInt();

    }

    public static int chooseSecondIndex() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Enter last index of cropped list (excluded)""");
        return scanner.nextInt();

    }
}
