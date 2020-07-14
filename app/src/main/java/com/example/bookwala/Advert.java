package com.example.bookwala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Advert extends AppCompatActivity {

    Spinner dd_semester , dd_subject , dd_publication;
    ArrayList<String> arr_list_sem;
    ArrayAdapter<String> arr_adapt_sem;

    ArrayList<String> arrayList_sem1,arrayList_sem2,arrayList_sem3,arrayList_sem4,arrayList_sem5,arrayList_sem6,arrayList_sem7,arrayList_sem8;
    ArrayAdapter<String> arr_adapter_subject;

    ArrayList<String> arrayList_publication;
    ArrayAdapter<String> arr_adapt_publication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert);

        dd_semester=(Spinner)findViewById(R.id.select_sem_dd);
        dd_subject=(Spinner)findViewById(R.id.select_subject_dd);

        dd_publication=(Spinner)findViewById(R.id.select_publication_dd);

        arr_list_sem=new ArrayList<>();
        arr_list_sem.add("1");
        arr_list_sem.add("2");
        arr_list_sem.add("3");
        arr_list_sem.add("4");
        arr_list_sem.add("5");
        arr_list_sem.add("6");
        arr_list_sem.add("7");
        arr_list_sem.add("8");

        arr_adapt_sem=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arr_list_sem);
        dd_semester.setAdapter(arr_adapt_sem);

        //+++++++++++++++  Subject Spinner  ++++++++++++++++++++++++
        arrayList_sem1=new ArrayList<>();
        arrayList_sem1.add("FPL-I");
        arrayList_sem1.add("Physics");
        arrayList_sem1.add("Civil");

        arrayList_sem2=new ArrayList<>();
        arrayList_sem2.add("FPL-II");
        arrayList_sem2.add("Chemistry");

        arrayList_sem3=new ArrayList<>();
        arrayList_sem3.add("Data structure");
        arrayList_sem3.add("virkar");

        arrayList_sem4=new ArrayList<>();
        arrayList_sem4.add("CG");
        arrayList_sem4.add("PPL");

        arrayList_sem5=new ArrayList<>();
        arrayList_sem5.add("SMD");
        arrayList_sem5.add("kay mahit");

        arrayList_sem6=new ArrayList<>();
        arrayList_sem6.add("spos");
        arrayList_sem6.add("WT");


        arrayList_sem7=new ArrayList<>();
        arrayList_sem7.add("AIR");
        arrayList_sem7.add("DBW");


        arrayList_sem8=new ArrayList<>();
        arrayList_sem8.add("Final year");
        arrayList_sem8.add("final year");

        dd_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem1);
                }
                if (position==1)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem2);
                }
                if (position==2)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem3);
                }
                if (position==3)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem4);
                }
                if (position==4)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem5);
                }
                if (position==5)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem6);
                }
                if (position==6)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem7);
                }
                if (position==7)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem8);
                }

                dd_subject.setAdapter(arr_adapter_subject);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //+++++++++++++++  Publication spinner  ++++++++++++++++++
        arrayList_publication=new ArrayList<>();
        arrayList_publication.add("Techmax");
        arrayList_publication.add("decode");
        arrayList_publication.add("Technical");
        arrayList_publication.add("Techneo");
        arrayList_publication.add("Others");


        arr_adapt_publication=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_publication);
        dd_publication.setAdapter(arr_adapt_publication);


    }
}