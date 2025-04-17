package dev.atmosphere;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils {
    public static final String THUMBNAILPARAMS = "?height=450&width=800";
    public static final String ICONPARAMS = "?height=24&width=24";
    public static final String SCREENSHOTPARAMS = "?height=162&width=288";
    public static final String BANNERPARAMS = "?height=288&width=960";

    public static String getPathWithExtension(String path) {
        if (Files.exists(Paths.get(path + ".png"))) return path + ".png";
        if (Files.exists(Paths.get(path + ".jpg"))) return path + ".jpg";
        return path;
    }

    public static String getHashFromUrl(String url, String params) {
        String result = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update((url + params).getBytes(StandardCharsets.UTF_8));
            result = new BigInteger(1, crypt.digest()).toString(16);
        } catch (NoSuchAlgorithmException err) {
            System.out.println("Cannot find SHA-1 algorithm!");
        }
        return result;
    }
}
