package entity;

public class Game {
    private Long id;
    private String nameGame;
    private double price;
    private String companyName;

    public Game() {
    }

    public Game(final Long id, final String nameGame, final double price, final String companyName) {
        this.id = id;
        this.nameGame = nameGame;
        this.price = price;
        this.companyName = companyName;
    }

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(final String title) {
        this.nameGame = nameGame;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
