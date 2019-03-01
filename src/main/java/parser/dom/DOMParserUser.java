package parser.dom;

import model.Beer;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DOMParserUser {
    public static List<Beer> getBeerList(File xml, File xsd){
        DOMDocCreator creator = new DOMDocCreator(xml);
        Document doc = creator.getDocument();

           /*     try {
                   DOMValidator.validate(DOMValidator.createSchema(xsd),doc);
                }catch (IOException | SAXException ex){
                    ex.printStackTrace();
                }*/

        DOMDocReader reader = new DOMDocReader();

        return reader.readDoc(doc);
    }
}
