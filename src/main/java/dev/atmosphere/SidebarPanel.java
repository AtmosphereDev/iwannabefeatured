package dev.atmosphere;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SidebarPanel extends JPanel {
    private static final Color BACKGROUND_COLOR = UIManager.getColor("Desktop.background");
    private static final Color SELECTED_COLOR = UIManager.getColor("Component.focusColor");
    private ArrayList<SidebarItem> items;

    public SidebarPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, getHeight()));
        items = new ArrayList<>();
        //add(Box.createRigidArea(new Dimension(0, 10)));
    }

    public void addItem(Icon icon, String title, String description) {
        SidebarItem item = new SidebarItem(icon, title, description);
        items.add(item);
        add(item);
        //add(Box.createRigidArea(new Dimension(0, 10)));
        revalidate();
        repaint();
    }

    private class SidebarItem extends JPanel {
        public SidebarItem(Icon icon, String title, String description) {
            setLayout(new BorderLayout(10, 0));
            setBackground(BACKGROUND_COLOR);
            setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

            // Icon
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            add(iconLabel, BorderLayout.WEST);

            // Text panel for title and description
            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.setBackground(BACKGROUND_COLOR);

            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JLabel descLabel = new JLabel(description);
            descLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            descLabel.setForeground(Color.GRAY);

            textPanel.add(titleLabel);
            textPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            textPanel.add(descLabel);

            add(textPanel, BorderLayout.CENTER);

            // Add hover effect
            addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    setBackground(SELECTED_COLOR);
                    textPanel.setBackground(SELECTED_COLOR);
                }
                public void mouseExited(MouseEvent evt) {
                    setBackground(BACKGROUND_COLOR);
                    textPanel.setBackground(BACKGROUND_COLOR);
                }
            });
        }
    }
}
