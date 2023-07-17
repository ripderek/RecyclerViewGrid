package com.example.recyclerview.WebService;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;

import java.util.Map;


public class WebService extends AsyncTask<String, Long, String> {

    //Variable con los datos para pasar al web service
    private Map<String, String> datos;
    //Url del servicio web
    private String url= "http://192.168.1.46/codigobarras/";

    //Actividad para mostrar el cuadro de progreso
    private Context actividad;

    //Resultado
    private String xml=null;

    //Clase a la cual se le retorna los datos dle ws
    private Asynchtask callback=null;

    public Asynchtask getCallback() {
        return callback;
    }
    public void setCallback(Asynchtask callback) {
        this.callback = callback;
    }

    ProgressDialog progDailog;

    /**
     * Crea una estancia de la clase webService para hacer consultas a ws
     * @param urlWebService Url del servicio web
     * @param data Datos a enviar del servicios web
     * @param activity Actividad de donde se llama el servicio web, para mostrar el cuadro de "Cargando"
     * @param callback CLase a la que se le retornara los datos del servicio web
     */
    public  WebService(String urlWebService,Map<String, String> data, Context activity, Asynchtask callback) {
        this.url=urlWebService;
        this.datos=data;
        this.actividad=activity;
        this.callback=callback;
    }
    public WebService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progDailog = new ProgressDialog(actividad);
        progDailog.setMessage("Cargando Web Service...");
        progDailog.setIndeterminate(false);
        progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progDailog.setCancelable(true);
        progDailog.show();
    }
    @Override
    protected String doInBackground(String... params) {
        try {

            HttpRequest h=new HttpRequest(this.url,params[0]);
            for (int k=1;k< params.length;k+=2)
            {
                h.header(params[k],params[k+1]);
            }

            String r=  h.form(this.datos).body();

            return r;

        } catch (HttpRequest.HttpRequestException exception) {
            Log.e("doInBackground", exception.getMessage());

            return "Error HttpRequestException";
        } catch (Exception e) {
            Log.e("doInBackground", e.getMessage());
            return "Error Exception " +  e.getMessage();
        }
    }
    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        this.xml=response;
        progDailog.dismiss();
        //Retorno los datos
        try {
            callback.processFinish(this.xml);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public Map<String, String> getDatos() {
        return datos;
    }

    public void setDatos(Map<String, String> datos) {
        this.datos = datos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Context getActividad() {
        return actividad;
    }

    public void setActividad(Context actividad) {
        this.actividad = actividad;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public ProgressDialog getProgDailog() {
        return progDailog;
    }

    public void setProgDailog(ProgressDialog progDailog) {
        this.progDailog = progDailog;
    }
}
