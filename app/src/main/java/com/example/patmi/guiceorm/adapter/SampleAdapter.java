package com.example.patmi.guiceorm.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.patmi.guiceorm.MainActivity;
import com.example.patmi.guiceorm.R;
import com.example.patmi.guiceorm.config.SqliteHelper;
import com.example.patmi.guiceorm.dao.DaoManager;
import com.example.patmi.guiceorm.dao.SampleDao;
import com.example.patmi.guiceorm.models.SampleEntity;
import com.google.inject.Inject;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by patmi on 01/10/2016.
 */
public class SampleAdapter extends BaseAdapter{

    Context context;

    SampleDao sampleDao;

    List<SampleEntity> sampleEntities;

    public SampleAdapter(Context context, List<SampleEntity> sampleEntities, SampleDao sampleDao) {
        this.context = context;
        this.sampleEntities = sampleEntities;
        this.sampleDao = sampleDao;
    }

    @Override
    public int getCount() {
        return sampleEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return sampleEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item, null);
        }
        Button buttonUpdate = (Button)convertView.findViewById(R.id.update);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView itemView = (TextView)convertView.findViewById(R.id.item);
        itemView.setText(sampleEntities.get(position).getLabel());

        Button button = (Button)convertView.findViewById(R.id.del_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sampleDao.delete(sampleEntities.get(position));
                    context.startActivity(new Intent(context,MainActivity.class));
                    ((Activity)context).finish();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        return convertView;
    }
}
