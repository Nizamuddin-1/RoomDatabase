package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText editTitle,editAmount;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editAmount=findViewById(R.id.ed2);
        editTitle=findViewById(R.id.ed1);
        button=findViewById(R.id.button);
        DatabaseHelper databaseHelper=DatabaseHelper.getdb(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=editTitle.getText().toString();
                String amount=editAmount.getText().toString();
                databaseHelper.expenseDao().addTx(new Expense(title,amount));
                ArrayList<Expense> arrayList=(ArrayList<Expense>) databaseHelper.expenseDao().getExpense();
            }
        });
    }
}