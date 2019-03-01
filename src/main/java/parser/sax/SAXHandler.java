package parser.sax;


import model.Beer;
import model.Chars;
import model.Ingredient;
import model.SpillMethod;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Beer> beerList = new ArrayList<>();
    private Beer beer = null;
    private List<Ingredient> ingredients = null;
    private Chars chars = null;
    private SpillMethod spillMethod = null;


    private boolean bName = false;
    private boolean bType = false;
    private boolean bAl = false;
    private boolean bManuf = false;
    private boolean bIngreds = false;
    private boolean bIngred = false;
    private boolean bChars = false;
    private boolean bAlc = false;
    private boolean bTrans = false;
    private boolean bFilt = false;
    private boolean bNutr = false;
    private boolean bSpill = false;
    private boolean bVol = false;
    private boolean bMater = false;

    public List<Beer> getBeerList(){
        return this.beerList;
    }

    public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("beer")){
            String beerN = attributes.getValue("beerNo");
            beer = new Beer();
            beer.setBeerNo(Integer.parseInt(beerN));
        }
        else if (qName.equalsIgnoreCase("name")){bName = true;}
        else if (qName.equalsIgnoreCase("type")){bType = true;}
        else if (qName.equalsIgnoreCase("al")){bAl = true;}
        else if (qName.equalsIgnoreCase("manufacturer")){bManuf = true;}
        else if (qName.equalsIgnoreCase("ingredients")){bIngreds = true;}
        else if (qName.equalsIgnoreCase("ingredient")){bIngred = true;}
        else if (qName.equalsIgnoreCase("chars")){bChars = true;}
        else if (qName.equalsIgnoreCase("alcFraction")){bAlc = true;}
        else if (qName.equalsIgnoreCase("transparency")){bTrans = true;}
        else if (qName.equalsIgnoreCase("filtered")){bFilt = true;}
        else if (qName.equalsIgnoreCase("nutritions")){bNutr = true;}
        else if (qName.equalsIgnoreCase("spillMethod")){bSpill = true;}
        else if (qName.equalsIgnoreCase("vol")){bVol = true;}
        else if (qName.equalsIgnoreCase("tankMaterial")){bMater = true;}
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("beer")){
            beerList.add(beer);
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bName){
            beer.setName(new String(ch, start, length));
            bName = false;
        }
        else if (bType){
            beer.setType(new String(ch, start, length));
            bType = false;
        }
        else if (bAl){
            beer.setAl(Boolean.parseBoolean(new String(ch, start, length)));
            bAl = false;
        }
        else if (bManuf){
            String manuf = new String(ch, start, length);
            beer.setManufacturer(manuf);
            bManuf = false;
        }
        else if(bIngreds){
            ingredients = new ArrayList<>();
            bIngreds = false;
        }
        else if (bIngred){
            Ingredient ingredient = new Ingredient();
            ingredient.setName(new String(ch, start, length));
            ingredients.add(ingredient);
            bIngred = false;
        }
        else if (bChars){
            chars = new Chars();
            bChars = false;
        }
        else if (bAlc){
            double alc = Double.parseDouble(new String(ch, start, length));
            chars.setAlcFraction(alc);
            bAlc = false;
        }
        else if (bTrans){
            double trans = Double.parseDouble(new String(ch, start, length));
            chars.setTransparency(trans);
            bTrans = false;
        }
        else if (bFilt){
            boolean filt = Boolean.parseBoolean(new String(ch, start, length));
            chars.setFiltered(filt);
            bFilt = false;
        }
        else if(bNutr){
            int nutr = Integer.parseInt(new String(ch, start, length));
            chars.setNutritions(nutr);
            bNutr = false;
        }
        else if (bSpill){
            spillMethod = new SpillMethod();
            bSpill = false;
        }
        else if (bVol){
            double vol = Double.parseDouble(new String(ch, start, length));
            spillMethod.setVol(vol);
            bVol = false;
        }
        else if (bMater){
            String mat = new String(ch, start, length);
            spillMethod.setMaterial(mat);
            chars.setSpillMethod(spillMethod);
            beer.setChars(chars);
            beer.setIngredients(ingredients);
            bMater = false;
        }
    }
}

