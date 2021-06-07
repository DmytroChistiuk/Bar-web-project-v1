package entity;

public class CocktailIngredient {
    private String name;
    private int alcoholId;
    private int softdrinkId;
    private int additiveId;
    private String decoration;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlcoholId() {
        return alcoholId;
    }

    public void setAlcoholId(int alcoholId) {
        this.alcoholId = alcoholId;
    }

    public int getSoftdrinkId() {
        return softdrinkId;
    }

    public void setSoftdrinkId(int softdrinkId) {
        this.softdrinkId = softdrinkId;
    }

    public int getAdditiveId() {
        return additiveId;
    }

    public void setAdditiveId(int additiveId) {
        this.additiveId = additiveId;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
