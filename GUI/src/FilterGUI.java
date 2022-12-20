import javax.swing.*;
import java.awt.*;

public class FilterGUI {

    public static void main(String args[]) {
        JFrame filterFrame = new JFrame("Filter");
        filterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        filterFrame.setSize(400, 400);
        filterFrame.setLocation(600, 120);

        JPanel filterPanel = new JPanel();

        filterFrame.add(filterPanel);

        filterFrame.setVisible(true);


    }
}
