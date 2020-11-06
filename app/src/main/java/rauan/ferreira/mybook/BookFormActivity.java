package rauan.ferreira.mybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookFormActivity extends AppCompatActivity {

    TextView nameView = null;
    TextView titleView = null;
    TextView authorsView = null;
    Spinner statusView = null;
    ArrayList<String> statuses = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_form);

        Intent intent = getIntent();

        final Integer bookId = intent.getIntExtra("position", -1);

        nameView = findViewById(R.id.book_name);
        titleView = findViewById(R.id.book_title);
        authorsView = findViewById(R.id.book_authors);
        statusView = findViewById(R.id.book_status);

        if (bookId > -1) {
            nameView.setEnabled(false);
        }

        statuses = new ArrayList<String>();

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

            Book book = new Book(name, title, authors, status);

            if (bookId > -1) {
                DAO.updateBook(book);
            } else {
                DAO.addBook(book);
            }

            Toast toast = Toast.makeText(this, "Livro adicionado/atualizado com sucesso", Toast.LENGTH_SHORT);

            toast.show();

            finish();
        });

        if (bookId > -1) {
            loadBook(bookId);
        }
    }

    private void loadBook(int position) {
        Book book = DAO.books.get(position);

        nameView.setText(book.name);
        titleView.setText(book.title);
        authorsView.setText(book.authors);
        statusView.setSelection(statuses.indexOf(book.status));
    }
}