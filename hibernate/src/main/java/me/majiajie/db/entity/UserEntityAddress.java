package me.majiajie.db.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class UserEntityAddress {

    private String localtion;

    private int postcode;

    @Basic
    @Column(name = "localtion")
    public String getLocaltion() {
        return localtion;
    }


    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }


    @Basic
    @Column(name = "postcode")
    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
