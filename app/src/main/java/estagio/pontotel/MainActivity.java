package estagio.pontotel;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String API_BASE_URL = "https://s3-sa-east-1.amazonaws.com";
    ArrayList<Consumer> consumers;
    JsonData jsonData;
    ListView lvConsumers;
    ConsumerAdapter adapterConsumers;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvConsumers = (ListView)findViewById(R.id.listView);
        consumers = new ArrayList<>();
        jsonData = new JsonData();

        new ReadFileTask().execute();

        adapterConsumers = new ConsumerAdapter(this, consumers);
        lvConsumers.setAdapter(adapterConsumers);
    }

    private class ReadFileTask extends AsyncTask<URL, Void, Integer> {
        protected Integer doInBackground(URL... urls) {
            ConsumersService service = retrofit.create(ConsumersService.class);
            Call<JsonData> data = service.data();
            try {
                jsonData = data.execute().body();
                for (int i=0; i < jsonData.getData().size(); i++) {
                    Consumer currentConsumer = jsonData.getData().get(i);
                    consumers.add(new Consumer(currentConsumer.getId(), currentConsumer.getName(), currentConsumer.getPwd()));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            runOnUiThread(new Runnable(){
                public void run(){
                    lvConsumers.setAdapter(new ConsumerAdapter(MainActivity.this, consumers));
                }
            });

            return 0;
        }

    }

}
