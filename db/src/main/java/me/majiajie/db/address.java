package me.majiajie.db;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class address{

    private String localtion;

    private String host;

    @Basic
    @Column(name = "localtion")
    public String getLocaltion() {
        return localtion;
    }


    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }


    @Basic
    @Column(name = "host")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
