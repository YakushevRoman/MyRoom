package e.user301.myroom;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import e.user301.myroom.Retrofit2.Message;
import e.user301.myroom.Retrofit2.MessagesApi;
import e.user301.myroom.RoomPackage.AppDataBase;
import e.user301.myroom.RoomPackage.DaoUsers;
import e.user301.myroom.RoomPackage.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "qq";
    DaoUsers daoUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDataBase appDataBase = App.getInstance().getDataBase();
        daoUsers = appDataBase.daoUsers();

        final UserModel userModel = new UserModel();

        userModel.name = "roman";
        userModel.salary = 10000;

        new Thread(new Runnable() {
            @Override
            public void run() {
                daoUsers.insert(userModel);
                List<UserModel> userModels = daoUsers.getAll();
                for (UserModel userModel1 : userModels){
                    Log.d(TAG, String.format("run: id : %s , name: %s , salary: %s ", userModel1.id, userModel1.name, userModel1.salary));
                }
            }
        }).start();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rawgit.com/startandroid/data/master/messages/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MessagesApi messagesApi = retrofit.create(MessagesApi.class);
        Call<List<Message>> listCall = messagesApi.mListCall();
        listCall.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                Log.d(TAG, "onResponse: " + response.body().size());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

            }
        });
    }

    class AddData extends AsyncTask<UserModel, Void, Void>{

        @Override
        protected Void doInBackground(UserModel... userModels) {
            UserModel userModel = userModels[0];
            daoUsers.insert(userModel);
            return null;
        }
    }
}
