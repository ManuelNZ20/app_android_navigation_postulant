package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.domain.entities.GradeInstructor;
import com.example.myapplication.domain.entities.Person;
import com.example.myapplication.domain.entities.Postulant;
import com.example.myapplication.ui.screens.MainActivity2;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtLastName, edtAge;
    private RadioButton rbExperience, rbSNExperience;
    private Spinner spGradeInstructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtName = (EditText) findViewById(R.id.edtName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        rbExperience = (RadioButton) findViewById(R.id.rbExperience);
        rbSNExperience = (RadioButton) findViewById(R.id.rbSNExperience);
        spGradeInstructor = (Spinner) findViewById(R.id.spGradeInstructor);
        GradeInstructor gradeInstructors[] = {GradeInstructor.INICIAL, GradeInstructor.PRIMARIA, GradeInstructor.SECUNDARIA, GradeInstructor.SUPERIOR};
        ArrayAdapter<GradeInstructor> gradesInstructor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gradeInstructors);
        spGradeInstructor.setAdapter(gradesInstructor);
    }

    private boolean getExperience() {
        return rbExperience.isChecked();
    }


    public void onNewViewActivity(View v) {
        Postulant postulant = new Postulant();
        postulant.setName(edtName.getText().toString());
        postulant.setLastName(edtLastName.getText().toString());
        postulant.setAge(Integer.parseInt(edtAge.getText().toString()));
        postulant.setExperience(getExperience());
        postulant.setGradeInstructor((GradeInstructor) spGradeInstructor.getSelectedItem());
//        Toast.makeText(this,postulant.toString(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity2.class);
//        Bundle bundle = new Bundle();
        intent.putExtra("data_postulant", postulant);
        startActivity(intent);
        finish();

    }
}