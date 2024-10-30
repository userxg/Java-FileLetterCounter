package FileLetterCounter;

import java.io.File;

public class Main {
    public static void main(String[] args){
        Run();
    }

    public static void Run(){
        File readFile = FileReader.OpenInputFile();
        if (readFile == null){
            System.out.println("The program is terminated...");
            return;
        }
        int[] letter_counts = FileReader.CountLettersFromInputFile(readFile);
        FileWriter.WriteResultsIntoFile(letter_counts, readFile.getName());
    }
}

