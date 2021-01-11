package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyCounterActivity extends Activity implements View.OnClickListener {


    //Widgets:
    private EditText titleText;
    private EditText descText;
    private Button  deleteBtn;
    private long _id;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Record");
        setContentView(R.layout.activity_modify_counter);

        dbManager = new DBManager(this);
        dbManager.open();

        titleText = findViewById(R.id.subject_edittext);
        descText = findViewById(R.id.description_edittext);
        deleteBtn = findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");

        _id = Long.parseLong(id);
        titleText.setText(name);
        descText.setText(desc);
        deleteBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_delete:
                dbManager.delete(_id);
                this.returnHome();
                break;

        }

    }

    public void returnHome(){
        Intent home_intent = new Intent(getApplicationContext(),
                CountryListActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }




}