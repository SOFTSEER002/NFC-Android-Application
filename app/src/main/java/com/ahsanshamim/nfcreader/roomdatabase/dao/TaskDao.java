package com.ahsanshamim.nfcreader.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ahsanshamim.nfcreader.roomdatabase.model.SQLEncryptionModel;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM sqlencryptionmodel")
    List<SQLEncryptionModel> getAll();

    @Insert
    void insert(SQLEncryptionModel task);



}
