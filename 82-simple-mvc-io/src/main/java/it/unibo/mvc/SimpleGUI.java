package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    private SimpleGUI(final Controller controller) {
        final JPanel p1 = new JPanel();
        final JButton button = new JButton("Save");
        final JTextArea text = new JTextArea();
        p1.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(p1);
        p1.add(button, BorderLayout.SOUTH);
        p1.add(text, BorderLayout.CENTER);

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.saveOnFile(null);
            }            
        });
    }

    private void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final Controller controller = new Controller();
        final SimpleGUI gui = new SimpleGUI(controller);
        gui.display();
    }

}
