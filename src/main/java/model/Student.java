package model;

public class Student {
    private int id;
    private String name;
    private String code;
    private String classes;

    public Student(int id, String name, String code, String classes) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.classes = classes;
    }

    public Student(String name, String code, String classes) {
        this.name = name;
        this.code = code;
        this.classes = classes;
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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
