package ca.gbc.midterm_henrique_custodio.ui.theme.controller;

import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import android.content.DialogInterface;

import ca.gbc.midterm_henrique_custodio.ui.theme.SecondActivity;
import ca.gbc.midterm_henrique_custodio.ui.theme.cache.DataCache;
import androidx.appcompat.app.AlertDialog;


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
            return;
        }

        int num;

        try {
            num = Integer.parseInt(numText);
        } catch (NumberFormatException e) {
            Toast.makeText(context, "Invalid Number", Toast.LENGTH_SHORT).show();
            return;
        }

        generateTable(num);
        tableAdapter.notifyDataSetChanged();
    }

    public void generateTable(int num) {
        DataCache.currentTable.clear();
        for (int i = 1; i <= 10; i++) {
            int result = num * i;
            String row = num + " x " + i + " = " + result;
            DataCache.currentTable.add(row);
        }

        if (!DataCache.history.contains(num)) {
            DataCache.history.add(String.valueOf(num));
        }
    }

    public void onRowSelected(int pos) {
        final String selectedRow = DataCache.currentTable.get(pos);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Row");
        builder.setMessage("Delete this row?\n" + selectedRow);

        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                DataCache.currentTable.remove(pos);
                tableAdapter.notifyDataSetChanged();

                Toast.makeText(context,
                        "Deleted: " + selectedRow,
                        Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    public void onHistoryClicked() {
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);

    }
}
