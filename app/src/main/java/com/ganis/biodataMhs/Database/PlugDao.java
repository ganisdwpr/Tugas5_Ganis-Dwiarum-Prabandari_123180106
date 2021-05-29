package com.ganis.biodataMhs.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ganis.biodataMhs.Model.MhsModel;
import com.ganis.biodataMhs.Model.PlugModel;

import java.util.List;

@Dao
public interface PlugDao {

    // Mengambil data
    @Query("SELECT * FROM plug ORDER BY nama_plug ASC")
    List<PlugModel> select();

    // Memasukkan data
    @Insert
    void insert(PlugModel plugModel);

    // Menghapus data
    @Delete
    void delete(PlugModel plugModel);

    // Mengupdate data
    @Update
    void update(PlugModel plugModel);

    // Mengambil data siswa
    @Query("SELECT * FROM tb_siswa WHERE id_plug = :id_kelas ORDER BY nama_siswa ASC")
    List<MhsModel> selectSiswa(int id_kelas);

    // Memasukkan data siswa
    @Insert
    void insertSiswa(MhsModel mhsModel);

    // Menghapus data siswa
    @Delete
    void deleteSiswa(MhsModel mhsModel);

    // Mengupdate data
    @Update
    void updateSiswa(MhsModel mhsModel);
}
