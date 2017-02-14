package luck.android.game.volley;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import luck.android.game.utils.ApplicationClass;

/**
 * Created by JitendraSingh on 13-10-2016.
 */
public class VolleyInvokeWebService {

    public static final int JSON_TYPE_REQUEST = 1;
    public static final int STRING_TYPE_REQUEST = 2;
    public static final int JSON_ARRAY_REQUEST = 3;
    private int mRequestType;
    private VolleyResponseInterface mListener;
    private int mRequestMethod;

    public VolleyInvokeWebService(int requestType,VolleyResponseInterface listener,int method)
    {
        mRequestType = requestType;
        mListener = listener;
        mRequestMethod = method;
    }

    public void hitWebService(String URL, JSONObject payload, int requestTag)
    {
        switch (mRequestType)
        {
            case JSON_TYPE_REQUEST:
            {
                fetchJSONDataFromWebService(URL,payload,requestTag);
                break;
            }
            case STRING_TYPE_REQUEST :
            {
                fetchStringDataFromWebService(URL,payload,requestTag);
                break;
            }
            case JSON_ARRAY_REQUEST :
            {
                fetchJSONArrayFromWebService(URL,null,requestTag);
                break;
            }
        }
    }

    private void fetchJSONDataFromWebService(String URL, JSONObject jsonPayload, final int requestTag)
    {
        try
        {
            if (URL !=null)
                Log.d("jits","URL JSON hit for tag "+requestTag+" is-->"+URL);
            if (jsonPayload !=null)
                Log.d("jits","JSON Payload for Tag "+requestTag+"is-->"+jsonPayload);
        }
        catch(Exception e)
        {
            Log.d("jits","Exception in "+requestTag+"is-->"+e.getMessage());
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(mRequestMethod,URL,jsonPayload,

                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            mListener.onJsonResponse(response,requestTag);
                            if (response !=null)
                            {
                                try
                                {
                                    Log.d("jits","JSON Response for "+requestTag+" is-->"+response);
                                }
                                catch (Exception e)
                                {
                                    Log.d("jits","Exception in "+requestTag+" response is-->"+e.getMessage());
                                }
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            mListener.onError(error,requestTag);
                            if (error !=null)
                                Log.d("jits","Error Response for "+requestTag+" is-->"+error);
                        }
                    }) {

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    return headers;
                }
            };
        jsonObjReq.setTag(requestTag);
        ApplicationClass.getInstance().addToRequestQueue(jsonObjReq);
    }

    private void fetchJSONArrayFromWebService(String URL, JSONArray jsonPayload, final int requestTag)
    {
        try
        {
            if (URL !=null)
                Log.d("jits","URL JSON array hit for tag "+requestTag+" is-->"+URL);
            if (jsonPayload !=null)
                Log.d("jits","JSON Payload for "+requestTag+" is-->"+jsonPayload);
        }
        catch (Exception e)
        {
            Log.d("jits","Exception for tag "+requestTag+" is-->"+e.getMessage());
        }

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(mRequestMethod,URL,jsonPayload,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray array) {
                        mListener.onJsonArrayResponse(array,requestTag);
                        if (array !=null)
                            try
                            {
                                Log.d("jits","JSON array Response for "+requestTag+" is-->"+array);
                            }
                            catch (Exception e)
                            {
                                Log.d("jits","Exception for "+requestTag+" in response is-->"+e.getMessage());
                            }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mListener.onError(error,requestTag);
                        if (error !=null)
                            Log.d("jits","Error Response for "+requestTag+" is-->"+error);
                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        jsonObjReq.setTag(requestTag);
        ApplicationClass.getInstance().addToRequestQueue(jsonObjReq);
    }

    private void fetchStringDataFromWebService(String URL, JSONObject jsonPayload, final int requestTag)
    {
        try
        {
            if(URL!=null)
                Log.d("jits","URL String hit for "+requestTag+" is-->"+URL);
            if (jsonPayload !=null)
                Log.d("jits","JSON Payload for "+requestTag+" is-->"+jsonPayload);
        }catch (Exception e)
        {
            Log.d("jits","Exception in for "+requestTag+" is-->"+e.getMessage());
        }

        StringRequest stringRequest = new StringRequest(mRequestMethod,URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mListener.onStringResponse(response,requestTag);
                        try
                        {
                            if (response !=null)
                                Log.d("jits","String Response for "+requestTag+" is-->"+response);
                        }
                        catch (Exception e)
                        {
                            Log.d("jits","Exception in response for "+requestTag+" is-->"+e.getMessage());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mListener.onError(error,requestTag);
                        if (error !=null)
                            Log.d("jits","Error Response for "+requestTag+" is-->"+error);
                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        stringRequest.setTag(requestTag);
        ApplicationClass.getInstance().addToRequestQueue(stringRequest);
    }

}
