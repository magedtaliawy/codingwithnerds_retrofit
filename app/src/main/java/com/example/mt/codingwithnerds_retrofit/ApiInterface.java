package com.example.mt.codingwithnerds_retrofit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @GET("posts/1")
    public Call<Post> getPost();

    @GET("posts/1")
    public Call<Post> getPost1();

    @GET("posts/{id}")
    public Call<Post> getPostPath(@Path("id") int id);

    @GET("posts")
    public Call<List<Post>>getPostQuery(@Query("userId") int userId);

    @GET("comments?postId=1")
    public Call<ArrayList<Comments>> getComments();

    @GET("comments")
    public Call<ArrayList<Comments>>getCommentsQuery(@Query("postId")int postId);

    @GET("comments")
    public Call<ArrayList<Comments>> getCommentsQueryMap(@QueryMap Map<String, Integer> options);

    @Headers("Content-type:application/json; charset=UTF-8")
    @POST("posts")
    public Call<Post>createPost(@Body Post post);

    @POST("ratings/set")
    Call<String>rate(@Body Rate rate);

}
