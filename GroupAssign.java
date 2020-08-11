import java.util.*;
import java.awt.*;
import java.io.*;

/*
  1. Wrap up each function correctly
  2. Begin planning more features
  3. Begin GitHub project to track progress easier and more long term
  */
public class GroupAssign {
  public static void main(String[] args) throws IOException {
    Dialog();
  }

  public static void Dialog() throws IOException {
    System.out.println("Enter one of the following numbers to perform operation:");
    System.out.println("1. Create Group");
    System.out.println("2. Edit Group");
    System.out.println("3. Delete Group\n");
    Scanner sc = new Scanner(System.in);
    while (!sc.hasNextInt()) sc.next(); //this prevents crash from user inputting letters
    int userInput = sc.nextInt();
    boolean readyInput = true;

    do {
        if (userInput == 1) {
          CreateGroup(readyInput);
          readyInput = false;
       }
       else if (userInput == 2) {
          EditGroup(readyInput);
          readyInput = false;
       }
       else if (userInput == 3) {
          DeleteGroup(readyInput);
          readyInput = false;
       }
       else {
          System.out.println("Enter either \"1\", \"2\", or \"3\"");
          while (!sc.hasNextInt()) sc.next();
          userInput = sc.nextInt();
       }
    } while (readyInput == true); 
  }

  private static void EditGroup(boolean readyInput) throws IOException {
    ArrayList<String> SavedGroup = new ArrayList<String>();
    int size = SavedGroup.size();
    FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
    dialog.setMode(FileDialog.LOAD);
    dialog.setVisible(true);
    String file = dialog.getFile();
    File finalFile = new File(file);
    if (finalFile.exists() && file.startsWith("Group_")) {
        System.out.println(file + " chosen.");
        Scanner reader = new Scanner(finalFile);
        while (reader.hasNextLine()) {
            SavedGroup.add(reader.nextLine());
            size = SavedGroup.size();
        }
        String[] printArray = SavedGroup.toArray(new String[size]);
        reader.close();
        System.out.println("Size of selected group: " + size);
        int line = 1;
        for (String var : printArray) {
            System.out.println("Position " + line + ": " + var); 
            line++;
        }
        System.out.println("\nWould you like to edit this group?");
        System.out.println("1. Yes");
        System.out.println("2. No, exit to menu\n");
        Scanner eg1 = new Scanner(System.in);
        while (!eg1.hasNextInt()) eg1.next();
        int intInput = eg1.nextInt();
        if (intInput == 1) {
            EditGroupFinale(readyInput, printArray, size, SavedGroup, finalFile);
        }
        else {
            readyInput = true;
            Dialog();
        }

    }
    else if (finalFile.exists() && !file.startsWith("Group_")) {
        System.out.println("Incorrect file type!");
        readyInput = true;
        Dialog();
    }
    else {
        System.out.println("No such file exists.");
        readyInput = true;
        Dialog();
    }
  }
  
  private static void EditGroupFinale(boolean readyInput, String[] printArray, int size, ArrayList<String> SavedGroup, File finalFile) throws IOException {
    System.out.println("Enter which entry position: ");
    Scanner egf1 = new Scanner(System.in);
    int intInput = 0;
    do {
        while (!egf1.hasNextInt()) egf1.next();
        intInput = egf1.nextInt();
        if (intInput > size) {
            System.out.println("\nEntered number exceeds group size, please choose a number that exists: ");
        }
        else if (intInput <= 0) {
            System.out.println("\nThis value does not exist, choose another number position: ");
        }
    } while (intInput == 0 || intInput > size);
    int line = 1;
    int index = line - 1;
    for (String var : printArray) {
        
    }
    /* boolean exitSet = false;
    for (String var : printArray) {
        if (line == intInput) {
            System.out.println(line + ": " +  var);
            Scanner egf2 = new Scanner(System.in);
            do {
                String editSelection = egf2.nextLine();
                if (editSelection.length() > Short.MAX_VALUE) {
                    System.out.println("\nEntered element exceeded size limit (32767 characters)...");
                }
                else {
                    SavedGroup.set(index, "1");
                    String[] passEditArray = SavedGroup.toArray();
                    FileWriter editWriter = new FileWriter(finalFile.getName());
                    int innerLine = 1;
                    for (int j = 0; j > passEditArray.length; j++) {
                        editWriter.write(passEditArray[j]);
                        System.out.println("Position " + innerLine + ": " + passEditArray[j]);
                        innerLine++;
                    } 
                    editWriter.close();
                    break;
                }
            } while (exitSet == false);
        } 
        else {
            line++;
        }
    } */  // This code block has problems. Figure out how to overwrite a single element and save to file.
            // Biggest issue here was SavedGroup.toArray(new String[size]) created a new empty array and saved that
                // instead of copying the old array, changing the desired element, and writing.

  }

