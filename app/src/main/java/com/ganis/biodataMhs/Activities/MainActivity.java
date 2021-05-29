package com.ganis.biodataMhs.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ganis.biodataMhs.Adapter.PlugAdapter;
import com.ganis.biodataMhs.Database.MhsDatabase;
import com.ganis.biodataMhs.Model.PlugModel;
import com.ganis.biodataMhs.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvPlug)
    RecyclerView rvPlug;

    private MhsDatabase mhsDatabase;
    private List<PlugModel> plugModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Membuat object database
        mhsDatabase = MhsDatabase.createDatabase(this);

        // Membuat membuat object List
        plugModelList = new ArrayList<>();

        ExtendedFloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreatePlugActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Mengosongkan List agar dipastikan list dapat disi dengan data yg paling baru
        plugModelList.clear();

        // Mengambil data dari Sqlite
        getData();

        // Mensetting dan proses menampilkan data ke RecyclerView
        rvPlug.setLayoutManager(new GridLayoutManager(this, 2));
        rvPlug.setAdapter(new PlugAdapter(this, plugModelList));
    }

    private void getData() {

        // Operasi mengambil data dari database Sqlite
        plugModelList = mhsDatabase.plugDao().select();
    }

}
