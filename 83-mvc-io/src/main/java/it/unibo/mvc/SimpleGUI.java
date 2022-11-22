package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final JPanel buttonPanel = new JPanel();
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        final JButton print = new JButton("Print");
        final JButton showHystory = new JButton("ShowHystory");
        frame.setContentPane(p1);
        p1.setLayout(new BorderLayout());
        buttonPanel.setLayout(new BorderLayout());
        p1.add(buttonPanel, BorderLayout.SOUTH);
        p1.add(textField, BorderLayout.NORTH);
        p1.add(textArea, BorderLayout.CENTER);
        buttonPanel.add(print, BorderLayout.EAST);
        buttonPanel.add(showHystory, BorderLayout.WEST);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.setNextStringtoPrint(textField.getText());
                controller.printCurrentString();
            } });

        showHystory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                textArea.setText(controller.getPrintedStringsHystory().toString());
            } });
    }

    private void display() {
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.display();
    }

}
