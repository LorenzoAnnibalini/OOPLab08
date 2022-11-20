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
            Objects.requireNonNull(stringa);
            this.nextString=stringa;
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
    public void printCurrentString() {
        System.out.println(nextString); //NOPMD
        lista.add(nextString);
    }

}
