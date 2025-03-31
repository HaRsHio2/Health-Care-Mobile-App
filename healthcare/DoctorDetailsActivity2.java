package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DoctorDetailsActivity2 extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    { "Doctor Name:Ajit Saste","Hospital Address:Moodabidri","Exp:5yrs","Mobile No:9876543218","1600"},
                    { "Doctor Name:Preethi","Hospital Address:Mangalore","Exp:6yrs","Mobile No:9834567218","1800"},
                    { "Doctor Name:Deepika","Hospital Address:Bangalore","Exp:5yrs","Mobile No:876543218","1700"},
                    { "Doctor Name:Suraj","Hospital Address:Udupi","Exp:3yrs","Mobile No:884323218","1600"},
                    { "Doctor Name:Arman","Hospital Address:Manipal","Exp:5yrs","Mobile No:953213218","1900"}
            };
    private String[][] doctor_details2=
            {
                    { "Doctor Name:Priyanshu ","Hospital Address:Moodabidri","Exp:5yrs","Mobile No:9876543218","1600"},
                    { "Doctor Name:Rakshitha","Hospital Address:Mangalore","Exp:6yrs","Mobile No:9834567218","1800"},
                    { "Doctor Name:Thanvi","Hospital Address:Bangalore","Exp:5yrs","Mobile No:876543218","1700"},
                    { "Doctor Name:Gyan","Hospital Address:Udupi","Exp:3yrs","Mobile No:884323218","1600"},
                    { "Doctor Name:Vedath","Hospital Address:Manipal","Exp:5yrs","Mobile No:953213218","1900"}
            };
    private String[][] doctor_details3=
            {
                    { "Doctor Name:Vismitha","Hospital Address:Moodabidri","Exp:5yrs","Mobile No:9876543218","1600"},
                    { "Doctor Name:Bhoomi","Hospital Address:Mangalore","Exp:6yrs","Mobile No:9834567218","1800"},
                    { "Doctor Name:Sharath","Hospital Address:Bangalore","Exp:5yrs","Mobile No:876543218","1700"},
                    { "Doctor Name:Nitesh K","Hospital Address:Udupi","Exp:3yrs","Mobile No:884323218","1600"},
                    { "Doctor Name:Suma k","Hospital Address:Manipal","Exp:5yrs","Mobile No:953213218","1900"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details2);

        tv =findViewById(R.id.textViewDDTitle);
        btn =findViewById(R.id.buttonDDBack);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Psychotherapists")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Psychologists")==0)
            doctor_details=doctor_details2;
        else

            doctor_details=doctor_details3;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity2.this,FindDoctorActivity2.class));
            }
        });
            list =new ArrayList();
            for (int i=0;i<doctor_details.length;i++){
                item=new HashMap<String,String>();
                item.put("line1",doctor_details[i][0]);
                item.put("line2",doctor_details[i][1]);
                item.put("line3",doctor_details[i][2]);
                item.put("line4",doctor_details[i][3]);
                item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
                list.add(item);
            }
            sa = new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,}
                    );
        ListView lst =findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity2.this,BookAppointmentActivity2.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}