package com.example.sanbotapp.juegos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.sanbotapp.BaseActivity;
import com.example.sanbotapp.R;
import com.example.sanbotapp.util.RobotLed;

public class FinBuscaEncuentraActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_busca_encuentra);
        setupTopBackBanner("Busca y Encuentra");

        long segundos = getIntent().getLongExtra("SEGUNDOS", 0);

        TextView tvRobot = findViewById(R.id.tvBocadilloTexto);
        if (tvRobot != null) {
            if (segundos < 3) {
                mostrarEmocion("SURPRISE");
                encenderLed(RobotLed.PART_ALL, RobotLed.MODE_GREEN);
                tvRobot.setText("¡Increíble! Lo has encontrado en un abrir y cerrar de ojos.");
                hablarOSimular("¡Increíble! Lo has encontrado en un abrir y cerrar de ojos.");
            } else if (segundos < 10) {
                mostrarEmocion("PRISE");
                encenderLed(RobotLed.PART_ALL, RobotLed.MODE_GREEN);
                tvRobot.setText("¡Con tu ayuda lo he encontrado! ¡Eres increíble!");
                hablarOSimular("¡Con tu ayuda lo he encontrado! ¡Eres increíble!");
            } else {
                mostrarEmocion("SMILE");
                encenderLed(RobotLed.PART_ALL, RobotLed.MODE_GREEN);
                tvRobot.setText("¡Lo has conseguido! La memoria es como un músculo, ¡a seguir entrenando!");
                hablarOSimular("¡Lo has conseguido! La memoria es como un músculo, ¡a seguir entrenando!");
            }
        }

        TextView tvTiempo = findViewById(R.id.tvTiempoBusca);
        if (tvTiempo != null) {
            tvTiempo.setText(segundos + " s");
        }

        findViewById(R.id.btnJugarOtraVez).setOnClickListener(v -> {
            startActivity(new Intent(this, JuegoBuscaEncuentraActivity.class));
            finish();
        });

        findViewById(R.id.btnVolverMenu).setOnClickListener(v -> {
            startActivity(new Intent(this, JuegosActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();
        });
    }
}