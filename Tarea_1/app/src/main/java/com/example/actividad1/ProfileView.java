package com.example.actividad1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actividad1.databinding.ActivityProfileBinding;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProfileView extends AppCompatActivity {
    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validationonAndSave();
            }
        });
    }

    private void validationonAndSave() {

        AtomicBoolean validated = new AtomicBoolean(true);
        if (binding.textName.getText().toString().isEmpty() || binding.textName.getText() == null){
            binding.textName.setError("Inserte su nombre.");
            validated.set(false);
        }

        if (binding.textMatricula.getText().toString().isEmpty() || binding.textName.getText() == null){
            binding.textMatricula.setError("Inserte su matricula.");
            validated.set(false);
        }

        if (binding.SpinnerCarrera.getSelectedItem() == null){
            binding.textMatricula.setError("Elija una carrera");
            validated.set(false);
        }

        if (validated.get()){
            Toast.makeText(this, "Informacion Guardada", Toast.LENGTH_LONG).show();

            // Crear el Intent para abrir la pantalla ResumenPerfil
            Intent intent = new Intent(ProfileView.this, ResumenPerfil.class);
            startActivity(intent);
        }
    }
}