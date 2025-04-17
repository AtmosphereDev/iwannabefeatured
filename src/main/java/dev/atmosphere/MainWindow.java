package dev.atmosphere;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static dev.atmosphere.Main.featuredServersJson;
import static dev.atmosphere.Main.workdir;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("IWannaBeFeatured");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(help);

        setJMenuBar(menuBar);

//        JPanel sidebarPanel = new JPanel();
//        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
//        sidebarPanel.setPreferredSize(new Dimension(200, getHeight()));
//
//        for (Item item : featuredServersJson.responseJson.data.items) {
//            dev.atmosphere.Image image = new dev.atmosphere.Image("", "", "", "");
//            for(dev.atmosphere.Image imageItem : item.Images) {
//                if (Objects.equals(imageItem.tag, "Icon")) {
//                    image = imageItem;
//                    break;
//                }
//            }
//
//            ImageIcon icon = new ImageIcon();
//            try {
//                MessageDigest crypt = MessageDigest.getInstance("SHA-1");
//                crypt.reset();
//                crypt.update((image.url + "?height=24&width=24").getBytes(StandardCharsets.UTF_8));
//                String hash = new BigInteger(1, crypt.digest()).toString(16);
//
//                icon = new ImageIcon(FileUtils.getFile(workdir + "/" + hash));
//            } catch (NoSuchAlgorithmException e) {
//                throw new RuntimeException(e);
//            }
//
//            JButton button = new JButton(item.Title.Neutral, icon);
//            button.setHorizontalTextPosition(AbstractButton.RIGHT);
//            button.setPreferredSize(new Dimension(190, 60));
//            button.setMaximumSize(new Dimension(190, 60));
//
//            Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//
//            button.setIcon(new ImageIcon(scaledImage));
//            button.addActionListener(e -> {
//                System.out.println("Clicked: " + item.Title.Neutral);
//            });
//            sidebarPanel.add(button);
//        }

        //JPanel sidebarPanel = createSidebar();
        SidebarPanel sidebarPanel = new SidebarPanel();

        // Start loading servers
        for (Item item : featuredServersJson.responseJson.data.items) {
            dev.atmosphere.Image image = new dev.atmosphere.Image("", "", "", "");
            for(dev.atmosphere.Image imageItem : item.Images) {
                if (Objects.equals(imageItem.tag, "Icon")) {
                    image = imageItem;
                    break;
                }
            }

            String imageHash = FileUtils.getHashFromUrl(image.url, FileUtils.ICONPARAMS);
            String imagePath = FileUtils.getPathWithExtension(workdir + "/" + imageHash);

            ImageIcon imageIcon = new ImageIcon(imagePath);
            imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

            sidebarPanel.addItem(imageIcon, item.Title.Neutral, item.Description.Neutral);
        }
        // End loading servers

        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));

        dev.atmosphere.Image image = new dev.atmosphere.Image("", "", "", "");
        for(dev.atmosphere.Image imageItem : featuredServersJson.responseJson.data.items.get(0).Images) {
            if (Objects.equals(imageItem.tag, "Banner")) {
                image = imageItem;
                break;
            }
        }

        String imageHash = FileUtils.getHashFromUrl(image.url, FileUtils.BANNERPARAMS);
        String imagePath = FileUtils.getPathWithExtension(workdir + "/" + imageHash);

        ImageIcon imageIcon = new ImageIcon(imagePath);
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(960, 288, Image.SCALE_SMOOTH));

        JLabel bannerLabel = new JLabel(imageIcon);
        bannerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        contentPanel.add(bannerLabel);

        JPanel title = new JPanel();
        title.add(new JLabel("Title: "));
        JTextField titleField = new JTextField("Server title", 30);
        titleField.setMaximumSize(new Dimension(Integer.MAX_VALUE, titleField.getPreferredSize().height));
        title.add(titleField);

        JPanel address = new JPanel();
        address.add(new JLabel("Address: "));
        address.add(new JTextField("Server address", 30));

        JPanel port = new JPanel();
        port.add(new JLabel("Port: "));
        port.add(new JSpinner(new SpinnerNumberModel(19132, 1, 65535, 1)));

        contentPanel.add(title);
        contentPanel.add(address);
        contentPanel.add(port);

        // Add sidebar and content panel to the main panel
        add(new JScrollPane(sidebarPanel, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }
}
