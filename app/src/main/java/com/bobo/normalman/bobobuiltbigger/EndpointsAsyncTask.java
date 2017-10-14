package com.bobo.normalman.bobobuiltbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.bobo.normalman.jokedetailactivity.JokeDetailActivity;
import com.example.xiaobozhang.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by xiaobozhang on 10/13/17.
 */

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;


    @Override
    protected String doInBackground(Context... contexts) {
        context = contexts[0];
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://adept-vigil-116521.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        try {
            return myApiService.sayJoke().execute().getMyJoke();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String joke) {
        if (joke != null) {
            Intent intent = new Intent(context, JokeDetailActivity.class);
            intent.putExtra(JokeDetailActivity.KEY_JOKE, joke);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
