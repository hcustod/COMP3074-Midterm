package ca.gbc.midterm_henrique_custodio.ui.theme.controller;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class MainController {

    private final Context context;
    private final EditText editNumber;
    private final ArrayAdapter<String> tableAdapter;

    public MainController(Context context, EditText num, ArrayAdapter<String> tableAdapter) {
        this.context = context;
        this.editNumber = num;
        this.tableAdapter = tableAdapter;
    }


    public void onGenerateClicked() {
        String numText = editNumber.getText().toString().trim();

        if (numText.isEmpty()) {
            Toast.makeText(context, "Enter a number", Toast.LENGTH_SHORT).show();
        }

        int num;

        try {
            num = Integer.parseInt(numText);
        } catch (NumberFormatException e) {
            Toast.makeText(context, "Invalid Number", Toast.LENGTH_SHORT).show();
        }

        // gen table here
    }

    public void generateTable(int num) {

    }

    public void onRowSelected(int pos) {

    }

    public void onHistoryClicked() {

    }

    public void onClearAllRequested() {

    }
}
