package bluenet.com.lab7;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private GridView gridview;

    private ListView listView;
    private ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        gridview = findViewById(R.id.gridview);
        listView = findViewById(R.id.listView);

        TypedArray array = getResources().obtainTypedArray(R.array.resourceList);
        for(int i=0;i<array.length();i++) {
            Item item  = new Item();
            item.photo = array.getResourceId(i,0);
            item.name = "水果"+(i+1);
            items.add(item);
        }
        array.recycle();

        spinner.setAdapter(new MyAdapter(R.layout.adapter_horizontal, items));

        gridview.setNumColumns(3);
        gridview.setAdapter(new MyAdapter(R.layout.adapter_vertical, items));

        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                new String[]{"項目1","項目2","項目3","項目4","項目5","項目6","項目7","項目8","項目9"}));
    }
}

class Item{
    int photo;
    String name;
}