package com.dacas;

import com.dacas.dao.BoundDao;
import com.dacas.data.Bound;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by dave on 2016/4/5.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BoundDao boundDao = context.getBean(BoundDao.class);
        //select
        Bound bound = boundDao.getBound(9);
        System.out.println(bound.toString());

//        //create new
//        Bound newBound = new Bound();
//        newBound.setId(9);
//        newBound.setPersonId(9);
//        newBound.setBoundTime(new Date());
//        newBound.setDeviceId(9);
//        newBound.setStatus(1);
//        boundDao.saveBound(newBound);
//
//        //update Bound
//        newBound.setPersonId(99);
//        boundDao.updateBound(newBound);
//        delete Bound
        boundDao.deleteBound(bound);
    }
}
