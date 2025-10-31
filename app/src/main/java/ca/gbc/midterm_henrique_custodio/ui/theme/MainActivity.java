package ca.gbc.midterm_henrique_custodio.ui.theme;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.*;

import androidx.appcompat.app.AppCompatActivity;
import ca.gbc.midterm_henrique_custodio.R;

import ca.gbc.midterm_henrique_custodio.ui.theme.cache.DataCache;
import ca.gbc.midterm_henrique_custodio.ui.theme.controller.MainController;
import ca.gbc.midterm_henrique_custodio.ui.theme.listeners.mainListener;

public class MainActivity extends AppCompatActivity {
    private EditText editNumber;
    private Button btnGenerate;
    private Button btnHistory;
    private ListView listTable;

    private ArrayAdapter<String> tableAdapter;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startViews();
        startAdapter();
        startController();
        startListeners();
    }

    private void startViews() {
        editNumber = findViewById(R.id.editNumber);
        btnGenerate = findViewById(R.id.btnGenerate);
        btnHistory = findViewById(R.id.btnHistory);
        listTable = findViewById(R.id.listTable);
    }

    private void startAdapter() {
        tableAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                DataCache.currentTable
        );
        listTable.setAdapter(tableAdapter);
    }

    private void startController() {
        controller = new MainController(
                this,
                editNumber,
                tableAdapter
        );
    }

    private void startListeners() {
        mainListener.bind(btnGenerate, btnHistory, listTable, controller);
    }

}
