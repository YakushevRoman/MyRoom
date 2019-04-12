package e.user301.myroom.Network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    Call<NetPojo> getNetPojo (@Path("id") int id);

    @GET("/posts")
    Call<List<NetPojo>> getAllList();
}
