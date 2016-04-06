package com.dacas;

import com.dacas.dao.BoundDao;
import com.dacas.dao.CardDao;
import com.dacas.dao.DeviceDao;
import com.dacas.data.Bound;
import com.dacas.data.Card;
import com.dacas.data.Device;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by dave on 2016/4/5.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        performDevice(context);
    }
    //使用编码方式进行事务管理
    private static void performBound(ApplicationContext context){
        BoundDao boundDao = context.getBean(BoundDao.class);
        //select
        Bound bound = boundDao.getBound(8);
        System.out.println(bound.toString());

        //create new
        Bound newBound = new Bound();
        newBound.setId(9);
        newBound.setPersonId(9);
        newBound.setBoundTime(new Date());
        newBound.setDeviceId(9);
        newBound.setStatus(1);
        boundDao.saveBound(newBound);

        //update Bound
        newBound.setPersonId(99);
        boundDao.updateBound(newBound);
        //delete Bound
        boundDao.deleteBound(bound);
    }
    /***************XML声明式配置事务管理*******************/
    private static void performCard(ApplicationContext context){
        CardDao cardDao = context.getBean(CardDao.class);

        Card card = cardDao.getCardById(1);
        System.out.println(card);

        Card newCard = new Card();
        newCard.setId(1);
        newCard.setColor(10);
        newCard.setCardSn("asdasfdafas");
        newCard.setPublicKey("sdjkasdjfkasdfjl");
        newCard.setStatus(1);

        cardDao.addCard(newCard);
        card.setPublicKey("12345566778");
        cardDao.updateCard(card);
        cardDao.deleteCard(card);
    }
    /*****************XML+注解方式配置事务管理************************/
    private static void performDevice(ApplicationContext context){
        DeviceDao deviceDao = context.getBean(DeviceDao.class);

        //select
        Device device = deviceDao.getDeviceById(2);
        System.out.println(device);
        //add
//        Device newDevice = new Device();
//        newDevice.setId(2);
//        newDevice.setDeviceSn("1221124545");
//        newDevice.setStatus(1);
//        newDevice.setPublicKey("sdasdfasdfassdas");
//        newDevice.setOrgId(30);
//        newDevice.setUnitId(58);
//        newDevice.setPhoneFlag(true);
//        deviceDao.addDevice(newDevice);

        //update
//        device.setDeviceSn("1234567890");
//        deviceDao.updateDevice(device);

        //delete
        deviceDao.deleteDevice(device);

    }
}
