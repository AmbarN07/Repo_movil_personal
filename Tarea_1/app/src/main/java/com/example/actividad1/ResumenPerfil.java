package com.example.actividad1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.actividad1.databinding.ActivityResumenPerfilBinding;

public class ResumenPerfil extends AppCompatActivity {
    @NonNull ActivityResumenPerfilBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumen_perfil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityResumenPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String nombre = getIntent().getStringExtra("extra_nombre");
        String matricula = getIntent().getStringExtra("extra_matricula");
        String carrera = getIntent().getStringExtra("extra_carrera");

        if (nombre != null) {
            binding.ResumenNameText.setText(nombre);
            binding.lableBienvenida.setText("¡Hola, " + nombre + "!");
        }

        if (matricula != null) {
            binding.ResumenMatriculaText.setText(matricula);
        }

        if (carrera != null) {
            binding.ResumenCarreraText.setText(carrera);
        }

    }
}