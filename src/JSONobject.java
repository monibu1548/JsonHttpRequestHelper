import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by monibu on 2015. 8. 5..
 */
public class JSonObject {

    Map data;

    public void put(String key, Object value){
        data.put(key, value);
    }

    public Object get(String key){
        return data.get(key);
    }


    @Override
    public String toString() {
        return getJSONstring();
    }

    public String getJSONstring(){
        StringBuffer json = new StringBuffer("{ ");

        Iterator<String> keys=  data.keySet().iterator();

        while(keys.hasNext()){
            String key = keys.next();

            json.append(String.format(" \"%s : %s \" ", key, data.get(key)));

        }


        json.append(" }");
        return json.toString();
    }

}
