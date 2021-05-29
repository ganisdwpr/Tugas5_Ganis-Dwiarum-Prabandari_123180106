package com.ganis.biodataMhs.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ganis.biodataMhs.Adapter.MhsAdapter;
import com.ganis.biodataMhs.Database.MhsDatabase;
import com.ganis.biodataMhs.Model.MhsModel;
import com.ganis.biodataMhs.R;
import com.ganis.biodataMhs.Database.Constant;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListMhsActivity extends AppCompatActivity {

    @BindView(R.id.rvMhs)
    RecyclerView rvMhs;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    MhsDatabase mhsDatabase;
    List<MhsModel> mhsModelList;
    int id_plug;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mhs);

        ButterKnife.bind(this);

        Toolbar tbDetailMhs = findViewById(R.id.toolbar);
        tbDetailMhs.setTitle("List Mahasiswa");
        setSupportActionBar(tbDetailMhs);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bundle = getIntent().getExtras();

        if (bundle != null) {
            id_plug = bundle.getInt(Constant.KEY_ID_PLUG);
        }

        mhsDatabase = MhsDatabase.createDatabase(this);

        mhsModelList = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mhsModelList.clear();

        getData();

        rvMhs.setLayoutManager(new LinearLayoutManager(this));
        rvMhs.setAdapter(new MhsAdapter(this, mhsModelList));
    }

    private void getData() {
        mhsModelList = mhsDatabase.plugDao().selectSiswa(id_plug);
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        startActivity(new Intent(this, CreateMhsActivity.class).putExtra(Constant.KEY_ID_PLUG, id_plug));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
