package com.animee.rf_week02.db;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用户地址
 */
public class AddressDao implements Serializable {

    private int id;
    private String name;
    private String tel;
    private String city;
    private String street;
    private Boolean isDefault;
    private Boolean isTop;

    public AddressDao() {
    }

    public AddressDao(int id, String name, String tel, String city, String street) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.city = city;
        this.street = street;
    }

    public AddressDao(int id, String name, String tel, String city, String street, Boolean isDefault, Boolean isTop) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.city = city;
        this.street = street;
        this.isDefault = isDefault;
        this.isTop = isTop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDao dao = (AddressDao) o;
        return Objects.equals(name, dao.name) && Objects.equals(tel, dao.tel) && Objects.equals(city, dao.city) && Objects.equals(street, dao.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tel, city, street);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public boolean isDefault() {
        if (isDefault == null) {
            return false;
        }
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public void clone(AddressDao dao) {
        this.setName(dao.getName());
        this.setCity(dao.getCity());
        this.setTel(dao.getTel());
        this.setStreet(dao.getStreet());
        this.setId(dao.getId());
    }

    @Override
    public String toString() {
        return "姓名:" + name +
                ", 电话:" + tel +
                ", 地址:" + city + street;
    }


}
