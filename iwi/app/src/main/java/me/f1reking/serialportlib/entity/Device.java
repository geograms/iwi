package me.f1reking.serialportlib.entity;

public class Device {
    private String name;
    private String root;
    private String path;
    private String driver;

    public Device(String name, String root, String path, String driver) {
        this.name = name;
        this.root = root;
        this.path = path;
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public String getRoot() {
        return root;
    }

    public String getPath() {
        return path;
    }

    public String getDriver() {
        return driver;
    }
}
