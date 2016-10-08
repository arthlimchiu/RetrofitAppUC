package com.example.clariceann.retrofitappuc;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by clariceann on 08/10/16.
 */
public interface GithubApi {

    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);
}
