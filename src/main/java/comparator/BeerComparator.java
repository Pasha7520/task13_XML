package comparator;

import model.Beer;

import java.util.Comparator;

public class BeerComparator implements Comparator<Beer> {
    @Override
    public int compare(Beer o1, Beer o2) {
        return Double.compare(o1.getChars().getAlcFraction(), o2.getChars().getAlcFraction());
    }
}
