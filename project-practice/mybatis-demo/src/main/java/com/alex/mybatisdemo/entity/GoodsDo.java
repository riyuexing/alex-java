package com.alex.mybatisdemo.entity;

import java.util.Date;

/**
 * @author alex
 * @version 1.0
 * @description: 商品类
 * @date 2023/1/21 9:13
 */
public class GoodsDo {
    private Long id;
    private String name;
    private String price;
    private String pic;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


}
