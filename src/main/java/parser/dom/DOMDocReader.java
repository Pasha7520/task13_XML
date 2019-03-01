package parser.dom;

import model.Beer;
import model.Chars;
import model.Ingredient;
import model.SpillMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMDocReader {
    public List<Beer> readDoc(Document doc){
        doc.getDocumentElement().normalize();
        List<Beer> beers = new ArrayList<>();

        NodeList nodeList = doc.getElementsByTagName("beer");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Beer beer = new Beer();
            Chars chars;
            List<Ingredient> ingredients;
            SpillMethod spillMethod;

            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;

                beer.setBeerNo(Integer.parseInt(element.getAttribute("beerNo")));
                beer.setName(element.getElementsByTagName("name").item(0).getTextContent());
                beer.setType(element.getElementsByTagName("type").item(0).getTextContent());
                beer.setAl(Boolean.parseBoolean(element.getElementsByTagName("al").item(0).getTextContent()));
                beer.setManufacturer(element.getElementsByTagName("manufacturer").item(0).getTextContent());


                ingredients = getIngredients(element.getElementsByTagName("ingredients"));
                chars = getChars(element.getElementsByTagName("chars"));
                spillMethod = getSpillMethod(element.getElementsByTagName("spillMethod"));


                chars.setSpillMethod(spillMethod);
                beer.setChars(chars);
                beer.setIngredients(ingredients);
                beers.add(beer);
            }
        }
        return beers;
    }

    private List<Ingredient> getIngredients(NodeList nodes){
        List<Ingredient> ingredients = new ArrayList<>();
        if(nodes.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodes.item(0);
            NodeList nodeList = element.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element el = (Element) node;
                    ingredients.add(new Ingredient(el.getTextContent()));
                }
            }
        }

        return ingredients;
    }

    private Chars getChars(NodeList nodes){
        Chars chars = new Chars();
        if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodes.item(0);
            chars.setAlcFraction(Double.parseDouble(element.getElementsByTagName("alcFraction").item(0).getTextContent()));
            chars.setFiltered(Boolean.parseBoolean(element.getElementsByTagName("filtered").item(0).getTextContent()));
            chars.setTransparency(Double.parseDouble(element.getElementsByTagName("transparency").item(0).getTextContent()));
            chars.setNutritions(Integer.parseInt(element.getElementsByTagName("nutritions").item(0).getTextContent()));
        }

        return chars;
    }

    private SpillMethod getSpillMethod(NodeList nodes){
        SpillMethod spillMethod = new SpillMethod();
        if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodes.item(0);
            spillMethod.setVol(Double.parseDouble(element.getElementsByTagName("vol").item(0).getTextContent()));
            spillMethod.setMaterial(element.getElementsByTagName("tankMaterial").item(0).getTextContent());
        }
        return spillMethod;
    }
}
