package model;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    private int beerNo;
    private String name;
    private String type;
    private boolean al;
    private String manufacturer;
    private List<Ingredient> ingredients = new ArrayList<>();
    private Chars chars;

    public Beer() {
    }

    public Beer(int beerNo, String name, String type, boolean al, String manufacturer, List<Ingredient> ingredients, Chars chars) {
        this.beerNo = beerNo;
        this.name = name;
        this.type = type;
        this.al = al;
        this.manufacturer = manufacturer;
        this.ingredients = ingredients;
        this.chars = chars;
    }

    public int getBeerNo() {
        return beerNo;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isAl() {
        return al;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Chars getChars() {
        return chars;
    }

    public void setBeerNo(int beerNo) {
        this.beerNo = beerNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAl(boolean al) {
        this.al = al;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIgredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "beerNo=" + beerNo +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", al=" + al +
                ", manufacturer='" + manufacturer + '\'' +
                ", ingredients=" + ingredients +
                ", chars=" + chars +
                '}';
    }
}
