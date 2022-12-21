import javax.swing.*;
import java.awt.*;

public class FilterGUI extends JFrame {

    public static void main(String args[]) {
        JFrame filterFrame = new JFrame("Filter");
        filterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        filterFrame.setSize(400, 400);
        filterFrame.setLocation(600, 120);
        filterFrame.setLayout(new FlowLayout());

        JLabel typeLabel = new JLabel("Item Type:");
        JLabel genreLabel = new JLabel("Genre:");
        JLabel yearLabel = new JLabel("Year:");
        JLabel authorLabel = new JLabel("Author:");
        JLabel directorLabel = new JLabel("Director:");

        String types[] = {"Book", "Movie"};

        JComboBox typeBox = new JComboBox(types);

        JPanel typePanel = new JPanel();
        typePanel.add(typeLabel);
        typePanel.add(typeBox);

        filterFrame.add(typePanel);

        //filterFrame.add(typeLabel);
        //filterFrame.add(genreLabel);
        //filterFrame.add(yearLabel);
        //filterFrame.add(authorLabel);
        //filterFrame.add(directorLabel);

        //filterFrame.getContentPane().add(filterPanel);
        filterFrame.setVisible(true);


    }
}
