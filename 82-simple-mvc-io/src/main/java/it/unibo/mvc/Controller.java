package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOMEFOLDERPATH = System.getProperty("user.home");
    private File file = new File(HOMEFOLDERPATH + File.separator + "output.txt");

    public void setFile(final File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public String getPath() {
        return this.file.getPath();
    }

    public void saveOnFile(final String stringa) { 
        try (PrintStream ps = new PrintStream(this.getPath(), StandardCharsets.UTF_8)) {
            ps.print(stringa);
        } catch (IOException e1) {
            System.out.println("Errore in lettura"); //NOPMD
            e1.printStackTrace(); // NOPMD
        }
    }

}
