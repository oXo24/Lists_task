package task_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        LOGGER.info("\n" + chooser());
    }

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static String chooser() {
        Scanner scanner = new Scanner(System.in);
        String border = "══════════════════════════" + "\n";
        System.out.println("""
                What do you want to do?
                1-Show initial list;
                2-Show sorted list;
                3-Show both lists;
                Enter a action number:""");
        int answer = scanner.nextInt();
        if (answer == 1) {
            return printInitialList(providedData());
        } else if (answer == 2) {
            return printAlphabetSortedList(providedData());
        } else if (answer == 3) {
            return printInitialList(providedData()) + border + printAlphabetSortedList(providedData());
        } else return "Error occured";
    }

    private static ArrayList<String> providedData() {

        ArrayList<String> list = new ArrayList<>();
        list.add("John");
        list.add("Alice");
        list.add("Robert");
        list.add("Lisa");
        list.add("David");
        list.add("Amanda");
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

    private static String printAlphabetSortedList(ArrayList<String> list) {
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String element : list) {
            count++;
            sb.append(count).append(") ").append(element).append("\n");
        }
        return sb.toString();
    }

}
