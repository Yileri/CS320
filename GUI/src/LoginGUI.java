import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI {
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    static boolean isAdmin = false;

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

        // Sign In Button
        JButton loginButton = new JButton("Sign In");
        loginButton.setBounds(150, 147, 110, 27);
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(Color.CYAN);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                int id = Integer.parseInt(passwordField.getText());

                if (Library.SignIn(username,id)) {
                    isAdmin = true;
                    Library.isSignedIn = true;
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    frame.setVisible(false);
                    LibraryListGUI librarylist = new LibraryListGUI();
                }
            }
        });

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(250, 147, 99, 27);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.CYAN);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(loginButton);
        panel.add(exitButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}