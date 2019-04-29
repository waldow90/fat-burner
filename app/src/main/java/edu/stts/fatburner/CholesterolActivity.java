package edu.stts.fatburner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import edu.stts.fatburner.classObject.User;

public class CholesterolActivity extends AppCompatActivity {
    private ImageButton btnNextCholes;
    private EditText et;
    private User userBaru;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cholesterol);
        btnNextCholes = findViewById(R.id.btnNextCholes);
        et = findViewById(R.id.editText);
        userBaru = (User)getIntent().getSerializableExtra("userBaru");
    }

    public void nextCholes(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.btnNextCholes:
                double cholesterol = Double.parseDouble(et.getText().toString());
                userBaru.setCholesterol(cholesterol);
                intent = new Intent(this,EndRegisterActivity.class);
                intent.putExtra("userBaru",userBaru);
                break;
        }
        if (intent != null) startActivity(intent);
    }
}
