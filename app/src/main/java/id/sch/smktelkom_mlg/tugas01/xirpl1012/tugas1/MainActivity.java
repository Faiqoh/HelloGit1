package id.sch.smktelkom_mlg.tugas01.xirpl1012.tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import static id.sch.smktelkom_mlg.tugas01.xirpl1012.tugas1.R.id.rgJK;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

      EditText etNama, etTahun;
      RadioGroup rgJk;
      Spinner spProvinsi, spKota;
      CheckBox cbV, cbB, cbF, cbPS;
      Button bOk;
      TextView tvHasil, tvHasil2, tvHasil3, tvHasil4;
      int nEkskul;

      String[][] arKota = {{"Jakarta Barat", "Jakarta Timur", "Jakarta Selatan",
              "Jakarta Pusat", "Jakarta Utara"}, {"Bandung", "Cirebon", "Bekasi"}, {"Semarang", "Magelang", "Surakarta"}, {"Surabaya", "Malang", "Blitar"}, {"Denpasar"}};
      ArrayList<String> listKota = new ArrayList<>();
      ArrayAdapter<String> adapter;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etNama = (EditText) findViewById(R.id.editTextNama);
            etTahun = (EditText) findViewById(R.id.editTextTahun);
            rgJk = (RadioGroup) findViewById(rgJK);
            spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
            spKota = (Spinner) findViewById(R.id.spinnerKota);
            cbV = (CheckBox) findViewById(R.id.checkBoxV);
            cbB = (CheckBox) findViewById(R.id.checkBoxB);
            cbF = (CheckBox) findViewById(R.id.checkBoxF);
            cbPS = (CheckBox) findViewById(R.id.checkBoxPS);
            cbV.setOnCheckedChangeListener(this);
            cbB.setOnCheckedChangeListener(this);
            cbF.setOnCheckedChangeListener(this);
            cbPS.setOnCheckedChangeListener(this);
            bOk = (Button) findViewById(R.id.buttonOK);
            tvHasil = (TextView) findViewById(R.id.textViewHasil);
            tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
            tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
            tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listKota);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spKota.setAdapter(adapter);

            spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                  @Override
                  public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        listKota.clear();
                        listKota.addAll(Arrays.asList(arKota[pos]));
                        adapter.notifyDataSetChanged();
                        spKota.setSelection(0);
                  }

                  @Override
                  public void onNothingSelected(AdapterView<?> adapterView) {
                  }
            });

            findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        doClick();
                  }
            });
      }

      private void doClick() {
            if (isValid()) {
                  String nama = etNama.getText().toString();
                  String tahun = etTahun.getText().toString();
                  String hasil = null;
                  String hasil2 = "Ekskul yang dipilih :";
                  int startlen = hasil2.length();

                  tvHasil.setText("Nama                       :" + nama + "\nTahun lahir              :" + tahun);
                  tvHasil2.setText("Asal                          :" + "Kota " + spKota.getSelectedItem().toString() + ", "
                          + spProvinsi.getSelectedItem().toString());
                  if (rgJk.getCheckedRadioButtonId() != -1) {
                        RadioButton rb = (RadioButton)
                                findViewById(rgJk.getCheckedRadioButtonId());
                        hasil = rb.getText().toString();
                  }
                  if (hasil == null) {
                        tvHasil3.setText("Jenis Kelamin          :Anda belum memilih jenis kelamin");
                  } else {
                        tvHasil3.setText("Jenis Kelamin         :" + hasil);
                  }

                  if (cbV.isChecked()) hasil2 += cbV.getText() + ", ";
                  if (cbB.isChecked()) hasil2 += cbB.getText() + ", ";
                  if (cbF.isChecked()) hasil2 += cbF.getText() + ", ";
                  if (cbPS.isChecked()) hasil2 += cbPS.getText() + ".";

                  if (hasil2.length() == startlen) hasil2 += "Tidak ada pada pilihan";
                  tvHasil4.setText(hasil2);
            }
      }

      private boolean isValid() {
            boolean valid = true;
            String nama = etNama.getText().toString();
            String tahun = etTahun.getText().toString();
            TextView jk = (TextView) findViewById(R.id.textView5);
            TextView eks = (TextView) findViewById(R.id.textView7);

            if (nama.isEmpty()) {
                  etNama.setError("Nama Belum diisi");
                  valid = false;
            }
            if (tahun.isEmpty()) {
                  etTahun.setError("Tahun Belum diisi");
                  valid = false;
            }
            if (rgJk.getCheckedRadioButtonId() <= 0) {
                  jk.setError("Belum memilih jenis kelamin");
                  valid = false;
            } else {
                  jk.setError(null);
            }
            if (cbB.isChecked() || cbF.isChecked() || cbPS.isChecked() || cbV.isChecked()) {
                  valid = true;
                  eks.setError(null);
            } else {
                  eks.setError("Belum memilih kelas");
                  valid = false;
            }
            return valid;
      }

      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) nEkskul += 1;
            else nEkskul -= 1;
      }
}
