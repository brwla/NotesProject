package Models;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHandling {
    File fileObj = new File("notes.txt");

    public void writeFile(String txt, String date){
        try {
            FileWriter writing = new FileWriter("notes.txt", true);
            writing.write(txt + " / " + date + '\n');
            writing.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void readFile(){
        try {
            Scanner fileRead = new Scanner(fileObj);
            int i = 0;
            while(fileRead.hasNextLine()){
                String fileData = fileRead.nextLine();
                String[] stringSplit = fileData.split(" / ");
                System.out.print("\n[" + i + "]\t" + stringSplit[0]);
                System.out.println("\n\t" + stringSplit[1]);  
                i++;  
            }
        } catch (Exception e) {
            System.out.println("An error occured.");
        } 
    }
    
    public void updateFile(int index, String updText, String updDate){
        ArrayList<String> upTextList = new ArrayList<String>();
        ArrayList<String> upDateList = new ArrayList<String>();
        try {
            Scanner fileRead = new Scanner(fileObj);
            while(fileRead.hasNextLine()){
                String fileData = fileRead.nextLine();
                String[] stringSplit = fileData.split(" / ");
                upTextList.add(stringSplit[0]);
                upDateList.add(stringSplit[1]);
            }
            upTextList.set(index, updText);
            upDateList.set(index, updDate);
            FileWriter overwrite = new FileWriter("notes.txt");
            overwrite.flush();
            overwrite.close();
            FileWriter update = new FileWriter("notes.txt", true);
            for(int i = 0; i < upTextList.size(); i++){
                update.write(upTextList.get(i) + " / " + upDateList.get(i) + '\n');
            }
            update.close();
        } catch (Exception e) {
            System.out.println("Invalid Choice.");
        }
    }

    public void deleteFile(int idx){
        ArrayList<String> txtFileList = new ArrayList<String>();
        ArrayList<String> dateFileList = new ArrayList<String>();
        try {
            Scanner fileRead = new Scanner(fileObj);
            while(fileRead.hasNextLine()){
                String fileData = fileRead.nextLine();
                String[] stringSplit = fileData.split(" / ");
                txtFileList.add(stringSplit[0]);
                dateFileList.add(stringSplit[1]);
            }
            txtFileList.remove(idx);
            dateFileList.remove(idx);
            FileWriter overwrite = new FileWriter("notes.txt");
            overwrite.flush();
            overwrite.close();
            FileWriter update = new FileWriter("notes.txt", true);
            for(int i = 0; i < txtFileList.size(); i++){
                update.write(txtFileList.get(i) + " / " + dateFileList.get(i) + '\n');
            }
            update.close();
        } catch (Exception e) {
            System.out.println("Invalid Choice.");
        }
    }
}   