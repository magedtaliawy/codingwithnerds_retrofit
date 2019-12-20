package com.example.mt.codingwithnerds_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView post_title_tv=findViewById(R.id.post_title_tv);
        final TextView comment_tv=findViewById(R.id.comment_tv);
        final TextView new_post_tv=findViewById(R.id.new_post_tv);
        Retrofit retrofit=new Retrofit.Builder()
                //.baseUrl("http://jsonplaceholder.typicode.com/")
                .baseUrl("http://www.dealnotdeal.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface=retrofit.create(ApiInterface.class);

        Call<String>call=apiInterface.rate(new Rate(5,329,875,941));
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                post_title_tv.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                post_title_tv.setText(t.getMessage());
            }
        });

       /* Call<Post> call=apiInterface.getPost();
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                post_title_tv.setText(response.body().getTitle());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                post_title_tv.setText(t.getMessage());

            }
        });
       Call<List<Post>>call0=apiInterface.getPostQuery(1);
       call0.enqueue(new Callback<List<Post>>() {
           @Override
           public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               post_title_tv.setText(response.body().get(0).getTitle());
           }

           @Override
           public void onFailure(Call<List<Post>> call, Throwable t) {
               post_title_tv.setText(t.getMessage());
           }
       });
      /*  Call<Post> call1=apiInterface.getPostPath(1);
        call1.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                post_title_tv.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                post_title_tv.setText(t.getMessage());
            }
        });*/

      /*  Call <ArrayList<Comments>> call2=apiInterface.getComments();
        call2.enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                comment_tv.setText(response.body().get(0).getName());
            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {
                comment_tv.setText(t.getMessage());

            }
        });*/

      /* Call <ArrayList<Comments>> call3=apiInterface.getCommentsQuery(1);
        call3.enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                comment_tv.setText(response.body().get(0).getName());
            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {
                comment_tv.setText(t.getMessage());
            }
        });*/

      /*  Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("postId",2);
        Call<ArrayList<Comments>> call4=apiInterface.getCommentsQueryMap(map);
        call4.enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                comment_tv.setText(response.body().get(0).getName());
            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {
                comment_tv.setText(t.getMessage());

            }
        });*/

        //Test Post

        /*Post post=new Post(1,1,"maged","maged");
        Call<Post>callCreatPost=apiInterface.createPost(post);
        callCreatPost.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                new_post_tv.setText(response.body().getTitle()+" --->> "+response.body().getBody()+" --->> "+response.body().getId());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                new_post_tv.setText(t.getMessage());

            }
        });*/


    }
}
