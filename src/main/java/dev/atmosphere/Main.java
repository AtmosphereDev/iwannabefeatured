package dev.atmosphere;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.util.SystemInfo;
import com.google.gson.Gson;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static FeaturedServersJson featuredServersJson;
    public static String workdir;

    public static void main(String[] args) {
        System.setProperty("flatlaf.menuBarEmbedded", "true");
        if(SystemInfo.isLinux) {
            // enable custom window decorations
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        }
        workdir = System.getenv("LocalAppData") + "/Packages/Microsoft.MinecraftUWP_8wekyb3d8bbwe/LocalCache/minecraftpe/ContentCache/ThirdPartyServer";
        try {
            String content = new String(Files.readAllBytes(Paths.get(workdir + "/cF8xODU2NDAzNjg2")));
            Gson gson = new Gson();
            featuredServersJson = gson.fromJson(content, FeaturedServersJson.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        FlatDarkFlatIJTheme.setup();

        SwingUtilities.invokeLater(MainWindow::new);
    }
}