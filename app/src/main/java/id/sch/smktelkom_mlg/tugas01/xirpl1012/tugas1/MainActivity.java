package id.sch.smktelkom_mlg.tugas01.xirpl1012.tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

      EditText etNama, etTahun;
      RadioGroup rgJk;
      Spinner spAsal;
      CheckBox cbV, cbB, cbF, cbPS;
      Button bOk;
      TextView tvHasil;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etNama = (EditText) findViewById(R.id.editTextNama);
            etTahun = (EditText) findViewById(R.id.editTextTahun);
            rgJk = (RadioGroup) findViewById(R.id.radioGroupJK);
            spAsal = (Spinner) findViewById(R.id.spinnerAsal);
            cbV = (CheckBox) findViewById(R.id.checkBoxV);
            cbB = (CheckBox) findViewById(R.id.checkBoxB);
            cbF = (CheckBox) findViewById(R.id.checkBoxF);
            cbPS = (CheckBox) findViewById(R.id.checkBoxPS);
            bOk = (Button) findViewById(R.id.buttonOK);
            tvHasil = (TextView) findViewById(R.id.textViewHasil);
      }
}
