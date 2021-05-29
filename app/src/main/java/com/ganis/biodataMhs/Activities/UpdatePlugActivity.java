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
import com.ganis.biodataMhs.Database.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdatePlugActivity extends AppCompatActivity {

    @BindView(R.id.edtNamaPlug)
    EditText edtNamaKelas;
    @BindView(R.id.edtNamaAslab)
    EditText edtNamaWali;
    @BindView(R.id.edtJumlahMhs)
    EditText edtJumlahSiswa;
    @BindView(R.id.edtJadwal)
    EditText edtJadwal;
    @BindView(R.id.btnSimpan)
    Button btnSimpan;

    Bundle bundle;
    MhsDatabase mhsDatabase;
    int id_kelas;
    String nama_kelas, nama_wali, jumlah_siswa, jadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_plug);
        ButterKnife.bind(this);

        Toolbar tbDetailPlug = findViewById(R.id.toolbar);
        tbDetailPlug.setTitle("Update Data");
        setSupportActionBar(tbDetailPlug);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Menangkap data dari activity sebelumnya
        bundle = getIntent().getExtras();

        // Buat object database
        mhsDatabase = MhsDatabase.createDatabase(this);

        // Menampilkan data sebelumnya ke layar
        showData();
    }

    private void showData() {
        // mengambil data di dalam bundle
        id_kelas = bundle.getInt(Constant.KEY_ID_PLUG);
        nama_kelas = bundle.getString(Constant.KEY_NAMA_PLUG);
        nama_wali = bundle.getString(Constant.KEY_NAMA_ASLAB);
        jumlah_siswa = bundle.getString(Constant.KEY_JUMLAH_SISWA);
        jadwal = bundle.getString(Constant.KEY_JADWAL);

        // Menampilkan ke layar
        edtNamaKelas.setText(nama_kelas);
        edtNamaWali.setText(nama_wali);
        edtJumlahSiswa.setText(jumlah_siswa);
        edtJadwal.setText(jadwal);
    }

    @OnClick(R.id.btnSimpan)
    public void onViewClicked() {

        // Mengambil data
        getData();

        // Mengirim data ke sqlite
        saveData();

        Toast.makeText(this, "Data plug berhasil di update!", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void getData() {
        // Mengambil inputan user dan dimasukkan ke dalam variable
        nama_kelas = edtNamaKelas.getText().toString();
        nama_wali = edtNamaWali.getText().toString();
        jumlah_siswa = edtJumlahSiswa.getText().toString();
        jadwal = edtJadwal.getText().toString();
    }

    private void saveData() {

        // Membuat object kelasmodel
        PlugModel plugModel = new PlugModel();

        // Memasukkan data ke kelasmodel
        plugModel.setId_plug(id_kelas);
        plugModel.setNama_plug(nama_kelas);
        plugModel.setNama_aslab(nama_wali);
        plugModel.setJumlah_siswa(jumlah_siswa);
        plugModel.setJadwal(jadwal);

        // Melakukan operasi update untuk mengupdate data ke sqlite
        mhsDatabase.plugDao().update(plugModel);
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
