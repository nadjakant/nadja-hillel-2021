package HW18;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Converter {
    private final String convertedFolder;
    private final String[] jsonExtensions = new String[]{"json", "jsn"};
    private final String[] yamlExtensions = new String[]{"yaml", "yml"};

    String actualFolder = "";

    Converter(String actualFolder) {
        if (FilesUtils.isDirectoryExists(actualFolder)) {
            this.actualFolder = actualFolder;
        } else {
            System.out.println("The folder is not specified or does not exist");
            System.out.println("Checking the working folder...");
            this.actualFolder = FilesUtils.getJarFolder();
        }
        this.convertedFolder = this.actualFolder + "/converted";
    }

    public void Start() throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(actualFolder), 1)) {
            paths.filter(path -> {
                        return FilenameUtils.isExtension(path.getFileName().toString(), "json", "jsn", "yaml", "yml");
                    })
                    .forEach(path -> {
                        File file = path.toFile();

                        if (!file.isFile()) {
                            return;
                        }
                        String textToSave = "";
                        String newExt = "";
                        String fileName = file.getName();

                        long startTime = System.currentTimeMillis();

                        if (FilenameUtils.isExtension(fileName, jsonExtensions)) {
                            textToSave = FilesUtils.fileAsString(file);
                            textToSave = ConvertUtils.jsonToYaml(textToSave);
                            newExt = "yml";
                        } else if (FilenameUtils.isExtension(fileName, yamlExtensions)) {
                            textToSave = FilesUtils.fileAsString(file);
                            textToSave = ConvertUtils.yamlToJson(textToSave);
                            newExt = "json";
                        }

                        long endTime = System.currentTimeMillis();
                        long timeSpent = endTime - startTime;

                        if (textToSave != null) {
                            String newFileName = FilenameUtils.removeExtension(fileName)+"."+newExt;

                            String logStr = fileName+ "->"+newFileName+" "+timeSpent+" ms "+
                                            FileUtils.byteCountToDisplaySize(file.length())+" -> "+
                                            FileUtils.byteCountToDisplaySize(textToSave.getBytes(StandardCharsets.UTF_8).length);
                            FilesUtils.SaveFile(textToSave, newFileName, convertedFolder);
                            FilesUtils.Log(actualFolder, logStr);
                        }
                    });
        }
    }
}
