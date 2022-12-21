public class Book extends Product{

    private String authorName;

    public Book (int productID, String productName, int year, String genre, String authorName,String dateBorrowed, String dateDue, boolean isReserved){
        this.authorName = authorName;
    }

    public Book(int productID, String productName, String borrower, String dateBorrowed, String dateDue, boolean isReserved){

    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
