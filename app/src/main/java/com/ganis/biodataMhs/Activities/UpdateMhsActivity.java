package com.ganis.biodataMhs.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ganis.biodataMhs.Database.Constant;
import com.ganis.biodataMhs.Database.MhsDatabase;
import com.ganis.biodataMhs.Model.MhsModel;
import com.ganis.biodataMhs.Model.PlugModel;
import com.ganis.biodataMhs.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateMhsActivity extends AppCompatActivity {

    @BindView(R.id.edtNamaMhs)
    EditText edtNamaMhs;
    @BindView(R.id.edtNIM)
    EditText edtNIM;
    @BindView(R.id.edtJadwal)
    EditText edtJKMhs;
    @BindView(R.id.edtAsal)
    EditText edtAsal;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.btnSimpan)
    Button btnSimpan;

    Bundle bundle;
    MhsDatabase mhsDatabase;
    int id_mhs;
    String nama_mhs, nim_mhs, jk_mhs, asal_mhs, email_mhs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mhs);
        ButterKnife.bind(this);

        Toolbar tbDetailMhs = findViewById(R.id.toolbar);
        tbDetailMhs.setTitle("Detail Data Mahasiswa");
        setSupportActionBar(tbDetailMhs);
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
        id_mhs = bundle.getInt(Constant.KEY_ID_MHS);
        nama_mhs = bundle.getString(Constant.KEY_NAMA_MHS);
        nim_mhs = bundle.getString(Constant.KEY_NIM_MHS);
        jk_mhs = bundle.getString(Constant.KEY_JK_MHS);
        asal_mhs = bundle.getString(Constant.KEY_ALAMAT_MHS);
        email_mhs = bundle.getString(Constant.KEY_EMAIL_MHS);

        // Menampilkan ke layar
        edtNamaMhs.setText(nama_mhs);
        edtNIM.setText(nim_mhs);
        edtJKMhs.setText(jk_mhs);
        edtAsal.setText(asal_mhs);
        edtEmail.setText(email_mhs);
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
        nama_mhs = edtNamaMhs.getText().toString();
        nim_mhs = edtNIM.getText().toString();
        jk_mhs = edtJKMhs.getText().toString();
        asal_mhs = edtAsal.getText().toString();
        email_mhs = edtEmail.getText().toString();
    }

    private void saveData() {

        // Membuat object kelasmodel
        MhsModel mhsModel = new MhsModel();

        // Memasukkan data ke kelasmodel
        mhsModel.setId_mhs(id_mhs);
        mhsModel.setNama_siswa(nama_mhs);
        mhsModel.setUmur(nim_mhs);
        mhsModel.setJenis_kelamin(jk_mhs);
        mhsModel.setAsal(asal_mhs);
        mhsModel.setEmail(email_mhs);

        // Melakukan operasi update untuk mengupdate data ke sqlite
        mhsDatabase.plugDao().updateSiswa(mhsModel);
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
