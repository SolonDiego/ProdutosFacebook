package br.com.solondiego.model;

import java.text.DecimalFormat;

/**
 *
 * @author Solon Diego
 */
public class Produtos {

    private Object id;
    private Object title;
    private Object description;
    private Object availability;
    private Object inventory;
    private Object condition;
    private String price;
    private Object link;
    private Object image_link;
    private Object brand;
    private Object google_product_category;
    private Object sale_price;
    private Object sale_price_effective_date;
    private Object item_group_id;
    private Object gender;
    private Object color;
    private Object size;
    private Object age_group;
    private Object material;
    private Object pattern;
    private Object product_type;
    private Object shipping;
    private Object shipping_weight;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        String descricao = (String) description;
        String[] decomposicao = descricao.split("<br />  <br />\\s");
        this.description = decomposicao[0].replace("<br />", "");
    }

    public Object getAvailability() {
        return availability;
    }

    public void setAvailability(Object availability) {
        this.availability = availability;
    }

    public Object getInventory() {
        return inventory;
    }

    public void setInventory(Object inventory) {
        this.inventory = inventory;
    }

    public Object getCondition() {
        return condition;
    }

    public void setCondition(Object condition) {
        this.condition = condition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(double price) {
        DecimalFormat df = new DecimalFormat("0,00 BRL");
        String dx = df.format(price);
        this.price = dx;
    }

    public Object getLink() {
        return link;
    }

    public void setLink(Object link) {
        this.link = link;
    }

    public Object getImage_link() {
        return image_link;
    }

    public void setImage_link(Object image_link) {
        this.image_link = image_link;
    }

    public Object getBrand() {
        return brand;
    }

    public void setBrand(Object brand) {
        this.brand = brand;
    }

    public Object getGoogle_product_category() {
        return google_product_category;
    }

    public void setGoogle_product_category(Object google_product_category) {
        this.google_product_category = google_product_category;
    }

    public Object getSale_price() {
        return sale_price;
    }

    public void setSale_price(Object sale_price) {
        this.sale_price = sale_price;
    }

    public Object getSale_price_effective_date() {
        return sale_price_effective_date;
    }

    public void setSale_price_effective_date(Object sale_price_effective_date) {
        this.sale_price_effective_date = sale_price_effective_date;
    }

    public Object getItem_group_id() {
        return item_group_id;
    }

    public void setItem_group_id(Object item_group_id) {
        this.item_group_id = item_group_id;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public Object getAge_group() {
        return age_group;
    }

    public void setAge_group(Object age_group) {
        this.age_group = age_group;
    }

    public Object getMaterial() {
        return material;
    }

    public void setMaterial(Object material) {
        this.material = material;
    }

    public Object getPattern() {
        return pattern;
    }

    public void setPattern(Object pattern) {
        this.pattern = pattern;
    }

    public Object getProduct_type() {
        return product_type;
    }

    public void setProduct_type(Object product_type) {
        this.product_type = product_type;
    }

    public Object getShipping() {
        return shipping;
    }

    public void setShipping(Object shipping) {
        this.shipping = shipping;
    }

    public Object getShipping_weight() {
        return shipping_weight;
    }

    public void setShipping_weight(Object shipping_weight) {
        this.shipping_weight = shipping_weight;
    }

    @Override
    public String toString() {
        return getId() + ",\"" + getTitle() + "\",\"" + getDescription() + "\",\""
                + getAvailability() + "\"," + getInventory() + ",\"" + getCondition() + "\",\"" + getPrice() + "\",\""
                + getLink() + "\",\"" + getImage_link() + "\",\"" + getBrand() + "\",\"" + getGoogle_product_category() + "\",\""
                + getSale_price() + "\",\"" + getSale_price_effective_date() + "\",\"" + getItem_group_id() + "\",\"" + getGender() + "\",\""
                + getColor() + "\",\"" + getSize() + "\",\"" + getAge_group() + "\",\"" + getMaterial() + "\",\"" + getPattern() + "\",\""
                + getProduct_type() + "\",\"" + getShipping() + "\",\"" + getShipping_weight() + "\"";
    }

}
