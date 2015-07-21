package com.example.android.adapters;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final ArrayList<Clima> lista = new ArrayList<Clima>();
        lista.add(new Clima("Lunes", "Soleado", "34�/28�", R.drawable.lluvia));
        lista.add(new Clima("Martes", "Soleado", "34�/28�", R.drawable.soleado));
        lista.add(new Clima("Miercoles", "Soleado", "34�/28�", R.drawable.nublado));
        lista.add(new Clima("Lunes", "Soleado", "34�/28�", R.drawable.soleado));

        List<Clima> listaAdapter = (List) lista;
        ClimaAdapter adapter = new ClimaAdapter(getActivity(), R.layout.list_item_forecast, listaAdapter);

        ListView listView = (ListView) rootView.findViewById(R.id.list_item_forecast);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = lista.get(position).toString();

                Toast.makeText(getActivity(), item, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("localhost"));
                startActivity(intent);

            }
        });

        new LoadURL("").execute("");//para llamar a la parte URL

        return rootView;
    }
    //Para conectar a una página y pedir info
    private class loadURL extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection httpURLConnection;
            BufferedReader bufferedReader;
            StringBuilder stringBuilder;
            String jsonString;

            try{
                URL url = new URL("");
                httpURLConnection = (HttpURLConnection)url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));//.getInputStream no se sabe si es el que va

                stringBuilder = new StringBuilder();
                String line="";

                while((line=bufferedReader.readLine())!=null){
                    stringBuilder.append(line+"\n");
                }
                jsonString = stringBuilder.toString();
                Log.d("URL DATA", jsonString);
                httpURLConnection.disconnect();

            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }
    }
}
