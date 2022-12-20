public class Book extends Product{

    private String authorName;

    public Book (int productID, String productName, int year, String genre, String authorName, boolean isReserved){
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
