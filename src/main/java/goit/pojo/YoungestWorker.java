package goit.pojo;

import java.time.LocalDate;

public class YoungestEldestWorker {
    private String type;
    private String name;
    private LocalDate date;

    public YoungestEldestWorker(String type, String name, LocalDate date) {
        this.type = type;
        this.name = name;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorker{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
