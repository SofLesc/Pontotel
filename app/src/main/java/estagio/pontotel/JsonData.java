package estagio.pontotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sofía on 16/12/2015.
 */
public class JsonData {
    private List<Consumer> data;

    public JsonData(List<Consumer> c){
        data = new ArrayList<Consumer>(c);
    }

    public JsonData(){
        data = new ArrayList<Consumer>();
    }

    public List<Consumer> getData(){
        return data;
    }

}
