package com.dacas.dao;

import com.dacas.data.Device;

/**
 * Created by dave on 2016/4/6.
 */
public interface DeviceDao {
    public Device getDeviceById(int id);
    public void addDevice(Device device);
    public void updateDevice(Device device);
    public void deleteDevice(Device device);
}
