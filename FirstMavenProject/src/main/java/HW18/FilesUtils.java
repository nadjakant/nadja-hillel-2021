package HW18;

import HW16.Main;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesUtils {
    public static boolean SaveFile(String text, String fileName, String folder){
        try {
            Files.createDirectories(Paths.get(folder));
            FileOutputStream fileOut = new FileOutputStream(folder+"/"+fileName);
            fileOut.write(text.getBytes());
            fileOut.close();
        } catch (IOException i)  {
            i.printStackTrace();
        }

        return true;
    }

    public static String getJarFolder(){
        String actualFolder = "";

        try {
            actualFolder = Main.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath();
            actualFolder = actualFolder.substring(0, actualFolder.lastIndexOf("/"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return actualFolder;
    }

    public static String fileAsString(File file){
        try {
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
           return null;
        }
    }

    public static boolean Log(String dir, String text){
        try {
            FileOutputStream fileOut = new FileOutputStream(dir+"/"+"result.log", true);
            fileOut.write((text+"\n").getBytes());
            fileOut.close();
            return true;
        }
        catch (IOException i) {
            i.printStackTrace();
        }

        return false;
    }

    public static Boolean isDirectoryExists(String directoryPath){
        File dir = new File(directoryPath);

        return dir.exists() && dir.isDirectory();
    }
}
