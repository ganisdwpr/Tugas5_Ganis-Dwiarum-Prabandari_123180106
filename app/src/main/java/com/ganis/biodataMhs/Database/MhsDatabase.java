package com.ganis.biodataMhs.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ganis.biodataMhs.Model.MhsModel;
import com.ganis.biodataMhs.Model.PlugModel;

@Database(entities = {PlugModel.class, MhsModel.class}, version = 2)
public abstract class MhsDatabase extends RoomDatabase {

    public abstract PlugDao plugDao();

    private static MhsDatabase INSTANCE;

    // Membuat method return untuk membuat database
    public static MhsDatabase createDatabase(Context context){
        synchronized (MhsDatabase.class){
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, MhsDatabase.class, "db_siswa")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}
