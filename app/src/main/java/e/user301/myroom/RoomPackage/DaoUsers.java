package e.user301.myroom.RoomPackage;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DaoUsers {
    @Query("select * from UserModel")
    List<UserModel> getAll();

    @Query("select * from UserModel where id = :id")
    UserModel getId (long id);

    @Insert
    void insert (UserModel userModel);

    @Update
    void update(UserModel userModel);

    @Delete
    void delete (UserModel userModel);
}
