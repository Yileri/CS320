import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class FilterGUI extends JDialog {

    FilterGUI() {
        this.setTitle("Filter");
        this.setAlwaysOnTop(true);
        this.setModal(true);
        this.setSize(250, 300);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        JLabel typeLabel = new JLabel("Item Type:");
        JLabel genreLabel = new JLabel("Genre:");
        JLabel yearLabel = new JLabel("Year:");
        JLabel creatorLabel = new JLabel("Creator:");


        //dropdown menus
        String types[] = {"Book", "Movie"};
        JComboBox typeBox = new JComboBox(types);

        List<String> bookGenresDB = Library.listBookGenres();
        String[] bookGenres = new String[bookGenresDB.size()];
        for (int i=0; i<bookGenres.length; i++) {
            bookGenres[i] = bookGenresDB.get(i);
        }
        JComboBox bookGenreBox = new JComboBox(bookGenres);

        List<String> movieGenresDB = Library.listMovieGenres();
        String[] movieGenres = new String[movieGenresDB.size()];
        for (int i=0; i<movieGenres.length; i++) {
            movieGenres[i] = movieGenresDB.get(i);
        }
        JComboBox movieGenreBox = new JComboBox(movieGenres);

        List<String> bookYearsDB = Library.listBookYear();
        String[] bookYears = new String[bookYearsDB.size()];
        for (int i=0; i<bookYears.length; i++) {
            bookYears[i] = bookYearsDB.get(i);
        }
        JComboBox bookYearBox = new JComboBox(bookYears);

        List<String> movieYearsDB = Library.listMovieYear();
        String[] movieYears = new String[movieYearsDB.size()];
        for (int i=0; i<movieYears.length; i++) {
            movieYears[i] = movieYearsDB.get(i);
        }
        JComboBox movieYearBox = new JComboBox(movieYears);

        List<String> authorsDB = Library.listBookAuthor();
        String[] authors = new String[authorsDB.size()];
        for (int i=0; i<authors.length; i++) {
            authors[i] = authorsDB.get(i);
        }
        JComboBox authorBox = new JComboBox(authors);

        List<String> directorsDB = Library.listMovieDirector();
        String[] directors = new String[directorsDB.size()];
        for (int i=0; i<directors.length; i++) {
            directors[i] = directorsDB.get(i);
        }
        JComboBox directorBox = new JComboBox(directors);


        // panels for each dropdown menu
        JPanel typePanel = new JPanel();
        typePanel.add(typeLabel);
        typePanel.add(typeBox);

        JPanel genrePanel = new JPanel();
        genrePanel.add(genreLabel);
        genrePanel.add(bookGenreBox);

        JPanel yearPanel = new JPanel();
        yearPanel.add(yearLabel);
        yearPanel.add(bookYearBox);

        JPanel creatorPanel = new JPanel();
        creatorPanel.add(creatorLabel);
        creatorPanel.add(authorBox);

        JPanel buttonsPanel = new JPanel();
        JButton applyButton = new JButton("Apply");
        buttonsPanel.add(applyButton);


        // adding panels to main frame
        this.add(typePanel);
        this.add(genrePanel);
        this.add(yearPanel);
        this.add(creatorPanel);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        typeBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (typeBox.getSelectedItem().toString().equals("Book")) {
                    genrePanel.remove(movieGenreBox);
                    genrePanel.add(bookGenreBox);
                    genrePanel.validate();
                    yearPanel.remove(movieYearBox);
                    yearPanel.add(bookYearBox);
                    yearPanel.validate();
                    creatorPanel.remove(directorBox);
                    creatorPanel.add(authorBox);
                    creatorPanel.validate();
                } else if (typeBox.getSelectedItem().toString().equals("Movie")) {
                    genrePanel.remove(bookGenreBox);
                    genrePanel.add(movieGenreBox);
                    genrePanel.validate();
                    yearPanel.remove(bookYearBox);
                    yearPanel.add(movieYearBox);
                    yearPanel.validate();
                    creatorPanel.remove(authorBox);
                    creatorPanel.add(directorBox);
                    creatorPanel.validate();
                }
            }
        });

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.setVisible(true);
    }
}
