package bluenet.com.lab7;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
//Implement ViewHolder
public class MyAdapter2 extends BaseAdapter {
    private ArrayList<Item> data;
    private int layout;

    private class ViewHolder{
        private ImageView img_photo;
        private TextView tv_name;
    }

    MyAdapter2(int layout, ArrayList<Item> data){
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
        ViewHolder holder;

        if(convertView==null){
            convertView = View.inflate(parent.getContext(), layout, null);
            holder = new ViewHolder();
            convertView.setTag(holder);

            holder.img_photo = convertView.findViewById(R.id.img_photo);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
        }else
            holder = (ViewHolder)convertView.getTag();

        holder.img_photo.setImageResource(data.get(position).photo);
        holder.tv_name.setText(data.get(position).name);

        return convertView;
    }
}
