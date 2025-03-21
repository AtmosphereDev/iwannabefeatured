package dev.atmosphere;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static dev.atmosphere.Main.featuredServersJson;
import static dev.atmosphere.Main.workdir;

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

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setPreferredSize(new Dimension(200, getHeight()));

        for (Item item : featuredServersJson.responseJson.data.items) {
            dev.atmosphere.Image image = new dev.atmosphere.Image("", "", "", "");
            for(dev.atmosphere.Image imageItem : item.Images) {
                if (Objects.equals(imageItem.tag, "Icon")) {
                    image = imageItem;
                    break;
                }
            }

            ImageIcon icon = new ImageIcon();
            try {
                MessageDigest crypt = MessageDigest.getInstance("SHA-1");
                crypt.reset();
                crypt.update((image.url + "?height=24&width=24").getBytes(StandardCharsets.UTF_8));
                String hash = new BigInteger(1, crypt.digest()).toString(16);

                icon = new ImageIcon(FileUtils.getFile(workdir + "/" + hash));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

            JButton button = new JButton(item.Title.Neutral, icon);
            button.setHorizontalTextPosition(AbstractButton.RIGHT);
            button.setPreferredSize(new Dimension(200, 60));
            button.setMaximumSize(new Dimension(200, 60));

            Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            button.setIcon(new ImageIcon(scaledImage));
            button.addActionListener(e -> {
                System.out.println("Clicked: " + item.Title.Neutral);
            });
            sidebarPanel.add(button);
            sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Main Content Area"));

        JPanel title = new JPanel();
        title.add(new JLabel("Title: "));
        title.add(new JTextField("Server title"));

        JPanel address = new JPanel();
        address.add(new JLabel("Address: "));
        address.add(new JTextField("Server ddress"));

        JPanel port = new JPanel();
        port.add(new JLabel("Port: "));
        port.add(new JSpinner(new SpinnerNumberModel(19132, 1, 65535, 1)));

        contentPanel.add(title);
        contentPanel.add(address);
        contentPanel.add(port);

        // Add sidebar and content panel to the main panel
        mainPanel.add(new JScrollPane(sidebarPanel), BorderLayout.WEST);
        mainPanel.add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }
}
