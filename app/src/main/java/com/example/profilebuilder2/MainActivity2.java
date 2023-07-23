package com.example.profilebuilder2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public static final String PARA_PORTFOLIO="para-portfolio";
    public void submitdata(View view) {
        EditText name=findViewById(R.id.name);
        EditText pos=findViewById(R.id.pos);
        EditText uniName=findViewById(R.id.uni_name);
        EditText degree=findViewById(R.id.degree);
        EditText eduyear=findViewById(R.id.eduyear);
        EditText course_name=findViewById(R.id.course);
        EditText org_name=findViewById(R.id.org);
        EditText course_year=findViewById(R.id.courseyear);
        EditText githubusername=findViewById(R.id.username);

        if(name.getText().toString().isEmpty() || name.getText().toString()==null) {
            name.setError("Valid Name Mandatory");
            name.requestFocus();
        }

        Education education=new Education(uniName.getText().toString(),degree.getText().toString(),eduyear.getText().toString());
        Course course=new Course(course_name.getText().toString(),org_name.getText().toString(),course_year.getText().toString());
        Portfolio portfolio=new Portfolio(name.getText().toString(),pos.getText().toString(),education,course,githubusername.getText().toString());
        Intent intent=new Intent();
        intent.putExtra(PARA_PORTFOLIO,portfolio);
        setResult(RESULT_OK,intent);
        finish();
    }
}