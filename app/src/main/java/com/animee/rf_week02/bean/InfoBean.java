package com.animee.rf_week02.bean;
/*  表示每一个用品对象*/
public class InfoBean {
    private String pic;   //图片地址
    private String title;   //标题
    private String kind;    //种类
    private int count;     //库存
    private double price;   //价格
    private int buycount = 0;  //购买数量

    public InfoBean() {}
    public InfoBean(String pic, String title, String kind, int count, double price, int buycount) {
        this.pic = pic;
        this.title = title;
        this.kind = kind;
        this.count = count;
        this.price = price;
        this.buycount = buycount;
    }
    public int getBuycount() {
        return buycount;
    }
    public void setBuycount(int buycount) {
        this.buycount = buycount;
    }
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public InfoBean(String pic, String title, String kind, int count, double price) {
        this.pic = pic;
        this.title = title;
        this.kind = kind;
        this.count = count;
        this.price = price;
    }

    public static InfoBean copy(InfoBean oldBean){
        return new InfoBean(oldBean.getPic(),oldBean.getTitle(),oldBean.getKind(),
                oldBean.getCount(),oldBean.getPrice());
    }
}
