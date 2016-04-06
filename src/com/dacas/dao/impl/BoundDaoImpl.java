package com.dacas.dao.impl;

import com.dacas.dao.BoundDao;
import com.dacas.data.Bound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dave on 2016/4/5.
 */
//编码式事务管理
@Repository
public class BoundDaoImpl implements BoundDao {
    private static final String RECENT_BOUND = "select b from Bound b";
    @PersistenceContext
    private EntityManager em;

    @Autowired
    TransactionTemplate txTemplate;

    @Override
    public Bound getBound(int id) {
        return em.find(Bound.class,id);
    }

    /***
     * 下面三个方法需要事务管理
     * @param bound
     */
    @Override
    public void saveBound(Bound bound) {
        txTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    em.persist(bound);
                }catch (RuntimeException ex){
                    transactionStatus.setRollbackOnly();
                    throw ex;
                }
                return null;
            }
        });

    }

    @Override
    public void deleteBound(Bound bound) {
        txTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    Bound mergedBound = em.merge(bound);//必须先merge，然后再remove，merge表示将已经detach的对象重新复原
                    em.remove(mergedBound);
                }catch (RuntimeException ex){
                    transactionStatus.setRollbackOnly();
                    throw ex;
                }
                return null;
            }
        });
    }

    @Override
    public void updateBound(Bound bound) {
        txTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    em.merge(bound);
                } catch (RuntimeException ex) {
                    transactionStatus.setRollbackOnly();
                    throw ex;
                }
                return null;
            }
        });
    }
}
