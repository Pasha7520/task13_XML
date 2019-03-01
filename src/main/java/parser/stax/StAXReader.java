package parser.stax;

import model.Beer;
import model.Chars;
import model.Ingredient;
import model.SpillMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXReader {
    public static List<Beer> parseBeers(File xml, File xsd){
        List<Beer> beerList = new ArrayList<>();
        Beer beer = null;
        Chars chars = null;
        SpillMethod spillMethod = null;
        List<Ingredient> ingredients = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));
            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    String name = startElement.getName().getLocalPart();
                    switch (name) {
                        case "beer":
                            beer = new Beer();

                            Attribute idAttr = startElement.getAttributeByName(new QName("beerNo"));
                            if (idAttr != null) {
                                beer.setBeerNo(Integer.parseInt(idAttr.getValue()));
                            }
                            break;
                        case "name":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert beer != null;
                            beer.setName(xmlEvent.asCharacters().getData());
                            break;
                        case "type":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert beer != null;
                            beer.setType(xmlEvent.asCharacters().getData());
                            break;
                        case "al":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert beer != null;
                            beer.setAl(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                            break;
                        case "manufacturer":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert beer != null;
                            beer.setManufacturer(xmlEvent.asCharacters().getData());
                            break;
                        case "ingredients":
                            xmlEvent = xmlEventReader.nextEvent();
                            ingredients = new ArrayList<>();
                            break;
                        case "ingredient":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert ingredients != null;
                            ingredients.add(new Ingredient(xmlEvent.asCharacters().getData()));
                            break;
                        case "chars":
                            xmlEvent = xmlEventReader.nextEvent();
                            chars = new Chars();
                            break;
                        case "alcFraction":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert chars != null;
                            chars.setAlcFraction(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "transparency":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert chars != null;
                            chars.setTransparency(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "filtered":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert chars != null;
                            chars.setFiltered(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                            break;
                        case "nutritions":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert chars != null;
                            chars.setNutritions(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "spillMethod":
                            xmlEvent = xmlEventReader.nextEvent();
                            spillMethod = new SpillMethod();
                            break;
                        case "vol":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert spillMethod != null;
                            spillMethod.setVol(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "tankMaterial":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert spillMethod != null;
                            spillMethod.setMaterial(xmlEvent.asCharacters().getData());
                            assert chars != null;
                            chars.setSpillMethod(spillMethod);
                            assert beer != null;
                            beer.setChars(chars);
                            beer.setIngredients(ingredients);
                            break;
                    }
                }

                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("beer")){
                        beerList.add(beer);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return beerList;
    }
}
