public class Student extends User {

    public Student(int userID, String userName, String userType) {
        super(userID, userName);
        userType="student";
    }
}
