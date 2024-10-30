package FileLetterCounter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.IOException;

public class FileWriter {


    public static void WriteResultsIntoFile(int[] letter_counts, String inputFileName){
        File res_file = FileCreator(inputFileName);

        if (res_file == null){
            System.out.println("The program is terminated...");
            return;
        }
        // Create the file and write to it
        try (FileOutputStream fos = new FileOutputStream(res_file)) {

            for (int i = 0; i < letter_counts.length; i++) {
                char letter;
                if (i < 26) {
                    letter = (char) ('A' + i); // Uppercase letters A-Z
                } else {
                    letter = (char) ('a' + (i - 26)); // Lowercase letters a-z
                }
                String res = letter + ": " + letter_counts[i] + "\n";
                // Convert string to bytes
                byte[] myBytes = res.getBytes();
                fos.write(myBytes);
            }

            System.out.println("Successfully wrote results to the file: " + res_file.getName());
        }catch (IOException e){
            System.out.println("Failed to write results into file");
        }
    }


    public static File FileCreator(String inputFileName){

        File file = new File("outputFiles/results_" + inputFileName);

        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            System.out.println("'outputFiles' direcotory does not exist");
            System.out.println("Please make sure it's located in project folder");
            return null;
        }

        if (!parentDir.canWrite()) {
            System.out.println("You have no permission to write in 'outputFiles' directory");
            System.out.println("Please change the permission so it's available to write in");
            return null;
        }

        // Check for permission if it's exists
        if (file.exists() &&  !file.canWrite()) {
            System.out.println("You have no permission to write in '"+ file.getName() +  "' file");
            System.out.println("Please change permission so it's available to write in");
            return null;
        }

        return file; // All checks passed
    }
}
