package entity;
/*Сущность “Бар пользователя” требуется для хранения ингредиентов которые есть у пользователя.*/
public class UserBar {
    private int UserBarAlcoholId;
    private int UserBarSoftdrinkId;
    private int id;

    public int getUserBarAlcoholId() {
        return UserBarAlcoholId;
    }

    public void setUserBarAlcoholId(int userBarAlcoholId) {
        UserBarAlcoholId = userBarAlcoholId;
    }

    public int getUserBarSoftdrinkId() {
        return UserBarSoftdrinkId;
    }

    public void setUserBarSoftdrinkId(int userBarSoftdrinkId) {
        UserBarSoftdrinkId = userBarSoftdrinkId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
