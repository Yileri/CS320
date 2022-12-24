public class User {

    private int userID;
    private String userName;

    private String userType;

    public User(int userID, String userName) {
        this.userID=userID;
        this.userName=userName;

    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(){

    }

    public int getUserID(){
        return userID;
    }
    public void setUserID(){

    }

    public String getUserType(){
        return userType;
    }
    public void setUserType(String s){
    this.userType=s;
    }


}
