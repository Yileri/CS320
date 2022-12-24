import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibraryListGUI extends JFrame{
    public static void main(String args[]) {
        LibraryListGUI librarylist = new LibraryListGUI();
    }

    JButton reserveButton = new JButton();

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


        //creating book table
        String[] bookColumns = {"ID", "Name", "Genre", "Year", "Author", "Available", "Reserve"};
        DefaultTableModel bookTableModel = new DefaultTableModel(bookColumns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };


        ArrayList<Book> bookDatas = SelectionTool.getAllBooks();

        for (int i=0; i<bookDatas.size(); i++) {
            String id = bookDatas.get(i).getProductID() + "";
            String name = bookDatas.get(i).getProductName();
            String genre = bookDatas.get(i).getGenre();
            String year = bookDatas.get(i).getYear() + "";
            String author = bookDatas.get(i).getAuthorName();
            String reserved = bookDatas.get(i).getIsReserved() + "";

            Object[] bookData = {id, name, genre, year, author, reserved};
            bookTableModel.addRow(bookData);
        }

        JTable bookTable = new JTable(bookTableModel);

        bookTable.getColumn("Reserve").setCellRenderer(new ButtonRenderer());
        bookTable.getColumn("Reserve").setCellEditor(new ButtonEditor(new JCheckBox()));

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Do you want to reserve this item?");
            }
        });

        // creating movie table
        String[] movieColumns = {"ID", "Name", "Genre", "Year", "Director", "Available", "Reserve"};

        DefaultTableModel movieTableModel = new DefaultTableModel(movieColumns, 0){

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };

        ArrayList<Movie> movieDatas = SelectionTool.getAllMovies();

        for (int i=0; i<movieDatas.size(); i++) {
            String id = movieDatas.get(i).getProductID() + "";
            String name = movieDatas.get(i).getProductName();
            String genre = movieDatas.get(i).getGenre();
            String year = movieDatas.get(i).getYear() + "";
            String director = movieDatas.get(i).getDirectorName();
            String reserved = movieDatas.get(i).getIsReserved() + "";

            Object[] movieData = {id, name, genre, year, director, reserved};
            movieTableModel.addRow(movieData);
        }

        JTable movieTable = new JTable(movieTableModel);

        movieTable.getColumn("Reserve").setCellRenderer(new ButtonRenderer());
        movieTable.getColumn("Reserve").setCellEditor(new ButtonEditor(new JCheckBox()));

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

        JFrame requestedMovies = new JFrame("Requested Movies");
        requestedMovies.setSize(550, 500);
        requestedMovies.setLayout(new FlowLayout());
        requestedMovies.setLocationRelativeTo(null);

        JFrame requestedBooks = new JFrame("Requested Books");
        requestedBooks.setSize(550, 500);
        requestedBooks.setLayout(new FlowLayout());
        requestedBooks.setLocationRelativeTo(null);

        //JTable requestedBookTable = new JTable(bookDatas, bookColumns);
        //JScrollPane requestedBookScrollPane = new JScrollPane(requestedBookTable);
        //bookScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //requestedBooks.add(requestedBookScrollPane);

        //JTable requestedMoviesTable = new JTable(movieDatas, movieColumns);
        //JScrollPane requestedMoviesScrollPane = new JScrollPane(requestedMoviesTable);
        //bookScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //requestedMovies.add(requestedMoviesScrollPane);

        showBookList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestedBooks.setVisible(true);
            }
        });

        showMovieList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestedMovies.setVisible(true);
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

        //JTable for requested items



        libFrame.add(mb);
        libFrame.setJMenuBar(mb);
        //libFrame.setLayout(null);
        libFrame.setVisible(true);
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Reserve" : value.toString());
            return this;
        }
    }
    class ButtonEditor extends DefaultCellEditor {
        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            label = (value == null) ? "Reserve" : value.toString();
            reserveButton.setText(label);
            return reserveButton;
        }

        public Object getCellEditorValue() {
            return new String(label);
        }
    }

}
