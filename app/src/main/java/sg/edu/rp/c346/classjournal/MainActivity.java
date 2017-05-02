package sg.edu.rp.c346.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<moduleRow> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv= (ListView) findViewById(R.id.lvDaily);

        al = new ArrayList<>();

        moduleRow C302 = new  moduleRow("C302", "Web Services", "http://www.rp.edu.sg/Module_Synopses/C302_Web_Services.aspx");
        al.add(C302);
        moduleRow C347 = new  moduleRow("C347", "Android Programming II", "http://www.rp.edu.sg/Module_Synopses/C347_Android_Programming_II.aspx");
        al.add(C347);


        aa = new moduleRowAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                moduleRow currentInfo = al.get(position);
                Intent i = new Intent(MainActivity.this, info.class);


                i.putExtra("Code", currentInfo.getCode());
                i.putExtra("url", currentInfo.getUrl());
                startActivity(i);

            }
        });


    }
}
