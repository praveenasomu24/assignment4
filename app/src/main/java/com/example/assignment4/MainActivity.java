package com.example.assignment4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText noteInput;
    Button saveButton, logoutButton;
    TextView displayNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteInput = findViewById(R.id.noteInput);
        saveButton = findViewById(R.id.saveButton);
        logoutButton = findViewById(R.id.logoutButton);
        displayNote = findViewById(R.id.displayNote);

        saveButton.setOnClickListener(v -> {
            String note = noteInput.getText().toString();

            if (note.isEmpty()) {
                Toast.makeText(this, "Please enter a note", Toast.LENGTH_SHORT).show();
            } else {
                displayNote.setText("Saved Note:\n" + note);
                noteInput.setText("");
                Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
            }
        });

        logoutButton.setOnClickListener(v -> {
            finish();
        });
    }
}