package com.example.snapgroup7.freg;

public class Flowers  {

    private String name;
    private String best_season;
    private String image_link;

    public Flowers(String name, String best_season, String image_link) {
        this.name = name;
        this.best_season = best_season;
        this.image_link = image_link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBest_season(String best_season) {
        this.best_season = best_season;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getName() {

        return name;
    }

    public String getBest_season() {
        return best_season;
    }

    public String getImage_link() {
        return image_link;
    }
}
