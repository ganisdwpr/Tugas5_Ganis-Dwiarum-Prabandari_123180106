package com.ganis.biodataMhs.Database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class MhsDatabase_Impl extends MhsDatabase {
  private volatile PlugDao _plugDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `plug` (`id_plug` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nama_plug` TEXT, `nama_aslab` TEXT, `jumlah_siswa` TEXT, `jadwal` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_siswa` (`id_siswa` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_plug` INTEGER NOT NULL, `nama_siswa` TEXT, `umur` TEXT, `jenis_kelamin` TEXT, `asal` TEXT, `email` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"98ac28f5e451a5c52658b96e0a3f6036\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `plug`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_siswa`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPlug = new HashMap<String, TableInfo.Column>(5);
        _columnsPlug.put("id_plug", new TableInfo.Column("id_plug", "INTEGER", true, 1));
        _columnsPlug.put("nama_plug", new TableInfo.Column("nama_plug", "TEXT", false, 0));
        _columnsPlug.put("nama_aslab", new TableInfo.Column("nama_aslab", "TEXT", false, 0));
        _columnsPlug.put("jumlah_siswa", new TableInfo.Column("jumlah_siswa", "TEXT", false, 0));
        _columnsPlug.put("jadwal", new TableInfo.Column("jadwal", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlug = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlug = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlug = new TableInfo("plug", _columnsPlug, _foreignKeysPlug, _indicesPlug);
        final TableInfo _existingPlug = TableInfo.read(_db, "plug");
        if (! _infoPlug.equals(_existingPlug)) {
          throw new IllegalStateException("Migration didn't properly handle plug(com.ganis.biodataMhs.Model.PlugModel).\n"
                  + " Expected:\n" + _infoPlug + "\n"
                  + " Found:\n" + _existingPlug);
        }
        final HashMap<String, TableInfo.Column> _columnsTbSiswa = new HashMap<String, TableInfo.Column>(7);
        _columnsTbSiswa.put("id_siswa", new TableInfo.Column("id_siswa", "INTEGER", true, 1));
        _columnsTbSiswa.put("id_plug", new TableInfo.Column("id_plug", "INTEGER", true, 0));
        _columnsTbSiswa.put("nama_siswa", new TableInfo.Column("nama_siswa", "TEXT", false, 0));
        _columnsTbSiswa.put("umur", new TableInfo.Column("umur", "TEXT", false, 0));
        _columnsTbSiswa.put("jenis_kelamin", new TableInfo.Column("jenis_kelamin", "TEXT", false, 0));
        _columnsTbSiswa.put("asal", new TableInfo.Column("asal", "TEXT", false, 0));
        _columnsTbSiswa.put("email", new TableInfo.Column("email", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbSiswa = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbSiswa = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbSiswa = new TableInfo("tb_siswa", _columnsTbSiswa, _foreignKeysTbSiswa, _indicesTbSiswa);
        final TableInfo _existingTbSiswa = TableInfo.read(_db, "tb_siswa");
        if (! _infoTbSiswa.equals(_existingTbSiswa)) {
          throw new IllegalStateException("Migration didn't properly handle tb_siswa(com.ganis.biodataMhs.Model.MhsModel).\n"
                  + " Expected:\n" + _infoTbSiswa + "\n"
                  + " Found:\n" + _existingTbSiswa);
        }
      }
    }, "98ac28f5e451a5c52658b96e0a3f6036", "aab34e086ff4cfb2dd08140a615f5a9a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "plug","tb_siswa");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `plug`");
      _db.execSQL("DELETE FROM `tb_siswa`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public PlugDao plugDao() {
    if (_plugDao != null) {
      return _plugDao;
    } else {
      synchronized(this) {
        if(_plugDao == null) {
          _plugDao = new PlugDao_Impl(this);
        }
        return _plugDao;
      }
    }
  }
}
