package Models;
import Models.DateTime;
import Models.FileHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Notes{
    Scanner in = new Scanner(System.in);
    DateTime date = new DateTime();
    FileHandling file = new FileHandling();

    public void createNote(){
        System.out.print("\nEnter your notes: " ); 
        String text = in.nextLine();
        file.writeFile(text, date.getDate());
    }

    public void readNote(){
        file.readFile();
    }

    public void updateNote(){
        try{
            readNote();
            System.out.print("\nEnter the number of the note you want to change.\n--> " );
            int index = in.nextInt();
            in.nextLine();
            System.out.print("\nEnter your updated notes: ");
            String updText = in.nextLine();
            file.updateFile(index, updText, date.getDate());
        }catch(InputMismatchException e){
            System.out.println("\nInvalid choice.");
            in.nextLine();
        }
    }

    public void deleteNote(){
        try{
            readNote();
            System.out.print("\nEnter the number of the note you want to delete.\n--> " );
            int idx = in.nextInt();
            file.deleteFile(idx);
        }catch(InputMismatchException e){
            System.out.println("\nInvalid choice.");
            in.nextLine();
        }
    }

    public void displayMenu(){
        System.out.println("\nWelcome to the notes app.\nWhat would you like to do?");
        System.out.println("\n[1] Create a Note.");
        System.out.println("[2] Read Notes.");
        System.out.println("[3] Update a Note.");
        System.out.println("[4] Delete a Note.");
        System.out.println("[5] Exit.\n");
        System.out.print("Enter a number: ");
    }
}