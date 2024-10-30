package FileLetterCounter;

import FileLetterCounter.FileReader;
import FileLetterCounter.FileWriter;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args){

        Run();
        //Test();
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

    public static void Test(){
        int[] counts = new int[52];

        // Sample data: You can fill this array with actual counts
        // For demonstration, let's assume some random counts
        for (int i = 0; i < 26; i++) {
            counts[i] = i + 1;      // Counts for A-Z (1 to 26)
            counts[i + 26] = i + 27; // Counts for a-z (27 to 52)
        }

        // Loop from 0 to 51 (total of 52 letters)
        for (int i = 0; i < 52; i++) {
            char letter;
            if (i < 26) {
                letter = (char) ('A' + i); // Uppercase letters A-Z
            } else {
                letter = (char) ('a' + (i - 26)); // Lowercase letters a-z
            }

            // Print the letter and its count
            System.out.println(letter + ": " + counts[i]);
        }

//        try {

//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
    }


}

