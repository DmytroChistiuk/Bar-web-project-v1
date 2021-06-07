package entity;

public class CocktailInfo {
    private int id;
    private String name;
    private String cocktailType;
    private String recipe;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCocktailType() {
        return cocktailType;
    }

    public void setCocktailType(String cocktailType) {
        this.cocktailType = cocktailType;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }


}
