package estagio.pontotel;

import retrofit.Call;
import retrofit.http.GET;

public interface ConsumersService {
    @GET("/pontotel-docs/data.json")
    Call<JsonData> data();
}
