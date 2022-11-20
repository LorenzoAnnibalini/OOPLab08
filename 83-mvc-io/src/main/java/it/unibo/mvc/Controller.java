package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextStringtoPrint(String stringa);

    String getNextStringtoPrint();

    List<String> getPrintedStringsHystory();

    void printCurrentString();

}
