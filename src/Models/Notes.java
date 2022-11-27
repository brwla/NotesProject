package Models;
import Models.DateTime;
import Models.FileHandling;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Notes{
    ArrayList<String> textList = new ArrayList<String>();
    ArrayList<String> dateList = new ArrayList<String>();
    Scanner in = new Scanner(System.in);
    DateTime date = new DateTime();
    FileHandling file = new FileHandling();

    public void splitText(){
        try {
            ArrayList<String> listOfLines;
            listOfLines = file.readFile();
            textList.clear();
            dateList.clear();
            for(int i = 0; i <listOfLines.size(); i++){
                String line = listOfLines.get(i);
                String[] stringSplit = line.split(" / ");
                textList.add(stringSplit[0]);
                dateList.add(stringSplit[1]);
            }
        } catch (Exception e) {
            System.out.println("An error ocurred.");
        }
    }

    public void createNote(){
        try {
            splitText();
            System.out.print("\nEnter your notes: " ); 
            String text = in.nextLine();
            textList.add(text);
            dateList.add(date.getDate());
            file.writeFile(textList, dateList);
        } catch (Exception e) {
            System.out.println("\nAn error occured.");
        }
    }

    public void readNote(){
        try {
            splitText();
            for(int i = 0; i < textList.size(); i++){
                System.out.println("\n[" + i + "]\t" + textList.get(i));
                System.out.print("\t" + dateList.get(i) + '\n');
            }
        } catch (Exception e) {
            System.out.println("\nAn error occured.");
        }
    }

    public void updateNote(){
        try{
            splitText();
            readNote();
            System.out.print("\nEnter the number of the note you want to change.\n--> " );
            int index = in.nextInt();
            in.nextLine();
            System.out.print("\nEnter your updated notes: ");
            String updText = in.nextLine();
            textList.set(index, updText);
            dateList.set(index, date.getDate());
            file.writeFile(textList, dateList);
        }catch(InputMismatchException e) {
            System.out.println("\nInvalid choice.");
            in.nextLine();
        }catch(IndexOutOfBoundsException f){
            System.out.println("\nInvalid choice.");
        }
    }

    public void deleteNote(){
        try{
            splitText();
            readNote();
            System.out.print("\nEnter the number of the note you want to delete.\n--> " );
            int idx = in.nextInt();
            textList.remove(idx);
            dateList.remove(idx);
            file.writeFile(textList, dateList);
        }catch(InputMismatchException | IndexOutOfBoundsException e){
            System.out.println("\nInvalid choice.");
            in.nextLine();
        }
    }

    public void displayMenu(){
        System.out.println("______________________________________________________________");
        System.out.println("\nWelcome to the notes app.\nWhat would you like to do?");
        System.out.println("\n[1] Create a Note.");
        System.out.println("[2] Read Notes.");
        System.out.println("[3] Update a Note.");
        System.out.println("[4] Delete a Note.");
        System.out.println("[5] Exit.\n");
        System.out.print("Enter a number: ");
    }
}