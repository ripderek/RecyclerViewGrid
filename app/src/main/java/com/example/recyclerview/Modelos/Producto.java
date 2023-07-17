package com.example.recyclerview.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Producto {
    private String id;
    private String title;
    private String description;
    private String price;
    private String discount;
    private String rating;
    private String stock;
    private String brand;
    private String category;
    private String thumbail;
    private String [] imagenes;

    public Producto(JSONObject a)throws JSONException {
    this.id=a.getString("id").toString();
    this.title=a.getString("title").toString();
    this.description=a.getString("description").toString();
    this.price="$ "+ a.getString("price").toString() +".00";
    this.discount=a.getString("discountPercentage").toString();
    this.rating ="Rating: "+a.getString("rating").toString();
    this.stock=a.getString("stock").toString();
    this.brand=a.getString("brand").toString();
    this.category=a.getString("category").toString();
    this.thumbail=a.getString("thumbnail").toString();

        //obtener el jsonarray que contiene las url de las imagenes
        JSONArray detalle_imagenes = a.getJSONArray("images");
        this.imagenes = new String [detalle_imagenes.length()];

        //recorrer el vector de string para guardar las url de las imagenes
        for (int i =0; i<detalle_imagenes.length();i++)
            this.imagenes[i]=detalle_imagenes.get(i).toString();
    }
    public static ArrayList<Producto> JsonObjectsBuild(JSONArray datos) throws JSONException {
    ArrayList<Producto> productos = new ArrayList<>();
    for (int i = 0; i<datos.length();i++)
        productos.add(new Producto(datos.getJSONObject(i)));
    return productos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price ="$ "+ price + ".00";
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThumbail() {
        return thumbail;
    }

    public void setThumbail(String thumbail) {
        this.thumbail = thumbail;
    }

    public String[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(String[] imagenes) {
        this.imagenes = imagenes;
    }
    public String toString() {
        return title + " " + description;
    }
}
