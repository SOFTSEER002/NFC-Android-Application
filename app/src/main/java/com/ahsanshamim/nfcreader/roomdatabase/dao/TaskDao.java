package com.ahsanshamim.nfcreader.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ahsanshamim.nfcreader.roomdatabase.model.SQLEncryptionModel;

import java.util.List;

@Dao
public interface TaskDao {


    @Query("DELETE FROM sqlencryptionmodel")
    void removeAll();

    @Query("SELECT * FROM sqlencryptionmodel")
    List<SQLEncryptionModel> getAll();

    @Insert
    void insert(SQLEncryptionModel task);

    @Query("SELECT * FROM sqlencryptionmodel where encryption_id=:id")
    SQLEncryptionModel findEncr(int id);



}
