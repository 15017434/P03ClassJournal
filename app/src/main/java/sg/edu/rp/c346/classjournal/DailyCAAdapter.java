package sg.edu.rp.c346.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15056158 on 2/5/2017.
 */

public class DailyCAAdapter extends ArrayAdapter<DailyCA> {
    private Context context;
    private ArrayList<DailyCA> dailyCAs;
    private TextView textViewGrade;
    private TextView textViewWeek;


    public DailyCAAdapter(Context context, int resource, ArrayList<DailyCA> objects){
        super(context, resource, objects);
        dailyCAs = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row_grade, parent, false);

        // Get the TextView object
        textViewGrade = (TextView) rowView.findViewById(R.id.tvGrade);
        textViewWeek = (TextView)rowView.findViewById(R.id.tvGrade);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        DailyCA currentWeek = dailyCAs.get(position);
        // Set the TextView to show the food

        textViewGrade.setText(currentWeek.getGrade());
        textViewWeek.append(" "+currentWeek.getWeek());
        return rowView;
    }
}
