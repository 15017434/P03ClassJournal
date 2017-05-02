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

public class moduleRowAdapter extends ArrayAdapter<moduleRow> {

    private Context context;
    private ArrayList<moduleRow> module;
    private TextView tvCode, tvName;

    public moduleRowAdapter(Context context, int resource, ArrayList<moduleRow> objects){
        super(context, resource, objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object

        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvCode = (TextView) rowView.findViewById(R.id.tvCode);
        tvName = (TextView) rowView.findViewById(R.id.tvName);

        moduleRow currentModule = module.get(position);

        tvCode.setText(currentModule.getCode());
        tvName.setText(currentModule.getName());

        // Return the nicely done up View to the ListView
        return rowView;
    }


}


