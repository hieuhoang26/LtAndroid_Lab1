package com.example.lab1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Toolbar toolbar;
    private EditText edtHoTen, edtSoDienThoai;
    private RadioGroup radioGroupGender;
    private RadioButton radioMale, radioFemale;
    private CheckBox chkHobby1, chkHobby2, chkHobby3, chkHobby4;
    private Spinner spin;
    private Button btnAddToListView;
    private ListView listView;

    private ArrayAdapter<String> adapter;

    //    private  String selectCity;
//    String[] cities = {"Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Hải Phòng"};
    private ArrayList<String> infoList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        chkHobby1 = findViewById(R.id.chkHobby1);
        chkHobby2 = findViewById(R.id.chkHobby2);
        chkHobby3 = findViewById(R.id.chkHobby3);
        chkHobby4 = findViewById(R.id.chkHobby4);
        spin = findViewById(R.id.spinnerCity);
        btnAddToListView = findViewById(R.id.btnAddToListView);
        listView = findViewById(R.id.listView);
//toolbar
        toolbar.setTitle("HoangHuyHieu_IT1");
//spin
//        spin.setOnItemSelectedListener(this);
//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cities);
//        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spin.setAdapter(ad);
//listview
        adapter = new ArrayAdapter<String>(this,
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                infoList);
        listView.setAdapter(adapter);
//add user
        btnAddToListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToListView();
            }
        });
    }

    private void addToListView() {
        String hoTen = edtHoTen.getText().toString();
        String soDienThoai = edtSoDienThoai.getText().toString();
        String gioiTinh = "";
        if(!radioFemale.isChecked() && !radioMale.isChecked()){
            Toast.makeText(this, "Lựa chọn Giới tính", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            if (radioMale.isChecked()) {
                gioiTinh += radioMale.getText().toString();
            }
            if (radioFemale.isChecked()) {
                gioiTinh += radioFemale.getText().toString();
            }
        }

        String hobby = "";
        if (chkHobby1.isChecked()) {
            hobby += chkHobby1.getText().toString();
        }
        if (chkHobby2.isChecked()) {
            hobby += chkHobby2.getText().toString();
        }
        if (chkHobby3.isChecked()) {
            hobby += chkHobby3.getText().toString();
        }
        if (chkHobby4.isChecked()) {
            hobby += chkHobby4.getText().toString();
        }
        String selectCity = "";
        if(spin.getSelectedItem().toString().equals("Quê Quán")){
            Toast.makeText(this, "Lựa chọn thành phố", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            selectCity += spin.getSelectedItem().toString();
        }

        String info = hoTen + "  " + gioiTinh + "  " + soDienThoai + "  " + selectCity + "  " + hobby;
        if (info.replaceAll("\\s", "").equals("")) {
            Toast.makeText(this, "Nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        } else {
            //add vào list
            infoList.add(info);
        }

//update lại listview
        adapter.notifyDataSetChanged();
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Đã thêm vào ListView", Toast.LENGTH_SHORT).show();
        ResetEdit();
    }

    private void ResetEdit() {
        edtHoTen.setText("");
        edtSoDienThoai.setText("");
        radioGroupGender.clearCheck();
        chkHobby1.setChecked(false);
        chkHobby2.setChecked(false);
        spin.setSelection(0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        selectCity= cities[position];

//        Toast.makeText(getApplicationContext(),
//                        cities[position],
//                        Toast.LENGTH_LONG)
//                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}