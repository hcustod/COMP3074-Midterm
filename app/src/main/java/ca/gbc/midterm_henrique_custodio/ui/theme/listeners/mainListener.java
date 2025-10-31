package ca.gbc.midterm_henrique_custodio.ui.theme.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import ca.gbc.midterm_henrique_custodio.ui.theme.controller.MainController;


public class mainListener {

    public static void bind(
            Button btnGenerate,
            Button btnHistory,
            ListView listTable,
            MainController controller
    ) {

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onGenerateClicked();
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onHistoryClicked();
            }
        });

        listTable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemView, int pos, long id) {
                controller.onRowSelected(pos);
            }
        });
    }
}
