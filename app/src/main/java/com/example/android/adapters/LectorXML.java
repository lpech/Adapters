package com.example.android.adapters;

import android.content.res.Resources;
import android.provider.DocumentsContract;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Administrador on 25/06/2015.
 */
public class LectorXML {

    public Vector<Clima> leerClima(){
        ArrayList<Clima> climas = new ArrayList<Clima>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(getResources().openRawResource(R.raw.climas));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Resources getResources() {
        return resources;
    }
    /*Vector<Clima>climas=new Vector<Clima>();*/



    HttpGet httpGet = new HttpGet("http://api.openweathermap.org/data/2.5/forecast?q=Mexico,mx&mode=xml");
    HttpClient httpCliente = new DefaultHttpClient();
    HttpResponse response = httpCliente.execute(httpGet);
}

