/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todotask;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Az
 */
public class ToDoTask {

    /**
     * @param args the command line arguments
     */
    static String str, command, toDO, task;
    static ArrayList<String> my_toDo = new ArrayList<String>();
    static Integer Size_arr = 0;

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        while (true) {
            str = sc.nextLine();
            String[] inputArray = str.split("\\s+");
            Size_arr = inputArray.length;
            if (str != null) {
                task=inputArray[0];
                command = inputArray[1];
                command = command.toLowerCase();
                task = task.toLowerCase();
            }

            if (inputArray.length == 2 && command.equals("list")) {
                List_console();
            }

            if (command.equals("add") || command.equals("done") || command.equals("list")) {
                if (command.equals("add")) {
                    toDO = Trim_add(str);
                    my_toDo.add(toDO);
//                    System.out.println(my_toDo.toString());
                    System.out.println("Created task " + my_toDo.size());
                }
                if (command.equals("done") && Size_arr >= 3) {
                    Done(inputArray[1]);
                }
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public static String Trim_add(String str2) {
        str2 = (String) str2.subSequence(9, str2.length());
        return str2;
    }

    public static String List_console() {
        System.out.println("ID Description");
        System.out.println("_ _  _ _ _ _ _ " + "\n");
        for (int i = 0; i < my_toDo.size(); i++) {
            System.out.println(my_toDo.indexOf(my_toDo.get(i)) + 1 + " " + my_toDo.get(i));
        }
        System.out.println("task " + my_toDo.size());
        return null;
    }

    public static void Done(String DeleteId) {
        if (isNumer(DeleteId)) {
            int id = Integer.parseInt(DeleteId);
            if (id <= my_toDo.size() && my_toDo.isEmpty() == false && id >= 1) {
                my_toDo.remove(id - 1);
            }
        }
    }

    public static boolean isNumer(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
