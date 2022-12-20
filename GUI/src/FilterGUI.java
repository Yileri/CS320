import javax.swing.*;
import java.awt.*;

public class FilterGUI {

    public static void main(String args[]) {
        JFrame filterFrame = new JFrame("Filter");
        filterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        filterFrame.setSize(400, 400);
        filterFrame.setLocation(600, 120);

        JPanel filterPanel = new JPanel();
        JLabel typeLabel = new JLabel("Item Type:");
        JLabel genreLabel = new JLabel("Genre:");
        JLabel yearLabel = new JLabel("Year:");
        JLabel authorLabel = new JLabel("Author:");
        JLabel directorLabel = new JLabel("Director:");

        filterPanel.add(BorderLayout.NORTH, typeLabel);
        filterPanel.add(genreLabel);
        filterPanel.add(yearLabel);
        filterPanel.add(authorLabel);
        filterPanel.add(directorLabel);

        filterFrame.add(filterPanel);

        filterFrame.setVisible(true);


    }
}
