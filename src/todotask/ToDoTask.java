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
 * dorjazjargal@gmail.com
 */
public class ToDoTask {

    /**
     * @param args the command line arguments
     */
    static String str, command, toDO, task, input2, tempStr;
    static ArrayList<String> my_toDo = new ArrayList<String>();
    static Integer Size_arr = 0;
    static Boolean Checked = false;

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        while (true) {
            str = sc.nextLine();
            str = str.trim(); // эхлэл төгсгөлөөс нь нь space хасах
            String[] inputArray = str.split("\\s+");
            Size_arr = inputArray.length;
            Checked = false;
            task = " ";
            command = " ";
            input2 = " ";
            if (str != null && Size_arr == 2) {
                task = inputArray[0];
                command = inputArray[1];
                command = command.toLowerCase();
                task = task.toLowerCase();
            }
            if (str != null && Size_arr > 2) {
                task = inputArray[0];
                command = inputArray[1];
                input2 = inputArray[2];
                tempStr = input2;
                command = command.toLowerCase();
                task = task.toLowerCase();
                input2 = input2.toLowerCase();
                if (!input2.equals("done")) {
                    input2 = tempStr;
                }
            }

            if (task.equals("task") && command.equals("add")) {
                toDO = Trim_add(str);
                my_toDo.add(toDO);
                System.out.println("Created task " + my_toDo.size());
                Checked = true;
            }
            if (task.equals("task") && command.equals("list")) {
                List_console();
                Checked = true;
            }
            if (task.equals("task") && command.equals("done")) {
                if (isNumer(input2) && Size_arr == 3) {
                    Done(input2);
                }
            }
            if (task.equals("task") && input2.equals("done")) {
                if (isNumer(command) && Size_arr == 3) {
                    Done(command);
                }
            }
            if (Checked == false) {
                System.out.println("Invalid command");
            }
        }
    }

    public static String Trim_add(String str2) {
        //үндсэн string-гээс task add  -ийг хасаад, хассаныгаа ялгаж todo рүү нэмэх зорилготой.
        str2 = (String) str2.subSequence(str2.indexOf(input2), str2.length());
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
        int id = Integer.parseInt(DeleteId);
        if (id <= my_toDo.size() && my_toDo.isEmpty() == false && id >= 1) {
            my_toDo.remove(id - 1);
            Checked = true;
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
