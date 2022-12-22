import javax.swing.*;

public class RequestMovieGUI extends JDialog{

    RequestMovieGUI() {

        this.setTitle("Requested Movie Details");
        this.setModal(true);

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

        this.add(nameLabel);
        this.add(genreLabel);
        this.add(directorLabel);
        this.add(yearLabel);

        //Text Fields
        JTextField nameField = new JTextField();
        nameField.setBounds(110, 15, 200, 30);

        JTextField genreField=new JTextField();
        genreField.setBounds(110, 50, 200, 30);

        JTextField directorField=new JTextField();
        directorField.setBounds(110, 85, 200, 30);

        JTextField yearField=new JTextField();
        yearField.setBounds(110, 120, 200, 30);

        this.add(nameField);
        this.add(genreField);
        this.add(yearField);
        this.add(directorField);

        //Submit Button
        JButton submitButton=new JButton("Submit Request");
        submitButton.setBounds(120,160,130,25);

        this.add(submitButton);

        this.setSize(370,250);//400 width and 500 height
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
