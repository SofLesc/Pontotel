package estagio.pontotel;

/**
 * Created by Sofía on 16/12/2015.
 */
public class Consumer {
    private String id;
    private String name;
    private String pwd;

    public Consumer(String i, String n, String p){
        id = i;
        name = n;
        pwd = p;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPwd(){
        return pwd;
    }

    public void setName(String n){
        name= n;
    }


}
