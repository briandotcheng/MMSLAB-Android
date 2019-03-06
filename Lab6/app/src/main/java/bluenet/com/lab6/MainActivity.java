package bluenet.com.lab6;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] list_item = {"項目1", "項目2", "項目3", "項目4", "項目5"};

        findViewById(R.id.btn_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"預設Toast", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActivity.this);
                toast.setGravity(Gravity.TOP, 0, 50);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(MainActivity.this.getLayoutInflater().inflate(R.layout.toast_custom,null));
                toast.show();
            }
        });

        findViewById(R.id.btn_dialog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("按鍵式對話框")
                        .setMessage("對話框內容")
                        .setNeutralButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"取消", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("拒絕", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"拒絕", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"確定", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        findViewById(R.id.btn_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("列表式對話框")
                        .setItems(list_item, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"你選的是" + list_item[which], Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        findViewById(R.id.btn_dialog3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] position = {0};

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("單選式對話框")
                        .setSingleChoiceItems(list_item, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                position[0] = which;
                            }
                        })
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"你選的是" + list_item[position[0]], Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }
}
