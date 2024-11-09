package com.uniku.gaji;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNama;
    private CheckBox checkBoxMenikah;
    private RadioGroup radioGroupGolongan;
    private Button buttonHitung;
    private TextView textGajiPokok, textTunjangan, textTotalGaji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = findViewById(R.id.editTextNama);
        checkBoxMenikah = findViewById(R.id.checkBoxMenikah);
        radioGroupGolongan = findViewById(R.id.radioGroupGolongan);
        buttonHitung = findViewById(R.id.buttonHitung);
        textGajiPokok = findViewById(R.id.textGajiPokok);
        textTunjangan = findViewById(R.id.textTunjangan);
        textTotalGaji = findViewById(R.id.textTotalGaji);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSalary();
            }
        });
    }

    private void calculateSalary() {
        String nama = editTextNama.getText().toString().trim();
        boolean isMenikah = checkBoxMenikah.isChecked();
        int selectedGolonganId = radioGroupGolongan.getCheckedRadioButtonId();

        if (nama.isEmpty()) {
            Toast.makeText(this, "Masukkan nama Anda", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedGolonganId == -1) {
            Toast.makeText(this, "Pilih golongan", Toast.LENGTH_SHORT).show();
            return;
        }

        double gajiPokok;
        double tunjangan = 0;

        if (selectedGolonganId == R.id.radioGolongan1) {
            gajiPokok = 5000000;
        } else { // Golongan 2
            gajiPokok = 7000000;
        }

        // Tunjangan jika menikah
        if (isMenikah) {
            tunjangan = 1000000;
        }

        double totalGaji = gajiPokok + tunjangan;

        // Menampilkan hasil
        textGajiPokok.setText("Gaji Pokok: Rp " + gajiPokok);
        textTunjangan.setText("Tunjangan: Rp " + tunjangan);
        textTotalGaji.setText("Total Gaji: Rp " + totalGaji);
    }
}
