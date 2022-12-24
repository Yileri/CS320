public class Product {

    private int productID;
    private String productName;
    private int year;
    private String genre;

    private boolean isReserved=false;

    private String dateBorrowed=null;

    private  String dateDue=null;
    private String borrower=null;

    public Product(int productID,String productName,int year,String genre){
        this.productID=productID;
        this.productName=productName;
        this.year=year;
        this.genre=genre;
    }



    public int getProductID(){
        return productID;
    }
    public void setProductID(){

    }
    public String getProductName(){
        return productName;
    }

    public void setProductName(){

    }

    public int getYear(){
        return year;
    }
    public boolean getIsReserved() {
        return isReserved;
    }

    public void setYear(){

    }

    public String getGenre(){
        return genre;
    }
    public void setIsReserved(boolean b) {
        this.isReserved=b;
    }

    public void setGenre(){

    }
    public String getDateBorrowed(){
        return genre;
    }

    public void setDateBorrowed(){

    }

    public String getDateDue(){
        return genre;
    }

    public void setDateDue(){

    }



}
