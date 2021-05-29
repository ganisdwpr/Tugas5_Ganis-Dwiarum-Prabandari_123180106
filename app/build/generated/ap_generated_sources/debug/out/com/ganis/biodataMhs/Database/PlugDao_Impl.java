package com.ganis.biodataMhs.Database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ganis.biodataMhs.Model.MhsModel;
import com.ganis.biodataMhs.Model.PlugModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class PlugDao_Impl implements PlugDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPlugModel;

  private final EntityInsertionAdapter __insertionAdapterOfMhsModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPlugModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMhsModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfPlugModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfMhsModel;

  public PlugDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPlugModel = new EntityInsertionAdapter<PlugModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `plug`(`id_plug`,`nama_plug`,`nama_aslab`,`jumlah_siswa`,`jadwal`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlugModel value) {
        stmt.bindLong(1, value.getId_plug());
        if (value.getNama_plug() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_plug());
        }
        if (value.getNama_aslab() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_aslab());
        }
        if (value.getJumlah_siswa() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getJumlah_siswa());
        }
        if (value.getJadwal() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getJadwal());
        }
      }
    };
    this.__insertionAdapterOfMhsModel = new EntityInsertionAdapter<MhsModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_siswa`(`id_siswa`,`id_plug`,`nama_siswa`,`umur`,`jenis_kelamin`,`asal`,`email`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MhsModel value) {
        stmt.bindLong(1, value.getId_mhs());
        stmt.bindLong(2, value.getId_plug());
        if (value.getNama_siswa() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_siswa());
        }
        if (value.getUmur() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUmur());
        }
        if (value.getJenis_kelamin() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getJenis_kelamin());
        }
        if (value.getAsal() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAsal());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEmail());
        }
      }
    };
    this.__deletionAdapterOfPlugModel = new EntityDeletionOrUpdateAdapter<PlugModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `plug` WHERE `id_plug` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlugModel value) {
        stmt.bindLong(1, value.getId_plug());
      }
    };
    this.__deletionAdapterOfMhsModel = new EntityDeletionOrUpdateAdapter<MhsModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tb_siswa` WHERE `id_siswa` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MhsModel value) {
        stmt.bindLong(1, value.getId_mhs());
      }
    };
    this.__updateAdapterOfPlugModel = new EntityDeletionOrUpdateAdapter<PlugModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `plug` SET `id_plug` = ?,`nama_plug` = ?,`nama_aslab` = ?,`jumlah_siswa` = ?,`jadwal` = ? WHERE `id_plug` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlugModel value) {
        stmt.bindLong(1, value.getId_plug());
        if (value.getNama_plug() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_plug());
        }
        if (value.getNama_aslab() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_aslab());
        }
        if (value.getJumlah_siswa() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getJumlah_siswa());
        }
        if (value.getJadwal() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getJadwal());
        }
        stmt.bindLong(6, value.getId_plug());
      }
    };
    this.__updateAdapterOfMhsModel = new EntityDeletionOrUpdateAdapter<MhsModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tb_siswa` SET `id_siswa` = ?,`id_plug` = ?,`nama_siswa` = ?,`umur` = ?,`jenis_kelamin` = ?,`asal` = ?,`email` = ? WHERE `id_siswa` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MhsModel value) {
        stmt.bindLong(1, value.getId_mhs());
        stmt.bindLong(2, value.getId_plug());
        if (value.getNama_siswa() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_siswa());
        }
        if (value.getUmur() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUmur());
        }
        if (value.getJenis_kelamin() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getJenis_kelamin());
        }
        if (value.getAsal() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAsal());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEmail());
        }
        stmt.bindLong(8, value.getId_mhs());
      }
    };
  }

  @Override
  public void insert(PlugModel plugModel) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPlugModel.insert(plugModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertSiswa(MhsModel mhsModel) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMhsModel.insert(mhsModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(PlugModel plugModel) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPlugModel.handle(plugModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSiswa(MhsModel mhsModel) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfMhsModel.handle(mhsModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(PlugModel plugModel) {
    __db.beginTransaction();
    try {
      __updateAdapterOfPlugModel.handle(plugModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSiswa(MhsModel mhsModel) {
    __db.beginTransaction();
    try {
      __updateAdapterOfMhsModel.handle(mhsModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PlugModel> select() {
    final String _sql = "SELECT * FROM plug ORDER BY nama_plug ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdPlug = _cursor.getColumnIndexOrThrow("id_plug");
      final int _cursorIndexOfNamaPlug = _cursor.getColumnIndexOrThrow("nama_plug");
      final int _cursorIndexOfNamaAslab = _cursor.getColumnIndexOrThrow("nama_aslab");
      final int _cursorIndexOfJumlahSiswa = _cursor.getColumnIndexOrThrow("jumlah_siswa");
      final int _cursorIndexOfJadwal = _cursor.getColumnIndexOrThrow("jadwal");
      final List<PlugModel> _result = new ArrayList<PlugModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PlugModel _item;
        _item = new PlugModel();
        final int _tmpId_plug;
        _tmpId_plug = _cursor.getInt(_cursorIndexOfIdPlug);
        _item.setId_plug(_tmpId_plug);
        final String _tmpNama_plug;
        _tmpNama_plug = _cursor.getString(_cursorIndexOfNamaPlug);
        _item.setNama_plug(_tmpNama_plug);
        final String _tmpNama_aslab;
        _tmpNama_aslab = _cursor.getString(_cursorIndexOfNamaAslab);
        _item.setNama_aslab(_tmpNama_aslab);
        final String _tmpJumlah_siswa;
        _tmpJumlah_siswa = _cursor.getString(_cursorIndexOfJumlahSiswa);
        _item.setJumlah_siswa(_tmpJumlah_siswa);
        final String _tmpJadwal;
        _tmpJadwal = _cursor.getString(_cursorIndexOfJadwal);
        _item.setJadwal(_tmpJadwal);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MhsModel> selectSiswa(int id_kelas) {
    final String _sql = "SELECT * FROM tb_siswa WHERE id_plug = ? ORDER BY nama_siswa ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id_kelas);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdMhs = _cursor.getColumnIndexOrThrow("id_siswa");
      final int _cursorIndexOfIdPlug = _cursor.getColumnIndexOrThrow("id_plug");
      final int _cursorIndexOfNamaSiswa = _cursor.getColumnIndexOrThrow("nama_siswa");
      final int _cursorIndexOfUmur = _cursor.getColumnIndexOrThrow("umur");
      final int _cursorIndexOfJenisKelamin = _cursor.getColumnIndexOrThrow("jenis_kelamin");
      final int _cursorIndexOfAsal = _cursor.getColumnIndexOrThrow("asal");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final List<MhsModel> _result = new ArrayList<MhsModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MhsModel _item;
        _item = new MhsModel();
        final int _tmpId_mhs;
        _tmpId_mhs = _cursor.getInt(_cursorIndexOfIdMhs);
        _item.setId_mhs(_tmpId_mhs);
        final int _tmpId_plug;
        _tmpId_plug = _cursor.getInt(_cursorIndexOfIdPlug);
        _item.setId_plug(_tmpId_plug);
        final String _tmpNama_siswa;
        _tmpNama_siswa = _cursor.getString(_cursorIndexOfNamaSiswa);
        _item.setNama_siswa(_tmpNama_siswa);
        final String _tmpUmur;
        _tmpUmur = _cursor.getString(_cursorIndexOfUmur);
        _item.setUmur(_tmpUmur);
        final String _tmpJenis_kelamin;
        _tmpJenis_kelamin = _cursor.getString(_cursorIndexOfJenisKelamin);
        _item.setJenis_kelamin(_tmpJenis_kelamin);
        final String _tmpAsal;
        _tmpAsal = _cursor.getString(_cursorIndexOfAsal);
        _item.setAsal(_tmpAsal);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
