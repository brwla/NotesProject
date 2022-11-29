package Models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileHandling {
    File fileObj = new File("notes.txt");

    public ArrayList<String> readFile(){
        ArrayList<String> listOfText = new ArrayList<String>();
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader("notes.txt"));
            String line = buffRead.readLine();
            while (line != null) {
                listOfText.add(line);
                line = buffRead.readLine();
            }
            buffRead.close();
        }catch(Exception e){
            if (fileObj.length() == 0){
                //continue
            }else{
                System.out.println("An error occurred.");
            }
        }
        return listOfText;
    }

    public void writeFile(ArrayList<String> text, ArrayList<String> date){
        try {
            FileWriter writing = new FileWriter("notes.txt");
            for(int i=0; i<text.size(); i++){
                writing.write(text.get(i) + " / " + date.get(i) + '\n');
            }
            writing.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}   