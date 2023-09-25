package activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Activity14 {
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\054544744\\IdeaProjects\\FST Java\\src\\main\\resources\\SampleFile.txt";
        String fileContent = "My Sample Content\nThis is My 2nd Line";
        //Calls createFile Function to create a file and verify if file is created
        boolean fileCreated = createFile(fileName, fileContent);
        if (fileCreated) {
            System.out.println("File created");
        } else {
            System.out.println("File Already Exists : ");
        }

        //Calls writeToFile Method to write some COntent
        writeToFile(fileName, fileContent);

        //Calls Method displayFileContent which reads the file content
        displayFileContent(fileName);

        //Calls Method createDirAndCopyFile which creates resources Directory and copy the file into it
        String resourceDirectory = "C:\\Users\\054544744\\IdeaProjects\\FST Java\\src\\main\\resources\\resources";
        createDirAndCopyFile(fileName, resourceDirectory);

        //Read the Newfile and display content
        String newFileName = "C:\\Users\\054544744\\IdeaProjects\\FST Java\\src\\main\\resources\\resources\\SampleFile.txt";
        displayFileContent(newFileName);
    }

    private static void createDirAndCopyFile(String fileName, String directory) throws IOException {
        File file = new File(fileName);
        File myDir = new File(directory);
        FileUtils.copyFileToDirectory(file, myDir);
        File myFile = FileUtils.getFile(file);
        String fileContent = FileUtils.readFileToString(myFile, "UTF8");
        System.out.println(fileContent);
    }

    private static boolean createFile(String fileName, String fileContent) throws IOException {
        boolean flag = false;
        File file = new File(fileName);
        if (file.createNewFile()) {
            flag = true;
        }
        return flag;
    }

    private static void displayFileContent(String fileName) throws IOException {
        File fileObj = FileUtils.getFile(fileName);
        System.out.println(FileUtils.readFileToString(fileObj, "UTF8"));
    }

    public static void writeToFile(String fileName, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(text);
        fileWriter.close();
    }
}
