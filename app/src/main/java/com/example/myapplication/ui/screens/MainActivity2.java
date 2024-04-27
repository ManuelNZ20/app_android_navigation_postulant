package com.example.myapplication.ui.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.domain.entities.Person;
import com.example.myapplication.domain.entities.Postulant;
import com.example.myapplication.infrastructure.models.PostulantModel;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtvResultsPerson,txtvResultsScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtvResultsPerson = (TextView) findViewById(R.id.txtvResultsData);
        txtvResultsScore = (TextView) findViewById(R.id.txtvResultScore);

        Intent intentPerson = getIntent();
        Postulant dataPostulant = (Postulant) intentPerson.getSerializableExtra("data_postulant");
        PostulantModel postulantModel = new PostulantModel(dataPostulant);
        txtvResultsPerson.setText(postulantModel.dataViewResults());
        txtvResultsScore.setText(postulantModel.dataViewTotalScore());
    }

    public void onReturnMain(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}