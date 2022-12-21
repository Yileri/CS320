public class Movie extends Product{

    private String directorName;

    public Movie(int productID, String productName, int year, String genre, String Name,boolean isReserved) {
        this.directorName=Name;

    }
    public Movie(int productID, String productName, String borrower, String dateBorrowed, String dateDue, boolean isReserved){

    }



    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}

