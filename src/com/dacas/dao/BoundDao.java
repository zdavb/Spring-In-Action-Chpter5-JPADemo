package com.dacas.dao;

import com.dacas.data.Bound;

/**
 * Created by dave on 2016/4/5.
 */
public interface BoundDao {
    public Bound getBound(int id);
    public void saveBound(Bound bound);
    public void deleteBound(Bound bound);
    public void updateBound(Bound bound);
}
