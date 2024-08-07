package com.example.weatherapp;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridViewDemo extends AppCompatActivity {

    GridView gridView;
    String[] courses={"mobile programming","Python","DSA","React","Devops"};
    int [] itemImages={R.drawable.wind,R.drawable.humidity,R.drawable.ic_launcher_foreground,R.drawable.humidity,R.drawable.wind};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view_demo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView=findViewById(R.id.gridId);

        CustomGridAdapter adapter=new CustomGridAdapter(GridViewDemo.this,courses,itemImages);
        gridView.setAdapter(adapter);

    }
}