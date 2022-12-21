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

        String types[] = {"Select", "Book", "Movie"};
        JComboBox typeBox = new JComboBox(types);

        String years[] = new String[124];
        years[0] = "Select";
        for (int i=1900; i<2023; i++) {
            years[i-1899] =  "" + i;
        }
        JComboBox yearBox = new JComboBox(years);

        JPanel typePanel = new JPanel();
        typePanel.add(typeLabel);
        typePanel.add(typeBox);

        JPanel yearPanel = new JPanel();
        yearPanel.add(yearLabel);
        yearPanel.add(yearBox);

        filterFrame.add(typePanel);
        filterFrame.add(yearPanel);

        //filterFrame.add(typeLabel);
        //filterFrame.add(genreLabel);
        //filterFrame.add(yearLabel);
        //filterFrame.add(authorLabel);
        //filterFrame.add(directorLabel);

        //filterFrame.getContentPane().add(filterPanel);
        filterFrame.setVisible(true);


    }
}
