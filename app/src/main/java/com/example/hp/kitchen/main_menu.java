package com.example.hp.kitchen;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class main_menu extends Fragment{

    ListView listView;
    ProgressBar progressBar;
    Button addItem;
    public main_menu() {
        // Required empty public constructor
    }
    String[] items =
            {
                    "Microwave",
                    "Fridge",
                    "Main Light",

            };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        //ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressbar);

        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, new ArrayList<String>()));

        // listView.setAdapter(adapter);
        new MyTask(view).execute();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value = (String) adapterView.getItemAtPosition(position);
                Toast.makeText(getContext(), value + " in Action", Toast.LENGTH_SHORT).show();

                if (position == 0) {
                    Intent microwave = new Intent(view.getContext(), microwave.class);
                    startActivity(microwave);
                }
                if (position == 1) {
                    Intent fridge = new Intent(view.getContext(), fridge.class);
                    startActivity(fridge);
                }
                if (position == 2) {
                    Intent light = new Intent(view.getContext(), mainlight.class);
                    startActivity(light);
                }

            }
        });
        return view;
    }
    class MyTask extends AsyncTask<Void, String, String> {
        View parentView;
        public MyTask(View vw)
        {
            parentView = vw;
        }
        private ArrayAdapter<String> adapter2;
        ProgressBar progressBar;
        int count;
        @Override
        protected void onPreExecute() {
            adapter2 = (ArrayAdapter<String>) listView.getAdapter() ;
            progressBar = (ProgressBar) parentView.findViewById(R.id.progressbar);
            progressBar.setMax(3);
            progressBar.setProgress(0);
            progressBar.setVisibility(View.VISIBLE);
            count = 0;
        }

        @Override
        protected String doInBackground(Void... params) {
            for(String names: items)
            {
                publishProgress(names);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "All 3 Items were added Successfully";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter2.add(values[0]);
            count++;
            progressBar.setProgress(count);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(listView.getContext(), "added successfully = 3items", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }

    }


    public interface OnFragmentInteractionListener {
    }
}
