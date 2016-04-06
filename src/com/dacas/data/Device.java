package com.dacas.data;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "device")
public class Device{
	@Id
	public Integer id;//id号
	@Column(name = "device_sn")
	public String deviceSn;//设备签名
	@Column(name = "public_key")
	private String publicKey;//公钥
	@Column(name = "org_id")
	private Integer orgId;//电报所ID
	@Column(name = "unit_id")
	private Integer unitId;//单位ID
	@Column(name = "status")
	private Integer status;//设备状态

    //JPA本身并不支持Boolean类型，可以通过Hibernate的类型true_false来转换为Boolean类型
	@Column(name = "is_phone")
    @Type(type = "true_false")
	private Boolean phoneFlag;//是否是手机

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public String getDeviceSn() {
		return deviceSn;
	}
	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Boolean getPhoneFlag() {
		return phoneFlag;
	}
	public void setPhoneFlag(Boolean phoneFlag) {
		this.phoneFlag = phoneFlag;
	}

    public String toString(){
        return "id:"+id+",device_sn:"+deviceSn+",public_key:"+publicKey+",org_id:"+orgId+",unit_id:"+unitId+",is_phone:"+phoneFlag;
    }
}
