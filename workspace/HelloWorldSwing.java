import javax.swing.*;        
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HelloWorldSwing {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        JMenuBar menuBar;
        JMenu menu;

        menuBar = new JMenuBar();
        frame.getContentPane().add(menuBar);
        //Build the first menu.
        menu = new JMenu("A Menu");
        menuBar.add(menu);
        JButton changeScreen=new JButton("change teh screen");
        frame.getContentPane().add(changeScreen);
        menuBar.add(changeScreen);
        JFrame frame2=new JFrame("NewScreen");
        JLabel boast=new JLabel("Julius  is the best Java Coder ever");
        frame2.getContentPane().add(boast);
        frame2.pack();
        changeScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(true);
                
            }
              });   
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        JButton b1 = new JButton("Press me");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("You Did It");
                
            }
              });   

        frame.getContentPane().add(b1);
  



        JButton b2 = new JButton("new phrase");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("heres another phrase");
                
            }
              });   
        frame.getContentPane().add(b2);

        JButton b3 = new JButton("new phrase");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("NYT games are fun");
                
            }
              });    
        frame.getContentPane().add(b3);



        JButton b4 = new JButton("new phrase");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("thats all the buttons");
                
            }
              });    
        frame.getContentPane().add(b4);

        //Display the window
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
