/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MajorScales;
import javax.swing.*;
//import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author Nonso
 */
public class PopUp extends JFrame {
    final int WINDOW_WIDTH = 300;
    final int WINDOW_HEIGHT = 200;
    private final JPanel panel;
    private JLabel label1;
    private JLabel label2;
    
    
    public PopUp(){
    setTitle("Music Major Scales");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setLayout(new BorderLayout());
    setLocation(200,200);
    panel = new JPanel(new GridLayout(2, 1,-40,0));
    greeting();
    panel.add(label1);
    panel.add(label2);
    panel.setBackground(Color.CYAN);
    add(panel);
    
}
    public void greeting(){
    label1 = new JLabel("Hey, Welcome to Major Music Scales Game");
    label2 = new JLabel("Please don't forget to rate us");  
    label1.setForeground(Color.MAGENTA);
    label2.setForeground(Color.RED);
    }
    
   
}

