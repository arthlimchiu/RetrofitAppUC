package com.example.clariceann.retrofitappuc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText mUsername;
    TextView mName, mLocation, mEmail, mStatus;
    Button mGetUser;

    GithubApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.username);
        mName = (TextView) findViewById(R.id.name);
        mLocation = (TextView) findViewById(R.id.location);
        mEmail = (TextView) findViewById(R.id.email);
        mStatus = (TextView) findViewById(R.id.status);
        mGetUser = (Button) findViewById(R.id.get_user);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(GithubApi.class);

        mGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatus.setVisibility(View.VISIBLE);
                if (mUsername.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a username", Toast.LENGTH_SHORT).show();
                } else {
                    Call<User> call = api.getUser(mUsername.getText().toString());
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful()) {
                                User user = response.body();
                                mName.setText(user.getName());
                                mLocation.setText(user.getLocation());
                                mEmail.setText(user.getEmail());
                            } else {
                                Toast.makeText(MainActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                            }
                            mStatus.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
