package com.example.patmi.guiceorm.dao;

import com.example.patmi.guiceorm.models.SampleEntity;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by patmi on 02/10/2016.
 */
public class SampleDao extends AbstractDao<SampleEntity, Long> {

    @Inject
    public SampleDao(DaoManager daoManager) {
        try {
            this.dao = daoManager.getSampleDao();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
