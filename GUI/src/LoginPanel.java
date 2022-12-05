import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel implements ActionListener {
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    public static void main(String[] args) {

        /* //Version1

        JFrame frame = new JFrame("Login Screen");

        JPanel panel = new JPanel();

        JLabel userLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordText = new JPasswordField(20);
        JTextField userText = new JTextField(20);
        JButton button = new JButton("Login");

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(button);

        frame.add(panel);
        frame.setSize(320, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

        ////Version2
        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // JFrame class
        JFrame frame = new JFrame();
        frame.setTitle("Login Page");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(500, 300));

        // Username
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(150, 45, 70, 20);
        panel.add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setBounds(150, 65, 200, 30);
        panel.add(usernameField);

        // Password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(150, 95, 70, 20);
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 113, 200, 30);
        panel.add(passwordField);

        // Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 147, 200, 27);
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(Color.CYAN);
        loginButton.addActionListener(new LoginPanel());
        panel.add(loginButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("123456"))
            JOptionPane.showMessageDialog(null, "Login Successful");
            //Buradan ana ekrana
        else
            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
            //Kendisi tekrar giriş ekranına dönüyor, daha doğrusu giriş ekranı kapanmıyor.
    }
}