package com.ganis.biodataMhs.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.ganis.biodataMhs.Database.Constant;

@Entity(tableName = "tb_siswa")

public class MhsModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_siswa")
    private int id_mhs;

    @ColumnInfo(name = Constant.id_plug)
    private int id_plug;

    @ColumnInfo(name = "nama_siswa")
    private String nama_siswa;

    @ColumnInfo(name = "umur")
    private String umur;

    @ColumnInfo(name = "jenis_kelamin")
    private String jenis_kelamin;

    @ColumnInfo(name = "asal")
    private String asal;

    @ColumnInfo(name = "email")
    private String email;

    public int getId_mhs() {
        return id_mhs;
    }

    public void setId_mhs(int id_mhs) {
        this.id_mhs = id_mhs;
    }

    public int getId_plug() {
        return id_plug;
    }

    public void setId_plug(int id_plug) {
        this.id_plug = id_plug;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) { this.umur = this.umur; }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
