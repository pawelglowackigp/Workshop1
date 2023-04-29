package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    static final String[] option = {"add", "remove", "list", "exit"};
    static final String csvFile = "tasks.csv";
    public static void main(String[] args) {
      loadTaskToTaskArr(csvFile);


        optionList(option);
        Scanner optChoice = new Scanner(System.in);
        while (optChoice.hasNextLine()) {
            String optionChose = optChoice.nextLine();

            switch (optionChose) {
                case "add":
                    System.out.println("You will add the task");
                    addTask();
                    break;
                case "remove":
                    System.out.println("You will remove the task");
                    removeTask();
                    break;
                case "list":
                    System.out.println("You will list all tasks");
                    listTasks();

                    break;
                case "exit":
                    System.out.println("You will end the program");
                    System.out.println(ConsoleColors.RED +"Bye Bye" + ConsoleColors.RESET);
                    System.exit(0);

                    break;
                default:
                    System.out.println("Choose a right option");
                    optionList(option);


        }

    } optionList(option);


        }
        public static void listTasks(){
            System.out.println("here will be listing of task");



              /*  for (int i = 0; i < tab.length; i++) {

                    System.out.print(i + " : ");

                    for (int j = 0; j < tab[i].length; j++) {

                        System.out.print(tab[i][j] + " ");

                    }

                    System.out.println();

                }
*/




            File taskList = new File("src/tasks.csv");
            StringBuilder reading = new StringBuilder();

            try {
                Scanner scan = new Scanner(taskList);
                while (scan.hasNextLine()) {
                    reading.append(scan.nextLine() + "\n");

                }


            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                System.exit(0);

            }
            System.out.println(reading.toString());


            }


    public static String[][] loadTaskToTaskArr(String csvFile){


        System.out.println("tab instruction download tasks from file checking ");

        String[][] tab = null;

        try {

            List<String> strings = Files.readAllLines(Path.of("/tasks.csv"));

            tab = new String[strings.size()][strings.get(0).split(",").length];


            for (int i = 0; i < strings.size(); i++) {

                String[] split = strings.get(i).split(",");

                for (int j = 0; j < split.length; j++) {

                    tab[i][j] = split[j];

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return tab;










    }

     public static void optionList (String [] option){

         System.out.println(ConsoleColors.BLUE + "Please select an option:");


         for (int i = 0; i < option.length; i++)

             System.out.println(ConsoleColors.RESET + option[i]);

     }
     public static void addTask(){
         System.out.println("Here will be add the task method");
     }
     public static void removeTask(){
         System.out.println("Here will be instruction for removing the tasks from list");
     }
        }

