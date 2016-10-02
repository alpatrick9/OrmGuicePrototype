package com.example.patmi.guiceorm.dao;

import android.content.Context;

import com.example.patmi.guiceorm.config.SqliteHelper;
import com.example.patmi.guiceorm.models.SampleEntity;
import com.google.inject.Inject;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by patmi on 02/10/2016.
 */
public class DaoManager {
    Context context;

    SqliteHelper sqliteHelper;

    Dao<SampleEntity, Long> sampleDao;

    @Inject
    public DaoManager(Context context) {
        this.context = context;
        sqliteHelper = OpenHelperManager.getHelper(context, SqliteHelper.class);
    }

    public Dao<SampleEntity,Long> getSampleDao() throws SQLException{
        if(sampleDao == null)
            sampleDao = sqliteHelper.getDao(SampleEntity.class);
        return sampleDao;
    }
}
