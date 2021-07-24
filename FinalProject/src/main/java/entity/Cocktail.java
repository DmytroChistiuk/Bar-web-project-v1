package entity;

public class Cocktail {
    private int cocktailId;
    private String cocktailName;
    private String recipe;
    private String cocktailType;
    private String cocktailHistory;

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

    @Override
    public String toString() {
        return   cocktailName;
    }
}
