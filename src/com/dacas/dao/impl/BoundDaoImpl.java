package com.dacas.dao.impl;

import com.dacas.dao.BoundDao;
import com.dacas.data.Bound;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dave on 2016/4/5.
 */
@Repository
@Transactional
public class BoundDaoImpl implements BoundDao {
    private static final String RECENT_BOUND = "select b from Bound b";
    @PersistenceContext
    private EntityManager em;
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
        em.persist(bound);
    }

    @Override
    public void deleteBound(Bound bound) {
        em.remove(bound);
    }

    @Override
    public void updateBound(Bound bound) {
        em.merge(bound);
    }
}
