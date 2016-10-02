package com.example.patmi.guiceorm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.patmi.guiceorm.adapter.SampleAdapter;
import com.example.patmi.guiceorm.config.SqliteHelper;
import com.example.patmi.guiceorm.dao.DaoManager;
import com.example.patmi.guiceorm.dao.SampleDao;
import com.example.patmi.guiceorm.models.SampleEntity;
import com.google.inject.Inject;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

    @InjectView(R.id.input)
    EditText input;

    @InjectView(R.id.save_button)
    Button saveButton;

    @InjectView(R.id.list_item)
    ListView listView;

    @Inject
    SampleDao sampleDao;

    List<SampleEntity> samples = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        input.setSelected(false);
        try {
            OpenHelperManager.getHelper(this, SqliteHelper.class);
            samples = sampleDao.findAll();
            SampleAdapter adapter = new SampleAdapter(this, samples, sampleDao);
            listView.setAdapter(adapter);

            saveButton.setOnClickListener(listener);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                String text = input.getText().toString();
                sampleDao.create(new SampleEntity(text));
                startActivity(new Intent(MainActivity.this,MainActivity.class));
                finish();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    };
}
