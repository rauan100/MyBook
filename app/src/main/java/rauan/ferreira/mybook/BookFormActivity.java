package rauan.ferreira.mybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class BookFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_form);

        Intent intent = getIntent();

        final Integer bookId = intent.getIntExtra("position", -1);

        TextView nameView = findViewById(R.id.book_name);
        TextView titleView = findViewById(R.id.book_title);
        TextView authorsView = findViewById(R.id.book_authors);
        Spinner statusView = findViewById(R.id.book_status);

        ArrayList<String> statuses = new ArrayList<String>();

        statuses.add("Não iniciado");
        statuses.add("Em leitura");
        statuses.add("Finalizado");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, statuses);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusView.setAdapter(arrayAdapter);

        Button btnSave = findViewById(R.id.bookSave);

        btnSave.setOnClickListener(view -> {
            String name = nameView.getText().toString();
            String title = titleView.getText().toString();
            String authors = authorsView.getText().toString();
            String status = statusView.getSelectedItem().toString();

            System.out.println(name);
            System.out.println(title);
            System.out.println(authors);
            System.out.println(status);
        });

        if (bookId > -1) {
            System.out.println("Hello world");
            loadBook(bookId);
        }
    }

    private void loadBook(int position) {

    }
}