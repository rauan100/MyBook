package rauan.ferreira.mybook;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BookHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView title;
    public TextView authors;
    public TextView status;
    public ImageButton editBook;

    public BookHolder(View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.book_name_list);
        this.title = itemView.findViewById(R.id.book_title_list);
        this.authors = itemView.findViewById(R.id.book_authors_list);
        this.status = itemView.findViewById(R.id.book_status_list);
        this.editBook = itemView.findViewById(R.id.editBook);
    }
}
