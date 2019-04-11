package e.user301.myroom;

import android.app.Application;
import android.arch.persistence.room.Room;

import e.user301.myroom.RoomPackage.AppDataBase;

public class App extends Application {
    public static App instance;

    private AppDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        dataBase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class,"firstdatabase")
                .allowMainThreadQueries()
                .build();


    }

    public static App getInstance(){
        return instance;
    }

    public AppDataBase getDataBase(){
        return dataBase;
    }
}
