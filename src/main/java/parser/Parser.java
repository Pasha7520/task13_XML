package parser;


import comparator.BeerComparator;
import filechecker.ExtensionChecker;
import model.Beer;
import parser.dom.DOMParserUser;
import parser.sax.SAXParserUser;
import parser.stax.StAXReader;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Parser {

  public static void main(String[] args) {
    File xml = new File("src\\main\\resources\\xml\\beerXML.xml");
    File xsd = new File("src\\main\\resources\\xml\\beerXSD.xsd");

    if (checkIfXML(xml) && checkIfXSD(xsd)) {
//            SAX
      printList(SAXParserUser.parseBeers(xml, xsd), "SAX");

//            StAX
      printList(StAXReader.parseBeers(xml, xsd), "StAX");

//            DOM
      printList(DOMParserUser.getBeerList(xml, xsd), "DOM");
    }
  }

  private static boolean checkIfXSD(File xsd) {
    return ExtensionChecker.isXSD(xsd);
  }

  private static boolean checkIfXML(File xml) {
    return ExtensionChecker.isXML(xml);
  }

  private static void printList(List<Beer> beers, String parserName) {
    Collections.sort(beers, new BeerComparator());
    System.out.println(parserName);
    for (Beer beer : beers) {
      System.out.println(beer);
    }
  }

}
