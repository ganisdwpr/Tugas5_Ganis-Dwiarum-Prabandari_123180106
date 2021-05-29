package com.ganis.biodataMhs.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.ganis.biodataMhs.Database.Constant;

@Entity(tableName = Constant.nama_plug)

public class PlugModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constant.id_plug)
    private int id_plug;

    @ColumnInfo(name = Constant.nama_kelas)
    private String nama_plug;

    @ColumnInfo(name = Constant.nama_aslab)
    private String nama_aslab;

    @ColumnInfo(name = Constant.jumlah_siswa)
    private String jumlah_siswa;

    @ColumnInfo(name = Constant.jadwal)
    private String jadwal;

    public int getId_plug() {
        return id_plug;
    }

    public void setId_plug(int id_plug) {
        this.id_plug = id_plug;
    }

    public String getNama_plug() {
        return nama_plug;
    }

    public void setNama_plug(String nama_plug) {
        this.nama_plug = nama_plug;
    }

    public String getNama_aslab() {
        return nama_aslab;
    }

    public void setNama_aslab(String nama_aslab) {
        this.nama_aslab = nama_aslab;
    }

    public String getJumlah_siswa() {
        return jumlah_siswa;
    }

    public void setJumlah_siswa(String jumlah_siswa) {
        this.jumlah_siswa = jumlah_siswa;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

}
