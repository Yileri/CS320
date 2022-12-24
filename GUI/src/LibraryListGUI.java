import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LibraryListGUI {
    public static void main(String args[]) {
        LibraryListGUI librarylist = new LibraryListGUI();
    }

    LibraryListGUI(){
        JFrame libFrame = new JFrame("ULMS");
        libFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        libFrame.setSize(600, 575);
        libFrame.setLayout(new FlowLayout());
        libFrame.setLocationRelativeTo(null);

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

        libFrame.add(searchPanel);

        JPanel bookRadioPanel = new JPanel();
        JLabel booksLabel = new JLabel("Books:");
        JRadioButton bookTypeButton = new JRadioButton();

        JPanel movieRadioPanel = new JPanel();
        JLabel moviesLabel = new JLabel("Movies:");
        JRadioButton movieTypeButton = new JRadioButton();

        ButtonGroup typeGroup = new ButtonGroup();

        bookRadioPanel.add(booksLabel);
        bookRadioPanel.add(bookTypeButton);

        movieRadioPanel.add(moviesLabel);
        movieRadioPanel.add(movieTypeButton);

        libFrame.add(bookRadioPanel, BorderLayout.WEST);
        libFrame.add(movieRadioPanel, BorderLayout.WEST);

        typeGroup.add(bookTypeButton);
        typeGroup.add(movieTypeButton);

        bookTypeButton.setSelected(true);

        //tables
        String[] bookColumns = {"ID", "Name", "Genre", "Year", "Author", "Reserved"};
        String[][] bookDatas = {
                {"1", "To Kill a Mockingbird", "Fiction", "1960", "Harper Lee", "Yes"},
                {"2", "The Great Gatsby", "Fiction", "1925", "F. Scott Fitzgerald", "Yes"},
                {"3", "The Catcher in the Rye", "Fiction", "1951", "J.D. Salinger", "Yes"},
                {"4", "The Grapes of Wrath", "Fiction", "1939", "John Steinbeck", "Yes"},
        };

        JTable bookTable = new JTable(bookDatas, bookColumns);

        String[] movieColumns = {"ID", "Name", "Genre", "Year", "Director", "Reserved"};
        String[][] movieDatas = {
                {"1", "Spider-Man", "Action", "2002", "Sam Raimi", "No"},
                {"2", "Spider-Man 2", "Action", "2004", "Sam Raimi", "Yes"},
                {"3", "Spider-Man 3", "Action", "2007", "Sam Raimi", "No"},
                {"4", "The Amazing Spider-Man", "Action", "2012", "Marc Webb", "No"},
                {"5", "The Amazing Spider-Man 2", "Action", "2014", "Marc Webb", "Yes"},
                {"6", "Spider-Man: Homecoming", "Action", "2017", "Jon Watts", "No"},
                {"7", "Spider-Man: Far From Home", "Action", "2019", "Jon Watts", "No"},
                {"8", "Spider-Man: No Way Home", "Action", "2021", "Jon Watts", "Yes"}
        };

        JTable movieTable = new JTable(movieDatas, movieColumns);

        JScrollPane bookScrollPane = new JScrollPane(bookTable);
        bookScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollPane movieScrollPane = new JScrollPane(movieTable);
        movieScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        libFrame.add(bookScrollPane);

        // switch to book list
        bookTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libFrame.remove(movieScrollPane);
                libFrame.add(bookScrollPane);
                libFrame.validate();
            }
        });

        // switch to movie list
        movieTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libFrame.remove(bookScrollPane);
                libFrame.add(movieScrollPane);
                libFrame.validate();
            }
        });

        JMenu reserve,request, returnItem, addRemoveItem, requestedItems;
        JMenuItem requestBook, requestMovie, showBookList, showMovieList;
        JMenuBar mb = new JMenuBar();
        reserve = new JMenu("Reserve");
        request = new JMenu("Request");
        returnItem = new JMenu("Return Item");
        addRemoveItem = new JMenu("Add/Remove Item");
        requestedItems = new JMenu("Requested Items");
        requestBook = new JMenuItem("Request Book");
        requestMovie = new JMenuItem("Request Movie");
        showBookList = new JMenuItem("Show Requested Book List");
        showMovieList = new JMenuItem("Show Requested Movie List");
        requestedItems.add(showBookList);
        requestedItems.add(showMovieList);
        request.add(requestBook);
        request.add(requestMovie);

        showBookList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Requested Items List Opens Up
            }
        });
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

        mb.add(reserve);
        //mb.add(filter);
        mb.add(request);
        mb.add(returnItem);

        if(LoginGUI.isAdmin){
            mb.add(addRemoveItem);
            mb.add(requestedItems);
        }

        libFrame.add(mb);
        libFrame.setJMenuBar(mb);
        //libFrame.setLayout(null);
        libFrame.setVisible(true);
    }
}
