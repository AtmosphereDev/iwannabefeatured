package dev.atmosphere;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    public static String getFile(String path) {
        if (Files.exists(Paths.get(path + ".png"))) return path + ".png";
        if (Files.exists(Paths.get(path + ".jpg"))) return path + ".jpg";
        return path;
    }
}
