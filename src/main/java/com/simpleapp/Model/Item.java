package com.simpleapp.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by amuzanenhamo on 14/05/2017.
 */
@Entity
public class Item {

    @Id
    private String id;
    private String name;
    private String description;
    private String category;

    public Item() {}

    public Item(String id, String name, String description, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
