package com.example.cozycupscafe;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridActivity extends AppCompatActivity {

    private ImageView fullSizeImageView;


    private final int[] offeringImages = {
            R.drawable.americano, R.drawable.cappucino, R.drawable.mocha,
            R.drawable.latte, R.drawable.espresso, R.drawable.iced_coffee,
            R.drawable.flat_white, R.drawable.macchiato, R.drawable.irish
    };
    private final String[] offeringTypes = {
            "Americano", "Cappuccino", "Mocha",
            "Latte", "Espresso", "Iced Coffee",
            "Flat White", "Macchiato", "Irish"
    };
    private final String[] offeringCosts = {
            "R30.00", "R40.00", "R40.50",
            "R42.00", "R35.50", "R48.00",
            "R50.50", "R41.75", "R55.00"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        GridView gridView = findViewById(R.id.gridView);
        fullSizeImageView = findViewById(R.id.fullSizeImageView);


        GridAdapter adapter = new GridAdapter(this, offeringImages);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener((parent, view, position, id) -> {

            fullSizeImageView.setImageResource(offeringImages[position]);
            fullSizeImageView.setVisibility(View.VISIBLE);


            String message = "Type: " + offeringTypes[position] +
                    "\nCost: " + offeringCosts[position] +
                    "\nItem Number: " + (position + 1);
            Toast.makeText(GridActivity.this, message, Toast.LENGTH_SHORT).show();
        });
    }
}

