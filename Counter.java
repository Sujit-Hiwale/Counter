import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
public class Counter {
    int wordCounter(String s){
        String trimmedString = s.trim();
        String[] words = trimmedString.split("\\s+");
        return words.length;
    }
    int sentenceCounter(String s){
        String[] sentences = s.split("[.!?]\\s*");
        return sentences.length;
    }
    public static void main(String[]args){
        ImageIcon icon = new ImageIcon("./Logo.png");
        Frame f = new Frame("Counter");
        f.setIconImage(icon.getImage());
        TextArea tf = new TextArea("");
        Label l = new Label("Enter Your Text:");
        Button wc = new Button("Word Counter");
        Button sc = new Button("Sentence Counter");
        Label result = new Label("");
        f.add(l);
        f.add(tf);
        tf.setRows(5);
        tf.setColumns(50);
        Panel button = new Panel();
        button.add(wc);
        button.add(sc);
        f.add(button);
        f.add(result);
        f.setSize(400,300);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(new FlowLayout(FlowLayout.CENTER));
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        Counter w = new Counter();
        wc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String str = tf.getText();
                int Count = w.wordCounter(str);
                result.setText("\t\t\t\t\t\t\t Word Count: "+Count);
                f.validate();
                f.repaint();
            }
        });
        sc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String str = tf.getText();
                int Count = w.sentenceCounter(str);
                result.setText("\t\t\t\t\t\t\t Sentence Count: "+Count);
                f.validate();
                f.repaint();
            }
        });
    }
}