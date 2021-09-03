package entity;

import java.util.Objects;

public class UserBar {
    private int userId;
    private String cocktailName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBar userBar = (UserBar) o;
        return userId == userBar.userId &&
                Objects.equals(cocktailName, userBar.cocktailName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, cocktailName);
    }

    @Override
    public String toString() {
        return "UserBar{" +
                "userId=" + userId +
                ", cocktailName='" + cocktailName + '\'' +
                '}';
    }
}
