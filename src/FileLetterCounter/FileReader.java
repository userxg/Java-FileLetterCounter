package FileLetterCounter;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;

public class FileReader {

    public static File OpenInputFile(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide a txt file-name to read from: ");
        String fileName = scanner.nextLine();
        System.out.println(fileName);

        File file = new File("inputFiles/" + fileName);

        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            System.out.println("'inputFiles' direcotory does not exist");
            System.out.println("Please make sure it's located in project folder");
            return null;
        }

        if (!parentDir.canRead()) {
            System.out.println("You have no permission to read from 'inputFiles' directory");
            System.out.println("Please change the permission so it's available to read");
            return null;
        }

        // Check the file
        if (!file.exists()) {
            System.out.println("The file '" + fileName + "' does not exists");
            System.out.println("Make sure your file is in inputFiles/ directory of the project");
            return null;
        }else if(!file.isFile() || !file.getName().endsWith(".txt")){
            System.out.println("Invalid file. Please ensure it's a file and has a .txt extension.");
            return null;
        }
        else if(!file.canRead()) {
            System.out.println("You have no permission to read '"+ fileName +  "' file");
            System.out.println("Please change the permission so it's available to read");
            return null;
        }else {
            System.out.println("The file '" + fileName + "' exists!");
            System.out.println("Counting has been started!");
            return file;
        }


    }


    public static int[] CountLettersFromInputFile(File file){

        int[] letter_counts = new int[52];
        try (FileInputStream fis = new FileInputStream(file)){
            int size = fis.available();

            for (int i = 0; i < size; i++) {
                char letter = (char) fis.read();

                if (letter >= 'A' && letter <= 'Z') { // Uppercase letters
                    letter_counts[letter - 'A']++;
                } else if (letter >= 'a' && letter <= 'z') { // Lowercase letters
                    letter_counts[letter - 'a' + 26]++;
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read letters from file");
        }
        return letter_counts;
    }


}
