package com.dacas.data;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "bound")
public class Bound {
    @Id
    private Integer id;
    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "device_id")
    private Integer deviceId;
    @Column(name = "bound_time")
    private Date boundTime;
    @Column(name = "status")
    private Integer status;//1有效、0无效

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPersonId() {
        return personId;
    }
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    public Integer getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
    public Date getBoundTime() {
        return boundTime;
    }
    public void setBoundTime(Date boundTime) {
        this.boundTime = boundTime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString(){
        return "id:"+id+",personId:"+personId+",deviceId:"+deviceId;
    }
}
