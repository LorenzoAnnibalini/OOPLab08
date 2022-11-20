package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> lista = new ArrayList<>();
    private String nextString ;

    @Override
    public void setNextStringtoPrint(final String stringa) {
        this.nextString = Objects.requireNonNull(stringa);
    }

    @Override
    public String getNextStringtoPrint() {
        return this.nextString;
    }

    @Override
    public List<String> getPrintedStringsHystory() {
        return List.copyOf(lista);
    }

    @Override
    public void printCurrentString() throws IllegalStateException {
        if(this.nextString == null) { 
            throw  new IllegalStateException();
        }
        System.out.println(this.nextString); //NOPMD
        lista.add(this.nextString);
    }

}
