package sg.edu.rp.c346.classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class info extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCAs;
    String message = "";
    Button btnInfo;
    Button btnEmail;
    Button btnAdd;

    int sizeOfWeeks;
    int requestCodeForGrade = 1;
    //hi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent i = getIntent();
        String title = i.getStringExtra("Code");

        final String url = i.getStringExtra("url");
        setTitle("Info for " + title);

        lv = (ListView) findViewById(R.id.lvGrades);
        btnInfo = (Button) findViewById(R.id.buttonInfo);


        dailyCAs = new ArrayList<DailyCA>();
        if (title.equalsIgnoreCase("C302")) {
            dailyCAs.add(new DailyCA(1, "B"));
            dailyCAs.add(new DailyCA(2, "C"));
            dailyCAs.add(new DailyCA(3, "A"));

        } else {
            dailyCAs.add(new DailyCA(1, "B"));
            dailyCAs.add(new DailyCA(2, "C"));
            dailyCAs.add(new DailyCA(3, "A"));
        }


        aa = new DailyCAAdapter(this, R.layout.row_grade, dailyCAs);
        lv.setAdapter(aa);

        btnEmail = (Button) findViewById(R.id.buttonEmail);
        btnAdd = (Button) findViewById(R.id.buttonAdd);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int num = 0; num < dailyCAs.size(); num++) {
                    message += "Week " + dailyCAs.get(num).getWeek() + ": DG: " + dailyCAs.get(num).getGrade() + "\n";
                }

                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT,
                        message);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse(url));
                startActivity(rpIntent);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sizeOfWeeks = dailyCAs.size() + 1;
                Intent weeks = new Intent(info.this, addDailyGrade.class);
                weeks.putExtra("week", dailyCAs.size() + 1 + "");
                startActivityForResult(weeks, requestCodeForGrade);
            }
        });
    }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            // Only handle when 2nd activity closed normally
            //  and data contains something
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    // Get data passed back from 2nd activity
                    String grade = data.getStringExtra("grade");
                    // Get data passed back from 2nd activity


                    if (requestCode == requestCodeForGrade) {
                        dailyCAs.add(new DailyCA(sizeOfWeeks, grade));
                        aa.notifyDataSetChanged();
                    }

                }
            }
        }

    }