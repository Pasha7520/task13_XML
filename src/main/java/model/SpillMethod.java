package model;

public class SpillMethod {
    private double vol;
    private String material;

    public SpillMethod() {}

    public SpillMethod(double vol, String material) {
        this.vol = vol;
        this.material = material;
    }

    public double getVol() {
        return vol;
    }

    public String getMaterial() {
        return material;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "SpillMethod{" +
                "vol=" + vol +
                ", material='" + material + '\'' +
                '}';
    }
}
