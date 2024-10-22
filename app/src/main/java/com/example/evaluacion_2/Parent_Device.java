package com.example.evaluacion_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Parent_Device extends AppCompatActivity {

    private EditText NameDeviceInput, keyInput;
    private Button RegisterDeviceBtn, ExitBtn;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_device);

        //Catch ID XML to parent_device

        NameDeviceInput = findViewById(R.id.NameDeviceInput);
        keyInput = findViewById(R.id.ClaveInput);
        RegisterDeviceBtn = findViewById(R.id.RegisterDeviceBtn);
        ExitBtn = findViewById(R.id.ExitBtn);

        RegisterDeviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deviceName = NameDeviceInput.getText().toString().trim();
                String deviceKey = keyInput.getText().toString().trim();

                if (!deviceName.isEmpty() && !deviceKey.isEmpty()) {
                    // Validar que la clave sea alfanumérica
                    if (deviceKey.matches("[a-zA-Z0-9]+")) {
                        registerDevice(deviceName, deviceKey);
                    } else {
                        Toast.makeText(Parent_Device.this, "La clave debe ser alfanumérica", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Parent_Device.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exit = new Intent(Parent_Device.this, Inicio.class);
                finish();
            }
        });


    }


    private void registerDevice(String deviceName, String deviceKey) {


        Toast.makeText(this, "Dispositivo registrado: " + deviceName, Toast.LENGTH_SHORT).show();


    }
}