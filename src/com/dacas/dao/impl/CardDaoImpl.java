package com.dacas.dao.impl;

import com.dacas.dao.CardDao;
import com.dacas.data.Card;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dave on 2016/4/6.
 */
//XML配置文件进行声明式事务管理
@Repository
public class CardDaoImpl implements CardDao {
    @PersistenceContext
    EntityManager em;
    @Override
    public Card getCardById(int id) {
        return em.find(Card.class,id);
    }

    @Override
    public void addCard(Card card) {
        em.persist(card);
    }

    @Override
    public void updateCard(Card card) {
        em.merge(card);
    }

    @Override
    public void deleteCard(Card card) {
        Card newCard = em.merge(card);
        em.remove(newCard);
    }
}
