package e.user301.myroom.RoomPackage;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

//
@Entity
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public int salary;

}
