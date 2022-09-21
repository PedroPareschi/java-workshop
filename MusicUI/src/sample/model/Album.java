package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Album {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty artistsId;

    public Album() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.artistsId = new SimpleIntegerProperty();
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getArtistsId() {
        return artistsId.get();
    }

    public SimpleIntegerProperty artistsIdProperty() {
        return artistsId;
    }

    public void setArtistsId(int artistsId) {
        this.artistsId.set(artistsId);
    }
}
