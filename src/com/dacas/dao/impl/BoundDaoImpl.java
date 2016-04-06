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
//����ʽ�������
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
     * ��������������Ҫ�������
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
                    Bound mergedBound = em.merge(bound);//������merge��Ȼ����remove��merge��ʾ���Ѿ�detach�Ķ������¸�ԭ
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
