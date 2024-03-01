package com.example.packyourbag.Dao;


import static java.nio.charset.CodingErrorAction.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.packyourbag.models.Items;

import java.util.List;

@Dao
public interface ItemsDao {
    @Insert(onConflict = REPLACE)
    void saveItem(Items items);

    @Query("select * from items where category =: category order by id asc")
    List<Items> getAll(String category);

    @Delete
    void delete(Items items);

    @Query("update items set checked=:checked where ID=:id")
    void checkUncheck(int id, boolean checked);

    @Query("select count(*) from items")
    Integer getItemsCount();

    @Query("delete from items where addedby=:addedBy")
    Integer deleteAllSystemItems(String addedBy);

}
