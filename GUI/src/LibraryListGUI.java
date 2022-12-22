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
        JButton filterButton = new JButton("Filter");
        JLabel searchLabel = new JLabel("Search Items:");
        JTextField searchBarTextField = new JTextField(30);
        JButton searchButton = new JButton("Search");
        searchPanel.add(filterButton);
        searchPanel.add(searchLabel);
        searchPanel.add(searchBarTextField);
        searchPanel.add(searchButton);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilterGUI filterFrame = new FilterGUI();
            }
        });

        libFrame.getContentPane().add(BorderLayout.NORTH, searchPanel);

        String[] itemColumns = {"ID", "Name", "Genre", "Year", "Author/Director", "Reserved"};
        String[][] itemDatas = {
                {"1", "Spider-Man", "Action", "2002", "Sam Raimi", "No"},
                {"2", "Spider-Man 2", "Action", "2004", "Sam Raimi", "Yes"},
                {"3", "Spider-Man 3", "Action", "2007", "Sam Raimi", "No"},
                {"4", "The Amazing Spider-Man", "Action", "2012", "Marc Webb", "No"},
                {"5", "The Amazing Spider-Man 2", "Action", "2014", "Marc Webb", "Yes"},
                {"6", "Spider-Man: Homecoming", "Action", "2017", "Jon Watts", "No"},
                {"7", "Spider-Man: Far From Home", "Action", "2019", "Jon Watts", "No"},
                {"8", "Spider-Man: No Way Home", "Action", "2021", "Jon Watts", "Yes"}
        };

        JTable itemTable = new JTable(itemDatas, itemColumns);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        libFrame.add(BorderLayout.CENTER, scrollPane);
        libFrame.setVisible(true);

        JMenu reserve, filter, request, returnItem, addItem;
        JMenuItem requestBook, requestMovie;
        JMenuBar mbUser = new JMenuBar();
        JMenuBar mbAdmin = new JMenuBar();
        reserve = new JMenu("Reserve");
        filter = new JMenu("Filter");
        request = new JMenu("Request");
        returnItem = new JMenu("Return Item");
        addItem = new JMenu("Add Item");
        requestBook = new JMenuItem("Request Book");
        requestMovie = new JMenuItem("Request Movie");
        request.add(requestBook);
        request.add(requestMovie);
        requestBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestBookGUI requestBook = new RequestBookGUI();
            }
        });

        requestMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestMovieGUI requestMovie = new RequestMovieGUI();
            }
        });


        mbUser.add(reserve);
        //mbUser.add(filter);
        mbUser.add(request);

        mbAdmin.add(reserve);
        //mbAdmin.add(filter);
        mbAdmin.add(request);
        mbAdmin.add(returnItem);
        mbAdmin.add(addItem);

        libFrame.add(mbAdmin);
        libFrame.setJMenuBar(mbAdmin);
        libFrame.setLayout(null);
        libFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
