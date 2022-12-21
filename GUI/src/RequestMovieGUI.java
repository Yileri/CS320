import javax.swing.*;

public class RequestMovieGUI {

    RequestMovieGUI() {

        JFrame frame = new JFrame("Requested Movie Details");

        //Labels
        JLabel nameLabel,genreLabel,directorLabel,yearLabel;
        nameLabel=new JLabel("Name:");
        nameLabel.setBounds(30,15, 100,30);

        genreLabel=new JLabel("Genre:");
        genreLabel.setBounds(30,50, 100,30);

        directorLabel=new JLabel("Director:");
        directorLabel.setBounds(30,85, 100,30);

        yearLabel=new JLabel("Year:");
        yearLabel.setBounds(30,120, 100,30);

        frame.add(nameLabel);
        frame.add(genreLabel);
        frame.add(directorLabel);
        frame.add(yearLabel);

        //Text Fields
        JTextField nameField = new JTextField();
        nameField.setBounds(110, 15, 200, 30);

        JTextField genreField=new JTextField();
        genreField.setBounds(110, 50, 200, 30);

        JTextField directorField=new JTextField();
        directorField.setBounds(110, 85, 200, 30);

        JTextField yearField=new JTextField();
        yearField.setBounds(110, 120, 200, 30);

        frame.add(nameField);
        frame.add(genreField);
        frame.add(yearField);
        frame.add(directorField);

        //Submit Button
        JButton submitButton=new JButton("Submit Request");
        submitButton.setBounds(120,160,130,25);

        frame.add(submitButton);

        frame.setSize(370,250);//400 width and 500 height
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
