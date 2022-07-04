package com.test.test_module;
import java.util.*;
import java.io.*;
import org.apache.commons.lang3.StringUtils;

public class Homework2 {
    static String path="";
    static Object[][] cell = null;
    static Map<String, String> map = new HashMap<>();
    static Homework2 Hw2 = new Homework2();

    public void FirstPrompt(){
        TableHolder th = new TableHolder();
        ServicesClass service = new ServicesClass();
        Scanner sc = new Scanner(System.in);
        String choice;
        
        //System.out.print("testingersaa");
        System.out.print("Do you want to load text file [yes][no]? ");
        choice = sc.next();

        try{
            if(StringUtils.equals(choice,"yes")){
                System.out.print("Paste your path: ");
                path = sc.next();
                th.setTable(service.readFile(path));
                //service.saveFile(th.getTable(), path);
            }else {
                Hw2.ResetTable();
                
            }
        }catch(InputMismatchException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
            Hw2.ResetTable();
        }

    }

    public void ResetTable(){
        TableHolder th = new TableHolder();
        ServicesClass service = new ServicesClass();
        Scanner sc = new Scanner(System.in);
        int rowNum;
        int colNum;

        try{
            System.out.print("Enter the number of row: ");
            rowNum = sc.nextInt();
            System.out.print("Enter the number of column: ");
            colNum = sc.nextInt();
            cell = new Object[rowNum][colNum];
            service.dataEncoder(map, cell, rowNum, colNum);
            th.setTable(service.ObjectToArray(cell, rowNum, colNum));
            service.printArray(th.getTable());
            System.out.print("Paste your path: ");
            path = sc.next();
            service.saveFile(th.getTable(), path);
        }catch(InputMismatchException e){
            System.out.println("Invalid input. mismatch");
            this.ResetTable();
        }catch(Exception e){
            System.out.println("Invalid input. general");
            this.ResetTable();
        }
    }

    public static int MainMenu(){
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Main Menu");
        System.out.println("1.) Reset Array");
        System.out.println("2.) Edit Array");
        System.out.println("3.) Search Array");
        System.out.println("4.) View Array");
        System.out.println("5.) Sort Array");
        System.out.println("6.) Add column");
        System.out.println("7.) Exit");
        System.out.print("Choice: ");
        a = sc.nextInt();

        return a;
    }
   

    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        //String choice;
        String sortingChoice;
        int rowNum;
        int colNum;
        String editDataChoice;
        String newValue;
        int xCoordinate;
        int yCoordinate;
        String valueToSearch;
        int rowColumn;
        String keyColumn;
        String valueColumn;
        String path = "";
        ServicesClass service = new ServicesClass();
        int a;
        
        TableHolder th = new TableHolder();
        

        try {
            Hw2.FirstPrompt();
            
            while (true) {
                a = Hw2.MainMenu();

                switch (a) {
                    case 1:
                        Hw2.ResetTable();
                        service.printArray(th.getTable());
                        break;
                    case 2:
                        System.out.print("Array index x: ");  
                        xCoordinate = sc.nextInt();
                        System.out.print("Array index y: ");
                        yCoordinate = sc.nextInt();
                        System.out.print("Key or value? ");
                        editDataChoice = sc.next();
                        System.out.print("New Value: ");
                        newValue = sc.next();
                        th.setTable(service.editData(th.getTable(), xCoordinate, yCoordinate, editDataChoice, newValue));
                        service.saveFile(th.getTable(), path);
                        service.printArray(th.getTable());
                        break;
                    case 3:
                        
                        System.out.print("Enter value to search: "); //User inputs the value.
                        valueToSearch = sc.next();
                        System.out.println(service.search(th.getTable(), valueToSearch));
                        break;
                    case 4:
                        
                        service.printArray(th.getTable());
                        break;
                    case 5:
                        System.out.print("Sort Ascending or Descending? ");
                        sortingChoice = sc.next();
                        th.setTable(service.sortTable(th.getTable(), sortingChoice));
                        service.saveFile(th.getTable(), path);
                        service.printArray(th.getTable());
                        break;
                    case 6:
                        System.out.print("Which row you want to add a column? ");
                        rowColumn=sc.nextInt();
                        System.out.print("Key: ");
                        keyColumn=sc.next();
                        System.out.print("Value: ");
                        valueColumn=sc.next();
                        th.setTable(service.addColumn(th.getTable(), rowColumn, keyColumn, valueColumn));
                        service.saveFile(th.getTable(), path);
                        service.printArray(th.getTable());
                        break;
                    case 7:
                        System.exit(0);
                    default:
                        System.out.println("Invalid");
                        Hw2.MainMenu();
                        break;
                }

            }

        }catch (InputMismatchException e) {
            System.out.println("Invalid");
            Hw2.MainMenu();
        } catch (Exception e){
            System.out.println("Invalid");
            Hw2.MainMenu();
        }

    }

}
