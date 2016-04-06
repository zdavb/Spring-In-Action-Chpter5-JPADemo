package com.dacas.dao;

import com.dacas.data.Card;

/**
 * Created by dave on 2016/4/6.
 */
public interface CardDao {
    public Card getCardById(int id);
    public void addCard(Card card);
    public void updateCard(Card card);
    public void deleteCard(Card card);
}
