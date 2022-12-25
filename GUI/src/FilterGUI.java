import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FilterGUI extends JDialog {

    FilterGUI() {
        this.setTitle("Filter");
        this.setAlwaysOnTop(true);
        this.setModal(true);
        this.setSize(250, 400);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        JLabel typeLabel = new JLabel("Item Type:");
        JLabel genreLabel = new JLabel("Genre:");
        JLabel yearLabel = new JLabel("Year:");
        JLabel authorLabel = new JLabel("Author:");
        JLabel directorLabel = new JLabel("Director:");


        //dropdown menus
        String types[] = {"Select", "Book", "Movie"};
        JComboBox typeBox = new JComboBox(types);

        List<String> genresDB = Library.listBookGenres();
        String[] genres = new String[genresDB.size()+1];
        genres[0] = "Select";
        for (int i=1; i<genres.length; i++) {
            genres[i] = genresDB.get(i-1);
        }
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

        JPanel buttonsPanel = new JPanel();
        JButton clearButton = new JButton("Clear");
        JButton applyButton = new JButton("Apply");
        buttonsPanel.add(clearButton, BorderLayout.WEST);
        buttonsPanel.add(applyButton, BorderLayout.EAST);

        // function for clearing all filters
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeBox.setSelectedIndex(0);
                yearBox.setSelectedIndex(0);
                genreBox.setSelectedIndex(0);
            }
        });

        // adding panels to main frame
        this.add(typePanel);
        this.add(genrePanel);
        this.add(yearPanel);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
