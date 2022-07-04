package com.test.test_module;
import java.util.*;
import java.io.*;
import org.apache.commons.lang3.StringUtils;

public class ServicesClass{

	public String randomGenerator() {
        Random r = new Random();
        StringBuilder a = new StringBuilder(3); //String builder with capacity of 3
        String ascii = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^&*()_+";
        for (int i = 0; i < 3; i++) {
            a.append(ascii.charAt(r.nextInt(ascii.length()))); //Randomizer of characters with length of 3.
        }
        return a.toString();
    }

    public Boolean dataEncoder(Map<String, String> map, Object[][] cell, int rowNum, int colNum) {
        Object[] objectArray;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                map.put(randomGenerator(), randomGenerator());
            }
            objectArray = map.entrySet().toArray();
            cell[i] = objectArray;
            map.clear();
        }

        return true;
    }

   public String[][] ObjectToArray(Object[][] cell, int row, int col){
        String[][] str= new String[row][col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                str[i][j]=cell[i][j].toString();
                
            }
            
        }
        return(str);
    }


    public Boolean saveFile(String[][] cell, String path) {
        String Holder;
        String rep;

        String[][] temp = new String[cell.length][cell[0].length];
        
        
        try {
            String filepath = "C:/Users/MARVIN/Desktop/codes/Output.txt";
            FileWriter writer = new FileWriter(filepath);
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    Holder = (cell[i][j]);
                    temp[i][j] = Holder;
                    if (j == temp[0].length - 1) {
                        writer.write(temp[i][j]);
                    } else {
                        writer.write(temp[i][j] + " ");
                    }
                }
                writer.write("\n");
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not found."+path);
        }
        return true;

    }
    
    public static String[][] readFile(String path) throws IOException {
        int row = 0;
        int col = 0;
        int index = 0;
        //String filePath = "C:/Users/MARVIN/Desktop/codes/Output.txt";
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        Scanner scanner;
        scanner = new Scanner(file);

        while (br.readLine() != null) {
            row++;
        }

        String current = scanner.nextLine();
        while ((index = StringUtils.indexOf(current," ", index)) != -1) {
            col++;
            index++;
        }

        String[][] temp = new String[row][col+1];
        Scanner sc = new Scanner(file);
        System.out.println(row);
        System.out.println(col);
        while (sc.hasNextLine()) {
            for (int i = 0; i < temp.length; i++) {
                String[] line = sc.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    temp[i][j] = line[j];
                    
                }
            }
            
        }
        scanner.close();
        fr.close();
        return temp;
    }

    


    public void printArray(String[][] cell) {
        String output = "";
        String temp = "";
        for(String[] a:cell){
            for(String b:a){
                temp = b.replace("=",",");
                output+=temp + "\t";
            }
            output+="\n";

        }
        System.out.print(output);
    }

    public String[][] addColumn(String[][] cell, int row, String key, String val){
        String[][] temp = new String[cell.length][cell[0].length+1];

        try{
        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < cell[0].length+1; j++){
                if(j==cell[0].length && i == row){
                    temp[i][j] = key + "=" + val;
                }else if(j == cell[0].length){
                    temp[0][j]="null=null";
                }else{
                    temp[i][j]=cell[i][j];
                }
            }
        }
        
        
        }catch(Exception e){
            System.out.println("here column"+e);
        }
        return temp;
        
    }


    public String[][] sortTable(String[][] cell, String choice) {
        String[][] temp = new String[cell.length][cell[0].length];
        
        String Holder;
        
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                Holder = (cell[i][j]);
                
                temp[i][j] = Holder;

            }

        }
        switch (choice) {
            case "Ascending":
                for (int i = 0; i < temp.length; i++) {
                    Arrays.sort(temp[i]);
                }

                
                break;
            case "Descending":
                for (int i = 0; i < temp.length; i++) {
                    Arrays.sort(temp[i], Collections.reverseOrder());
                }

                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }
        return temp;

    }


    public String[][] editData(String[][] cell, int xCoordinate, int yCoordinate, String val, String newValue) {
        String[][] temp = new String[cell.length][cell[0].length];
        String Holder;
        
        try{
        
        String newString;
        
        String a;
        String[] b;

        for(int i = 0; i<temp.length; i++){
            for(int j = 0; j<temp[0].length; j++){
                Holder = (cell[i][j]);
                temp[i][j]=Holder;
                
            }
            
        }

        switch (val) {
            case "Key":
                
                a = temp[xCoordinate][yCoordinate];
                b = StringUtils.split(a,"=");
                newString = newValue + "=" + b[1];
                temp[xCoordinate][yCoordinate] = newString;
                break;
            case "Value":
                
                a = temp[xCoordinate][yCoordinate];
                b = StringUtils.split(a,"=");;
                newString = b[0] + "=" + newValue;
                temp[xCoordinate][yCoordinate] = newString;
                break;

            default:
                System.out.println("Invalid Choice");
                break;

        }
    }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid input of coordinates.");
        }
        return temp;

    }


    public String search(String[][] cell, String valueToSearch) {

        //Scanner sc = new Scanner(System.in);
        int index = 0;
        int count = 0;
        String output="";
        String compare="";

        //System.out.print("Enter value to search: "); //User inputs the value.
        //String valueToSearch = sc.next();

        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                String a = cell[i][j];
                String[] b = StringUtils.split(a,"=");
                while ((index = StringUtils.indexOf(b[0], valueToSearch, index)) != -1) {
                    count++;
                    index++;
                    output+="[" + i + "," + j + "]" + "-" + count + " From key field\n";
                }
            }
            count = 0;

        }

        index = 0;
        count = 0;
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                String a = cell[i][j];
                String[] b = StringUtils.split(a,"=");
                while ((index = StringUtils.indexOf(b[1], valueToSearch, index)) != -1) {
                    count++;
                    index++;
                    output+="[" + i + "," + j + "]" + "-" + count + " From value field\n";
                }
            }
            count = 0;
            System.out.println();
        }

        if(output.equals(compare)){
            output = "There is no such key or value.\n";
        }
        return output;

    }


}