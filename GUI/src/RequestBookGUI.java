import javax.swing.*;

public class RequestBookGUI extends JDialog {

    RequestBookGUI() {

        this.setTitle("Requested Book Details");
        this.setModal(true);

        //Labels
        JLabel nameLabel,genreLabel,typeLabel,yearLabel;
        nameLabel=new JLabel("Name:");
        nameLabel.setBounds(30,15, 100,30);

        genreLabel=new JLabel("Genre:");
        genreLabel.setBounds(30,50, 100,30);

        typeLabel=new JLabel("Author:");
        typeLabel.setBounds(30,85, 100,30);

        yearLabel=new JLabel("Year:");
        yearLabel.setBounds(30,120, 100,30);

        this.add(nameLabel);
        this.add(genreLabel);
        this.add(typeLabel);
        this.add(yearLabel);

        //Text Fields
        JTextField nameField = new JTextField();
        nameField.setBounds(110, 15, 200, 30);

        JTextField genreField=new JTextField();
        genreField.setBounds(110, 50, 200, 30);

        JTextField authorField=new JTextField();
        authorField.setBounds(110, 85, 200, 30);

        JTextField yearField=new JTextField();
        yearField.setBounds(110, 120, 200, 30);

        this.add(nameField);
        this.add(genreField);
        this.add(yearField);
        this.add(authorField);

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
