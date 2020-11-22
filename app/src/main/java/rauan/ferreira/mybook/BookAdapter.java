package rauan.ferreira.mybook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class BookAdapter extends RecyclerView.Adapter<BookHolder> {

    private FragmentActivity context;

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.book, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, final int position) {

        holder.name.setText(DAO.books.get(position).name);
        holder.title.setText(DAO.books.get(position).title);
        holder.authors.setText(DAO.books.get(position).authors);
        holder.status.setText(DAO.books.get(position).status);
        holder.editBook.setOnClickListener((view) -> {
            editBook(position);
        });
        holder.deleteBook.setOnClickListener(view -> {
            deleteBook(position);
        });
    }

    @Override
    public int getItemCount() {
        return DAO.books.size();
    }

    private void editBook(int position) {
        final Intent book = new Intent(context, BookFormActivity.class);
        book.putExtra("position", position);
        context.startActivity(book);
    }

    private void deleteBook(int position) {
        try {
            Book book = DAO.books.get(position);

            DAO.deleteBook(book);

            Toast toast = Toast.makeText(context, "Livro removido com sucesso", Toast.LENGTH_LONG);

            toast.show();
        } catch (Exception e) {
            Toast toast = Toast.makeText(context, "Erro ao remover livro", Toast.LENGTH_LONG);

            toast.show();
        }
    }

    public void setContext(FragmentActivity context) {
        this.context = context;
    }
}
