import javax.swing.*;
import java.awt.*;

public class FilterGUI extends JFrame {


    public static void main(String args[]) {
        JFrame filterFrame = new JFrame("Filter");
        filterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        filterFrame.setSize(250, 400);
        filterFrame.setLocation(600, 120);
        filterFrame.setLayout(new FlowLayout());

        JLabel typeLabel = new JLabel("Item Type:");
        JLabel genreLabel = new JLabel("Genre:");
        JLabel yearLabel = new JLabel("Year:");
        JLabel authorLabel = new JLabel("Author:");
        JLabel directorLabel = new JLabel("Director:");

        //dropdown menus
        String types[] = {"Select", "Book", "Movie"};
        JComboBox typeBox = new JComboBox(types);

        String genres[] = {"Select", "Action", "Adventure", "Comedy", "Drama",
                "Fantasy", "Fiction", "Historical Fiction",
                "Horror", "Mystery", "Romance", "Sci-Fi", "Thriller"};
        JComboBox genreBox = new JComboBox(genres);

        String years[] = new String[124];
        years[0] = "Select";
        for (int i=1900; i<2023; i++) {
            years[i-1899] =  "" + i;
        }
        JComboBox yearBox = new JComboBox(years);

        // panels for each dropdown menu
        JPanel typePanel = new JPanel();
        typePanel.add(typeLabel);
        typePanel.add(typeBox);

        JPanel genrePanel = new JPanel();
        genrePanel.add(genreLabel);
        genrePanel.add(genreBox);

        JPanel yearPanel = new JPanel();
        yearPanel.add(yearLabel);
        yearPanel.add(yearBox);

        // adding panels to main frame
        filterFrame.add(typePanel);
        filterFrame.add(genrePanel);
        filterFrame.add(yearPanel);

        filterFrame.setVisible(true);
    }
}
