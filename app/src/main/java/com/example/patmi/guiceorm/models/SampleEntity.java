package com.example.patmi.guiceorm.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by patmi on 01/10/2016.
 */

@DatabaseTable(tableName = "sample_table")
public class SampleEntity {

    @DatabaseField(generatedId = true)
    protected Long id;

    @DatabaseField
    protected String label;

    protected Date date;

    public SampleEntity() {
        this.date = new Date();
    }

    public SampleEntity(String label) {
        this.label = label;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
