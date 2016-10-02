package com.example.patmi.guiceorm.dao;

import com.example.patmi.guiceorm.models.SampleEntity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by patmi on 02/10/2016.
 */
public abstract class AbstractDao<E,K>  {
    Dao<E,K> dao;

    public List<E> findAll() throws SQLException {
        return dao.queryForAll();
    }

    public Integer create(E s) throws SQLException {
        return dao.create(s);
    }

    public Integer delete(E s) throws SQLException {
        return dao.delete(s);
    }

    public Integer update(E s) throws SQLException {
        return dao.update(s);
    }
}
