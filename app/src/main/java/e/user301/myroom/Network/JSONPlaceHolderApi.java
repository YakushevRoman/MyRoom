package e.user301.myroom.Network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    Call<NetPojo> getNetPojo (@Path("id") int id);

    @GET("/posts")
    Call<List<NetPojo>> getAllList();

    @GET("posts/1")
    Call<NetPojo> getItem(@Query("title") String string,  @Query("id") int id);
}
