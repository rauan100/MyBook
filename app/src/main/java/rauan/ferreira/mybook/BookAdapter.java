package rauan.ferreira.mybook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

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

        holder.name.setText("Teste 1");
        holder.title.setText("Teste 2");
        holder.authors.setText("Rauan, Teste");
        holder.status.setText("Não lido");
        holder.editBook.setOnClickListener((view) -> {
            editBook(position);
        });
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    private void editBook(int position) {
        final Intent book = new Intent(context, BookFormActivity.class);
        book.putExtra("position", position);
        context.startActivity(book);
    }

    public void setContext(FragmentActivity context) {
        this.context = context;
    }
}
