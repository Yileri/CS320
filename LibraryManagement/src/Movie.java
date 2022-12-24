public class Movie extends Product{

    private String directorName;

    public Movie(int productID, String productName, int year, String genre, String Name,boolean isReserved) {
        super(productID,productName, year,genre);
        this.directorName=Name;
    }




    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}


