package com.durocrete_mumbai_sales_app.reports;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.durocrete_mumbai_sales_app.R;

import java.util.List;

/**
 * Created by root on 26/5/17.
 */

public class Reportlistadapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Report> Allreportlist;


    public Reportlistadapter(FragmentActivity activity, List<Report> alltestlist) {
        this.activity = activity;
        this.Allreportlist = alltestlist;
    }


    @Override
    public int getCount() {
        return Allreportlist.size();
    }

    @Override
    public Object getItem(int position) {
        return Allreportlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<Report> Alltestlist() {
        return this.Allreportlist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.report_list_single_row, null);
        }
        TextView testname = (TextView) convertView.findViewById(R.id.testname);
//            TextView testrate = (TextView) convertView.findViewById(R.id.testrate);
        final CheckBox selectcheckbox = (CheckBox) convertView.findViewById(R.id.checkbox);



        final Report reportlist = Allreportlist.get(position);


        testname.setText(reportlist.getReport());

        selectcheckbox.setChecked(reportlist.getIsChecked());


        selectcheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectcheckbox.isChecked()) {
                    reportlist.setIschecked(true);

                } else {
                    reportlist.setIschecked(false);

                }
            }
        });

//

        return convertView;
    }


}