  private static void CreateGroup(boolean readyInput) throws IOException {
    int lineCounter = 0;
    Scanner ui1 = new Scanner(System.in);
    System.out.println("Enter the name of the group:");
    String fileName = ui1.nextLine();
    System.out.println("Maximum number of positions this group should have?");
    Scanner ui2 = new Scanner(System.in);
    while (!ui2.hasNextInt()) ui2.next();
    int intInput = ui2.nextInt();
    String[] InitGroup = new String[intInput];
    System.out.println("\nSize: " + intInput);
    System.out.println("Ok! Type an entry then press enter to add it to the group:");
    FileWriter myWriter = new FileWriter("Group_" + fileName + ".txt");
    Scanner ui3 = new Scanner(System.in);
    for (int j = 0; j < InitGroup.length; j++) {
        lineCounter++;
        System.out.println("Position " + lineCounter + ":");
        myWriter.write(InitGroup[j] = ui3.nextLine() + "\n"); 
    }
    myWriter.close();
    System.out.println("\nSuccessfully wrote to file: Group_" + fileName + ".txt\n");
    readyInput = true;
    Dialog();
  }

  private static void DeleteGroup(boolean readyInput) throws IOException {
    boolean deleteInput = true;
    do {
        System.out.println("Choose one of the following Delete options:");
        System.out.println("1. Single Group delete");
        System.out.println("2. Delete all Groups\n");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) sc.next();
        int userInput = sc.nextInt();

        if (userInput == 1){
            try {
                FileDialog dialog = new FileDialog((Frame)null, "Select File to open");
                dialog.setMode(FileDialog.LOAD);
                dialog.setVisible(true);
                String file = dialog.getFile();
                File finalFile = new File(file);
                if (finalFile.getName().startsWith("Group_")) {
                    System.out.println("Deleting: " + finalFile.getName());
                    finalFile.delete();
                }
                else {
                    System.out.println("\nIncorrect file type!\n");
                    DeleteGroup(readyInput);
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("\nFile not found!\n");
                DeleteGroup(readyInput);
            }
            readyInput = true;
            Dialog();
        }

        else if(userInput == 2) {
            System.out.println("Are you sure you want to delete all Groups?");
            System.out.println("1. No, abort operation");
            System.out.println("2. Yes, continue to delete all Groups\n");
            while (!sc.hasNextInt()) sc.next();
            int deleteInnerInput = sc.nextInt();
            if (deleteInnerInput == 1) {
                System.out.println("\nReturning to menu...\n");
                DeleteGroup(readyInput);
            }
            else if(deleteInnerInput == 2) {
                File folder = new File(".");
                for (File file : folder.listFiles()) {
                    if (file.getName().startsWith("Group_")) {  //should NEVER have ! at the start (will delete all files)
                        System.out.println("Deleting: " + file.getName());
                        file.delete();
                    }
                }
            }
            readyInput = true;
            Dialog();
        }

        else {
            System.out.println("Enter either \"1\", or \"2\"");
            DeleteGroup(readyInput);
        }
    } while (deleteInput == true);
    readyInput = true;
    Dialog();
  }


}

