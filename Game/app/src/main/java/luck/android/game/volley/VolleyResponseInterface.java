package luck.android.game.volley;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by JitendraSingh on 13-10-2016.
 */
public interface VolleyResponseInterface {

    public void onJsonResponse(JSONObject object, int tag);
    public void onJsonArrayResponse(JSONArray array, int tag);
    public void onStringResponse(String string, int tag);
    public void onError(VolleyError error, int tag);
}
