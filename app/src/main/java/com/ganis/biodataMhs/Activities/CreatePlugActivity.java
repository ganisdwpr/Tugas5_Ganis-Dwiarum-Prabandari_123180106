package com.ganis.biodataMhs.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ganis.biodataMhs.Database.MhsDatabase;
import com.ganis.biodataMhs.Model.PlugModel;
import com.ganis.biodataMhs.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreatePlugActivity extends AppCompatActivity {

    @BindView(R.id.edtNamaPlug)
    EditText edtNamaKelas;
    @BindView(R.id.edtNamaAslab)
    EditText edtNamaWali;
    @BindView(R.id.edtJumlahMhs)
    EditText edtJumlahMhs;
    @BindView(R.id.edtJadwal)
    EditText edtJadwal;
    @BindView(R.id.btnSimpan)
    Button btnSimpan;

    MhsDatabase mhsDatabase;
    String namaKelas, namaWali, jumlahSiswa, jadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plug);
        ButterKnife.bind(this);

        Toolbar tbDetailPlug = findViewById(R.id.toolbar);
        tbDetailPlug.setTitle("Input Plug");
        setSupportActionBar(tbDetailPlug);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mhsDatabase = MhsDatabase.createDatabase(this);
    }

    @OnClick(R.id.btnSimpan)
    public void onViewClicked() {

        getData();

        saveData();

        clearData();

        Toast.makeText(this, "Plug berhasil disimpan!", Toast.LENGTH_SHORT).show();

        finish();
    }

    private void clearData() {
        edtNamaKelas.setText("");
        edtNamaWali.setText("");
        edtJumlahMhs.setText("");
        edtJadwal.setText("");
    }

    private void saveData() {

        // Membuat object PlugModel untuk menampung data
        PlugModel plugModel = new PlugModel();

        // Memasukkan data ke dalam PlugModel
        plugModel.setNama_plug(namaKelas);
        plugModel.setNama_aslab(namaWali);
        plugModel.setJumlah_siswa(jumlahSiswa);
        plugModel.setJadwal(jadwal);

        // Perintah untuk melakukan operasi Insert menggunakan mhsDatabase
        mhsDatabase.plugDao().insert(plugModel);
    }

    private void getData() {
        namaKelas = edtNamaKelas.getText().toString();
        namaWali = edtNamaWali.getText().toString();
        jumlahSiswa = edtJumlahMhs.getText().toString();
        jadwal = edtJadwal.getText().toString();
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
