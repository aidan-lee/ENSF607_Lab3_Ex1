package BackEnd;

public class FileManager {

    private static FileManager instance;

    private FileManager() {
        System.out.println("File manager");
    }

    public static FileManager getFileManager() {
        if (instance == null) {
            instance = new FileManager();
        }

        return instance;
    }


}
