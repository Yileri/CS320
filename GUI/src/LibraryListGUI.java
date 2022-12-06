import javax.swing.*;
import java.awt.*;

public class LibraryListGUI {
    public static void main(String args[]) {
        JFrame libFrame = new JFrame("ULMS");
        libFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        libFrame.setSize(700,700);
        libFrame.setLocation(new Point(400, 40));
        libFrame.setVisible(true);

        JPanel searchPanel = new JPanel();
        JLabel searchLabel = new JLabel("Search Items:");
        JTextField searchBarTextField = new JTextField(30);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchLabel);
        searchPanel.add(searchBarTextField);
        searchPanel.add(searchButton);

        libFrame.getContentPane().add(BorderLayout.NORTH, searchPanel);

        JPanel itemPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(itemPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        libFrame.add(BorderLayout.CENTER, scrollPane);
        libFrame.setVisible(true);
    }
}
