package com.example.projek6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projek6.R;

public class MainActivity extends AppCompatActivity {

    EditText edtPhone;
    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhone = findViewById(R.id.edtPhone);
        btnAlert = findViewById(R.id.btnAlert);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nomor = edtPhone.getText().toString();

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Alert");
                alert.setMessage("No Telp School anda " + nomor +
                        ". Klik OK jika sudah benar, atau Cancel jika salah.");

                alert.setPositiveButton("OK", (dialog, which) ->
                        Toast.makeText(MainActivity.this, "Nomor benar", Toast.LENGTH_SHORT).show());

                alert.setNegativeButton("Cancel", (dialog, which) ->
                        Toast.makeText(MainActivity.this, "Dibatalkan", Toast.LENGTH_SHORT).show());

                alert.show();
            }
        });
    }
}
