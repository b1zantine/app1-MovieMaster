package me.sudar.moviemaster.network;

import java.util.List;

import me.sudar.moviemaster.ApiCallReply;
import me.sudar.moviemaster.Movie;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by sudar on 1/2/16.
 * Email : hey@sudar.me
 */
public class TmDbService {

    private static final String BASE_URL = "http://api.themoviedb.org";

    public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185";

    private TmDbService(){}

    public static TmDbApi getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(TmDbApi.class);
    }


    public interface TmDbApi{

        String apiKey = "7924f2e5b79cb7059938deaae869fc2f";

        @GET("/3/discover/movie?sort_by=popularity.desc&api_key=" + apiKey)
        Observable<ApiCallReply> getPopularMovies();

        @GET("/3/discover/movie?sort_by=vote_average.desc&api_key=" + apiKey)
        Observable<ApiCallReply> getHighRatedMovies();
    }

}
