package com.example.patmi.guiceorm.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.patmi.guiceorm.models.SampleEntity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by patmi on 01/10/2016.
 */
public class SqliteHelper extends OrmLiteSqliteOpenHelper {
    protected static final String DATABASE_NAME = "sample";
    protected static final int DATABASE_VERSION = 1;

    //protected Dao<SampleEntity, Long> sampleDao;

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {

            /**
             * creates the SampleEntity database table
             */
            TableUtils.createTable(connectionSource, SampleEntity.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            /**
             * Recreates the database when onUpgrade is called by the framework
             */
            TableUtils.dropTable(connectionSource, SampleEntity.class, false);
            onCreate(database, connectionSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public Dao<SampleEntity, Long> getSampleDao() throws SQLException {
        if(sampleDao == null)
            sampleDao = getDao(SampleEntity.class);
        return sampleDao;
    }*/
}
