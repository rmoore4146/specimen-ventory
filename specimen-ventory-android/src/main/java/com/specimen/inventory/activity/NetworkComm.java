package com.specimen.inventory.activity;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class NetworkComm extends AsyncTask<String, Integer, String> {

    // Log tag
    private static final String TAG = "NetworkComm";

    private AndroidHttpClient hc;
    private HttpContext localContext;
    private TaskResponseListener listener;
    private int reqType;
    private String message;
    private String url;
    private Object extra;

    public NetworkComm(AndroidHttpClient hc, HttpContext localContext, TaskResponseListener listener, 
            int reqType, String message, String url, Object extra){
        super();

        this.hc = hc;
        this.localContext = localContext;
        this.listener = listener;
        this.reqType = reqType;
        this.message = message;
        this.url = url;
        this.extra = extra;
    }

    public AndroidHttpClient getHc() {
        return hc;
    }

    public void setHc(AndroidHttpClient hc) {
        this.hc = hc;
    }

    public HttpContext getLocalContext() {
        return localContext;
    }

    public void setLocalContext(HttpContext localContext) {
        this.localContext = localContext;
    }

    public void start(){
        Log.e("blah", message);
        this.execute(message);
    }

    protected void onPreExecute() {
        //Don't do anything here
    }

    protected String doInBackground(String... req) {

        Log.d(TAG, "Message to send: " + req[0]);
        HttpPost p = new HttpPost(url);

        try{
            p.setEntity(new StringEntity(req[0], "UTF8"));
        }catch(Exception e){
            e.printStackTrace();
        }
        p.setHeader("Content-type", "application/json");

        String response = "";
        try{


            HttpResponse resp = hc.execute(p, localContext);
            InputStream is = resp.getEntity().getContent();
            response = convertStreamToString(is);
            Log.d("Response", "Response is " + response);

            Log.d("Status line", ""+resp.getStatusLine().getStatusCode());
        } catch (HttpHostConnectException hhce){
            //do error handle
            hhce.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return response;
     }

     protected void onProgressUpdate(Integer... progress) {
         // dont handle this yet
     }

     @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    protected void onPostExecute(String result) {
        Log.d("task", "task finished");
        hc.close();
        listener.onTaskResponse(reqType, result, extra);
     }

     public interface TaskResponseListener{
         public void onTaskResponse(int type, String response, Object extra);
     }

     private String convertStreamToString(InputStream is) throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {        
            return "";
        }
     }
}