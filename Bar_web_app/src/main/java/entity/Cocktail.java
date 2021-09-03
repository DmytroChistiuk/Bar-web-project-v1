package entity;

import java.util.Objects;

public class Cocktail {
    private int cocktailId;
    private String cocktailName;
    private String recipe;
    private String cocktailType;
    private String cocktailHistory;
    private String cocktailIcon;
    private String cocktailPhoto;

    public int getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(int cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getCocktailType() {
        return cocktailType;
    }

    public void setCocktailType(String cocktailType) {
        this.cocktailType = cocktailType;
    }

    public String getCocktailHistory() {
        return cocktailHistory;
    }

    public void setCocktailHistory(String cocktailHistory) {
        this.cocktailHistory = cocktailHistory;
    }

    public String getCocktailIcon() {
        return cocktailIcon;
    }

    public void setCocktailIcon(String cocktailIcon) {
        this.cocktailIcon = cocktailIcon;
    }

    public String getCocktailPhoto() {
        return cocktailPhoto;
    }

    public void setCocktailPhoto(String cocktailPhoto) {
        this.cocktailPhoto = cocktailPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cocktail cocktail = (Cocktail) o;
        return cocktailId == cocktail.cocktailId &&
                Objects.equals(cocktailName, cocktail.cocktailName) &&
                Objects.equals(recipe, cocktail.recipe) &&
                Objects.equals(cocktailType, cocktail.cocktailType) &&
                Objects.equals(cocktailHistory, cocktail.cocktailHistory) &&
                Objects.equals(cocktailIcon, cocktail.cocktailIcon) &&
                Objects.equals(cocktailPhoto, cocktail.cocktailPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cocktailId, cocktailName, recipe, cocktailType, cocktailHistory, cocktailIcon, cocktailPhoto);
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "cocktailId=" + cocktailId +
                ", cocktailName='" + cocktailName + '\'' +
                ", recipe='" + recipe + '\'' +
                ", cocktailType='" + cocktailType + '\'' +
                ", cocktailHistory='" + cocktailHistory + '\'' +
                ", cocktailIcon='" + cocktailIcon + '\'' +
                ", cocktailPhoto='" + cocktailPhoto + '\'' +
                '}';
    }
}
