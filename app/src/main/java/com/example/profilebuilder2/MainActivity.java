package com.example.profilebuilder2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private String githubusername = null;
    private void setDetails(Portfolio portfolio) {
        TextView Name=findViewById(R.id.h1);
        TextView Position=findViewById(R.id.h2);
        TextView Institute_Name=findViewById(R.id.h4);
        TextView Degree=findViewById(R.id.h5);
        TextView Edu_Year=findViewById(R.id.h6);
        TextView Course=findViewById(R.id.h8);
        TextView Organisation=findViewById(R.id.h9);
        TextView Course_Year=findViewById(R.id.h10);

        Name.setText(portfolio.getName());
        Position.setText(portfolio.getPosition());
        Institute_Name.setText(portfolio.getEducation().getUniversity_name());
        Degree.setText(portfolio.getEducation().getDegree());
        Edu_Year.setText(portfolio.getEducation().getEdu_year());
        Course.setText(portfolio.getCourse().getCourse());
        Organisation.setText(portfolio.getCourse().getOrganisation_name());
        Course_Year.setText(portfolio.getCourse().getCourse_year());
        githubusername= portfolio.getGithub_username();

    }
    public void openGithub(View view) {
        String githuburl="https://github.com/";
        if(githubusername!=null) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githuburl+githubusername));
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this, "No Valid Github Username found !!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton adddetails=findViewById(R.id.fab);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data= result.getData();
                    Portfolio portfolio=data.getParcelableExtra(MainActivity2.PARA_PORTFOLIO);
                    if(portfolio!=null)
                        setDetails(portfolio);
                }
            }
        });
        adddetails.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                launcher.launch(intent);
            }
        });

    }
}