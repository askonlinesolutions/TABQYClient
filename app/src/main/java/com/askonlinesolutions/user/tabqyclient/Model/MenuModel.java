package com.askonlinesolutions.user.tabqyclient.Model;

public class MenuModel
{
   String food_name;
   String description;
   String image;

    public MenuModel(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
