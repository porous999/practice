package Extra.trial.assignment3.part1;

import javax.swing.*;

public class MillionRectangles {
    public static void main(String args[]){
        JFrame thisFrame = new JFrame("My First GUI");
        thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame.setSize(500,500);
        /*JButton button = new JButton("Press");
        thisFrame.getContentPane().add(button); // Adds Button to content pane of frame*/
        thisFrame.getContentPane().add(new MyCanvas());
        thisFrame.setVisible(true);
    }
}
