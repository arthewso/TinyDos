import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class tinydos {
    private static final String PROMPT = "C:\\>";
    private static final String DIRECTORY_SEPARATOR = "\\";
    private static String currentDirectory = System.getProperty("user.dir");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(PROMPT + currentDirectory + "> ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            String cmd = parts[0].toLowerCase();
            switch (cmd) {
                case "dir":
                    dir();
                    break;
                case "mkdir":
                    mkdir(parts[1]);
                    break;
                case "del":
                    del(parts[1]);
                    break;
                case "cd":
                    cd(parts[1]);
                    break;
                case "sudo":
                    sudo(parts[1]);
                    break;
                case "echo":
                    echo(parts[1]);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    private static void dir() {
        File dir = new File(currentDirectory);
        String[] files = dir.list();
        for (String file : files) {
            System.out.println(file);
        }
    }

    private static void mkdir(String dirName) {
        File dir = new File(currentDirectory + DIRECTORY_SEPARATOR + dirName);
        if (dir.mkdir()) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Failed to create directory");
        }
    }

    private static void del(String fileName) {
        File file = new File(currentDirectory + DIRECTORY_SEPARATOR + fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete file");
        }
    }

    private static void cd(String dirName) {
        File dir = new File(currentDirectory + DIRECTORY_SEPARATOR + dirName);
        if (dir.exists() && dir.isDirectory()) {
            currentDirectory = dir.getAbsolutePath();
        } else {
            System.out.println("Directory not found");
        }
    }

    private static void sudo(String command) {
        // Note: This is a very basic implementation of sudo, in a real-world scenario you would need to handle permissions and security properly
        System.out.println("Running command with elevated privileges: " + command);
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println("Failed to execute command");
        }
    }

    private static void echo(String message) {
        System.out.println(message);
    }
    }
        }
