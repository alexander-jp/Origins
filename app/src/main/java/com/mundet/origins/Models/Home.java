package com.mundet.origins.Models;

public class Home {
    String movie_name;
    String movie_url;
    String url_img;

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_url() {
        return movie_url;
    }

    public void setMovie_url(String movie_url) {
        this.movie_url = movie_url;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    @Override
    public String toString() {
        return "Home{" +
                "movie_name='" + movie_name + '\'' +
                ", movie_url='" + movie_url + '\'' +
                ", url_img='" + url_img + '\'' +
                '}';
    }
}
