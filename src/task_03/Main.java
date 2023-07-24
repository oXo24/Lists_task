package task_03;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        LOGGER.info("\n" + chooser());
    }

    private static final Logger LOGGER = Logger.getLogger(task_01.Main.class.getName());

    public static String chooser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                What do you want to do?
                1-Show initial list;
                2-Add item to the beginning of the list and show the list;
                3-Add item to the end of the list and show the list;
                4-Add item to the beginning and ending of the list and show it;
                Enter a action number:""");
        int answer = scanner.nextInt();
        if (answer == 1) {
            return printInitialList(providedData());
        } else if (answer == 2) {
            return formAnswer(addBeginning(providedData(), newListElement()));
        } else if (answer == 3) {
            return formAnswer(addEnding(providedData(), newListElement()));
        } else if (answer == 4) {
            return formAnswer(addBoth(providedData()));
        } else return "Error occured";
    }

    private static LinkedList<String> providedData() {

        LinkedList<String> list = new LinkedList<>();
        list.add("Orange");
        list.add("Grape");
        list.add("Apple");
        list.add("Lemon");
        return list;
    }

    private static String printInitialList(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String element : list) {
            count++;
            sb.append(count).append(") ").append(element).append("\n");
        }
        return sb.toString();
    }

    private static LinkedList<String> addBeginning(LinkedList<String> list, String newElement) {
        list.addFirst(newElement);
        return list;
    }

    private static String formAnswer(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String element : list) {
            count++;
            sb.append(count).append(") ").append(element).append("\n");
        }
        return sb.toString();
    }

    private static LinkedList<String> addBoth(LinkedList<String> list) {
        list.addFirst(newListElement());
        list.addLast(newListElement());
        return list;
    }

    private static LinkedList<String> addEnding(LinkedList<String> list, String newElement) {
        list.addLast(newElement);
        return list;
    }

    public static String newListElement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Enter name of the item you want to add to the list""");
        return scanner.next().trim();

    }
}
