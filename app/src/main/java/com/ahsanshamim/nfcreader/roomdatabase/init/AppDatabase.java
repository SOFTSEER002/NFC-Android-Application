package com.ahsanshamim.nfcreader.roomdatabase.init;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ahsanshamim.nfcreader.roomdatabase.dao.TaskDao;
import com.ahsanshamim.nfcreader.roomdatabase.model.SQLEncryptionModel;

@Database(entities = {SQLEncryptionModel.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}

