package bluenet.com.lab7;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<Item> data;
    private int layout;

    MyAdapter(int layout, ArrayList<Item> data){
        this.layout = layout;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(parent.getContext(), layout, null);

        ImageView img_photo = convertView.findViewById(R.id.img_photo);
        TextView tv_name = convertView.findViewById(R.id.tv_name);

        img_photo.setImageResource(data.get(position).photo);
        tv_name.setText(data.get(position).name);

        return convertView;
    }
}
