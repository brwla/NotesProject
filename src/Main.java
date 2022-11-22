import java.util.Scanner;

import Models.*;

public class Main{
    public static void main(String[] args){
        Notes noteObj = new Notes();
        Scanner input = new Scanner(System.in); 

        while(true){
            noteObj.displayMenu();
            char choice = input.next().charAt(0);
            switch(choice){
                case '1': 
                    noteObj.createNote();
                    break;
                
                case '2':
                    noteObj.readNote();
                    break;

                case '3':
                    noteObj.updateNote();
                    break;

                case '4':
                    noteObj.deleteNote();
                    break;

                case '5':
                    System.exit(0);
                
                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }
}