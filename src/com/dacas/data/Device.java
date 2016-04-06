package com.dacas.data;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "device")
public class Device{
	@Id
	public Integer id;//id��
	@Column(name = "device_sn")
	public String deviceSn;//�豸ǩ��
	@Column(name = "public_key")
	private String publicKey;//��Կ
	@Column(name = "org_id")
	private Integer orgId;//�籨��ID
	@Column(name = "unit_id")
	private Integer unitId;//��λID
	@Column(name = "status")
	private Integer status;//�豸״̬

    //JPA������֧��Boolean���ͣ�����ͨ��Hibernate������true_false��ת��ΪBoolean����
	@Column(name = "is_phone")
    @Type(type = "true_false")
	private Boolean phoneFlag;//�Ƿ����ֻ�

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
