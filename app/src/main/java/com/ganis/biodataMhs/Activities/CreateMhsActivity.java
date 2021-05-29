package com.ganis.biodataMhs.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ganis.biodataMhs.Database.MhsDatabase;
import com.ganis.biodataMhs.Model.MhsModel;
import com.ganis.biodataMhs.R;
import com.ganis.biodataMhs.Database.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateMhsActivity extends AppCompatActivity {

    @BindView(R.id.edtNamaMhs)
    EditText edtNamaMahasiswa;
    @BindView(R.id.edtNIM)
    EditText edtNIM;
    @BindView(R.id.radio_laki)
    RadioButton radioLaki;
    @BindView(R.id.radio_perempuan)
    RadioButton radioPerempuan;
    @BindView(R.id.edtAsal)
    EditText edtAsal;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.btnSimpan)
    Button btnSimpan;
    @BindView(R.id.radio_jenis_kelamin)
    RadioGroup radioJenisKelaminGroup;

    MhsDatabase mhsDatabase;
    int id_plug;
    String namaMahasiswa, asal, nim, jenis_kelamin, email;
    boolean empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mhs);
        ButterKnife.bind(this);

        Toolbar tbDetailMhs = findViewById(R.id.toolbar);
        tbDetailMhs.setTitle("Input Mahasiswa");
        setSupportActionBar(tbDetailMhs);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        id_plug = getIntent().getIntExtra(Constant.KEY_ID_PLUG, 0);

        mhsDatabase = MhsDatabase.createDatabase(this);
    }

    @OnClick(R.id.btnSimpan)
    public void onViewClicked() {

        // Memastikan semuanya terisi
        cekData();

        if (!empty) {
            saveData();
            clearData();
            Toast.makeText(this, "Data Mahasiswa Berhasil disimpan!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Data tidak boleh kosong, harus terisi semua!", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearData() {
        edtNamaMahasiswa.setText("");
        edtNIM.setText("");
        edtAsal.setText("");
        edtEmail.setText("");
        radioJenisKelaminGroup.clearCheck();
    }

    private void saveData() {

        // Membuat penampung dengan membaut object MhsModel
        MhsModel mhsModel = new MhsModel();

        // kita masukkan data ke dalam mhsModel
        mhsModel.setId_plug(id_plug);
        mhsModel.setNama_siswa(namaMahasiswa);
        mhsModel.setAsal(asal);
        mhsModel.setUmur(nim);
        mhsModel.setJenis_kelamin(jenis_kelamin);
        mhsModel.setEmail(email);

        // Kita lakukan operasi insert
        mhsDatabase.plugDao().insertSiswa(mhsModel);
    }

    private void cekData() {
        namaMahasiswa = edtNamaMahasiswa.getText().toString();
        asal = edtAsal.getText().toString();
        nim = edtNIM.getText().toString();
        email = edtEmail.getText().toString();

        empty = namaMahasiswa.isEmpty() || asal.isEmpty() || nim.isEmpty() || email.isEmpty() || jenis_kelamin.isEmpty();
    }

    @OnClick({R.id.radio_laki, R.id.radio_perempuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_laki:
                jenis_kelamin = radioLaki.getText().toString();
                break;
            case R.id.radio_perempuan:
                jenis_kelamin = radioPerempuan.getText().toString();
                break;
        }
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
