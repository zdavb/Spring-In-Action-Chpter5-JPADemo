package com.dacas.dao.impl;

import com.dacas.dao.DeviceDao;
import com.dacas.data.Device;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dave on 2016/4/6.
 */
@Repository
@Transactional
public class DeviceDaoImpl implements DeviceDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public Device getDeviceById(int id) {
        return em.find(Device.class,id);
    }

    @Override
    public void addDevice(Device device) {
        em.persist(device);
    }

    @Override
    public void updateDevice(Device device) {
        em.merge(device);
    }

    @Override
    public void deleteDevice(Device device) {
        Device device1 = em.merge(device);
        em.remove(device1);
    }
}
