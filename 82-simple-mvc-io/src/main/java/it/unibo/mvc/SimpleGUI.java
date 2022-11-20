package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    final static String TITLE = "SimpleGUI";
    private final JFrame frame = new JFrame(TITLE);

    private SimpleGUI(final Controller controller) {
        final JPanel p1 = new JPanel();
        final JButton button = new JButton("Save");
        final JTextArea text = new JTextArea();
        p1.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(p1);
        p1.add(button, BorderLayout.SOUTH);
        p1.add(text, BorderLayout.CENTER);
        frame.setContentPane(p1);

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.saveOnFile(text.getText());
            }            
        });
    }

    private void display() {
        //Imposto dimensioni finestra
        final Dimension schermo = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) schermo.getWidth();
        final int height = (int) schermo.getHeight();
        System.out.println(width+" "+height);
        frame.setSize((width/5), (height/5));
        //non uso frame.pack() , ridimensiona la finestra male
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final Controller controller = new Controller();
        final SimpleGUI gui = new SimpleGUI(controller);
        gui.display();
    }

}
