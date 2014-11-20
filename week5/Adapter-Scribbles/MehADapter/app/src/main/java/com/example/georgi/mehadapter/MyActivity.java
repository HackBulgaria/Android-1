package com.example.georgi.mehadapter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity {
    private IvoAdapter baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        baseAdapter = new IvoAdapter();

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(baseAdapter);
    }

}
