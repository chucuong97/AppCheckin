package com.example.hungv.checkinapp.model;

public class ListMenuModel {
    String Menu;
    Integer ImageMenu;

    public ListMenuModel() {

    }

    public ListMenuModel(String menu, Integer imageMenu) {
        this.Menu = menu;
        this.ImageMenu = imageMenu;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        this.Menu = menu;
    }

    public Integer getImageMenu() {
        return ImageMenu;
    }

    public void setImageMenu(Integer imageMenu) {
        this.ImageMenu = imageMenu;
    }
}
