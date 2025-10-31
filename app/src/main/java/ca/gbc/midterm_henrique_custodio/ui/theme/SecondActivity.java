package ca.gbc.midterm_henrique_custodio.ui.theme;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import ca.gbc.midterm_henrique_custodio.ui.theme.cache.DataCache;
import androidx.appcompat.app.AppCompatActivity;
import ca.gbc.midterm_henrique_custodio.R;


public class SecondActivity extends AppCompatActivity {

    private ListView listHistory;
    private ArrayAdapter<String> historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("History");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listHistory = findViewById(R.id.listHistory);

        ArrayList<String> historyStrings = new ArrayList<>();
        for (String n : DataCache.history) {
            historyStrings.add(String.valueOf(n));
        }

        historyAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                historyStrings
        );

        listHistory.setAdapter(historyAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
