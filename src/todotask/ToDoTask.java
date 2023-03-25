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
 * @author Az dorjazjargal@gmail.com
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

        for (int j = 0; j < 2; j++) {
            if (my_toDo.contains("done")) {
                for (int i = 0; i < my_toDo.size(); i++) {
                    if (my_toDo.get(i).equals("done")) {
                        my_toDo.remove(i);
                    }
                }
            }
        }

        for (int j = 0; j < my_toDo.size(); j++) {
            System.out.println(my_toDo.indexOf(my_toDo.get(j)) + 1 + " " + my_toDo.get(j));
        }
        System.out.println("task " + my_toDo.size());
        return null;
    }

    public static void Done(String State_done) {
        int id = Integer.parseInt(State_done);
        if (!my_toDo.isEmpty()) {
            if (id == 0) {
                System.out.println("та 0-ээс их id оруулах ёстой!!!");
                Checked = true;
            }
            if (id > my_toDo.size() && !my_toDo.isEmpty()) {
                System.out.println(id + " id-тай таск олдоогүй тул та " + my_toDo.size() + " хүртэл тоо оруулна уу");
                Checked = true;
            }
            if (id <= my_toDo.size() && id >= 1) {
                //my_toDo.remove(id - 1);
                my_toDo.set(id - 1, "done");
                Checked = true;
            }
        } else {
            System.out.println("Таны хийх зүйлсийн жагсаалт хоосон бга тул та хийх зүйлээ нэмсний дараа дахин оролдоно уу");
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
