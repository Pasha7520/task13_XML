package model;

public class Chars {
    private double alcFraction;
    private double transparency;
    private boolean filtered;
    private int nutritions;
    private SpillMethod spillMethod;

    public Chars() {
    }

    public Chars(double alcFraction, double transparency, boolean filtered, int nutritions, SpillMethod spillMethod) {
        this.alcFraction = alcFraction;
        this.transparency = transparency;
        this.filtered = filtered;
        this.nutritions = nutritions;
        this.spillMethod = spillMethod;
    }

    public double getAlcFraction() {
        return alcFraction;
    }

    public double getTransparency() {
        return transparency;
    }

    public boolean isFiltered() {
        return filtered;
    }

    public int getNutritions() {
        return nutritions;
    }

    public SpillMethod getSpillMethod() {
        return spillMethod;
    }

    public void setAlcFraction(double alcFraction) {
        this.alcFraction = alcFraction;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }

    public void setNutritions(int nutritions) {
        this.nutritions = nutritions;
    }

    public void setSpillMethod(SpillMethod spillMethod) {
        this.spillMethod = spillMethod;
    }

    @Override
    public String toString() {
        return "Chars{" +
                "alcFraction=" + alcFraction +
                ", transparency=" + transparency +
                ", filtered=" + filtered +
                ", nutritions=" + nutritions +
                ", spillMethod=" + spillMethod +
                '}';
    }
}

