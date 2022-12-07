import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LibraryListGUI implements ActionListener {
    public static void main(String args[]) {
        JFrame libFrame = new JFrame("ULMS");
        libFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        libFrame.setSize(700, 700);
        libFrame.setLocation(new Point(400, 40));

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

        JMenu reserve, filter, request;
        JMenuBar mb = new JMenuBar();
        reserve = new JMenu("Reserve");
        filter = new JMenu("Filter");
        request = new JMenu("Request");

        mb.add(reserve);
        mb.add(filter);
        mb.add(request);
        libFrame.add(mb);
        libFrame.setJMenuBar(mb);
        libFrame.setLayout(null);
        libFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
