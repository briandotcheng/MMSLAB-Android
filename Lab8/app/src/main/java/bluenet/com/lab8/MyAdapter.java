package bluenet.com.lab8;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Contact> contacts;

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name, tv_phone;
        private ImageView img_delete;

        ViewHolder(View v){
            super(v);
            tv_name = v.findViewById(R.id.tv_name);
            tv_phone = v.findViewById(R.id.tv_phone);
            img_delete = v.findViewById(R.id.img_delete);
        }
    }

    MyAdapter(ArrayList<Contact> contacts){
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_name.setText(contacts.get(position).name);
        holder.tv_phone.setText(contacts.get(position).phone);

        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
