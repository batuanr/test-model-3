package model;

public class Book {
    private int id;
    private String name;
    private String code;
    private int quantity;

    public Book(int id, String name, String code, int quantity) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.quantity = quantity;
    }

    public Book(String name, String code, int quantity) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
