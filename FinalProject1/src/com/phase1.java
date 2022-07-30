package com;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class phase1 {
	static String direct;
    File file;

    public phase1() {
        direct = System.getProperty("user.dir");
        file = new File(direct+"/files");
        if (!file.exists())
            file.mkdirs();
        System.out.println("Directory : "+ file.getAbsolutePath());
    }
    public static void WelcomeScreen() {
		System.out.println( "        Welcome to my application      ");
		System.out.println(" This application was developed by Ragul");
		System.out.println("-------------------------------------------------------");
		System.out.println(" This application is used to Search, Add,Delete and Retrieve Files in your folder.");
		}
    public static void Menu() {
		System.out.println("Select any one option from below and press Enter ");
		System.out.println(" 1) Retrieve all files inside the folder");
		System.out.println(" 2) Display menu for File operations");
		System.out.println(" 3) Exit program");
		}
    public static void SubMenu() {
	    System.out.println("Select any option number from below and press Enter    ");
	    System.out.println("  1) Add a file ");
        System.out.println("  2) Delete a file");
	    System.out.println("  3) Search for a file");
	    System.out.println("  4) Show Previous Menu");
	    System.out.println("  5) Exit program");
		 }
    void DisplayMainMenu() {
        phase1.Menu();
        int flag=0;
        try{
        	while(flag==0) {
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch (ch){
                case 1 : 
                    showFiles();
                    DisplayMainMenu();
                case 2 : 
                    DisplaySubMenu();
                case 3 : 
                	flag=1;
                	System.out.println("Program Ended");
                	System.exit(0);
                    break;
                default: System.out.println("There is some error in entering the values please check it");
            }
        }
        }
        catch (Exception e){
            System.out.println("There is some error in entering the values please check it");
        }
    }

    void DisplaySubMenu() {
        phase1.SubMenu();
        try{
            Scanner sc = new Scanner(System.in);
            int ch1= sc.nextInt();
            switch (ch1){
                case 1 :{ 
                    System.out.print("Enter the filename");
                    String filename = sc.next().trim();
                    add(filename);
                    break;
                }
                case 2 : {
                    System.out.print("Enter the filename which is to be deleted");
                    String filename = sc.next().trim();
                    delete(filename);
                    break;
                }
                case 3 : {
                    System.out.print("Enter the filename to search");
                    String filename = sc.next().trim();
                    search(filename);
                    break;
                }
                case 4 : {
                    System.out.println("Going Back to MAIN menu");
                    DisplayMainMenu();
                    break;
                }
                case 5:{
                	System.out.println("Program Ended");
                	System.exit(0);
                }
                default : System.out.println("There is some error in entering the values please check it");
            }
            DisplaySubMenu();
        }
        catch (Exception e){
            System.out.println("There is some error in entering the values please check it");
            DisplaySubMenu();
        }
    }

    void showFiles() {
        if (file.list().length==0)
            System.out.println("No files found");
        else {
            String[] filelist = file.list();
            System.out.println("The files in the directory are :");
            Arrays.sort(filelist);
            for (String s:filelist) {
                System.out.println(s);
            }
        }
    }
    void add(String filename) throws IOException {
        File filepath = new File(file+"/"+filename);
        String[] filelist = file.list();
        for (String name: filelist) {
            if (filename.equalsIgnoreCase(name)) {
                System.out.println(filename + " already exists");
                return;
            }
        }
        filepath.createNewFile();
        System.out.println(filename+ "  created successfully");
    }

    void delete(String filename) {
        File filepath = new File(file +"/"+filename);
        String[] filelist = file.list();
        for (String name: filelist) {
            if (filename.equals(name) && filepath.delete()) {
                System.out.println("File is successfully deleted");
                return;
            }
        }
        System.out.println("File does not exists");
    }
    void search(String filename) {
        String[] list = file.list();
        for (String name: list) {
            if (filename.equals(name)) {
                System.out.println(filename+" is found");
                return;
            }
        }
        System.out.println("File is not found please check all files by retriving all files");
    }
    public static void main(String []args) {
    	phase1.WelcomeScreen();
    	phase1 obj= new phase1();
    	obj.DisplayMainMenu();
    	
    }
}
