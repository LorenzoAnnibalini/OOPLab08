package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.BorderLayout;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final String titolo = "SimpleGUIWithFileChooser";
    private final JFrame frame = new JFrame(titolo);

    private SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel p1 = new JPanel();
        final JPanel browserPanel = new JPanel();
        p1.setLayout(new BorderLayout());
        frame.setContentPane(p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton save = new JButton("Save");
        final JButton browse = new JButton("Browse");
        final JTextArea text = new JTextArea();
        final JTextField browsePath = new JTextField(controller.getPath());
        final JFileChooser chooser = new JFileChooser();
        p1.add(chooser);
        browsePath.setEditable(false);
        browserPanel.add(browsePath, BorderLayout.WEST);
        browserPanel.add(browse, BorderLayout.EAST);
        p1.add(browserPanel, BorderLayout.NORTH);
        p1.add(text, BorderLayout.CENTER);
        p1.add(save, BorderLayout.SOUTH);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    controller.saveOnFile(text.getText());
            }});
        
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(chooser.showSaveDialog(chooser) == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(chooser.getSelectedFile());
                    browsePath.setText(controller.getPath());
                } else {
                   // JOptionPane.showMessageDialog(chooser, arg0, titolo, 0);
                }
            }});

    }

    public void display() {
        //imposto grandezza finestra, uso metodo pack()
      
        /* final Dimension schermo = Toolkit.getDefaultToolkit().getScreenSize();
        final int size = 5;
        final int width = (int) schermo.getWidth();
        final int height = (int) schermo.getHeight();
        frame.setSize(width / size, height / size); */
       
        frame.pack();
        //finestra visibile da ora
        frame.setVisible(true);
    }

    public static void main(final String [] args) {
        SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }

}
