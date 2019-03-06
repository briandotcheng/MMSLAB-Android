package bluenet.com.lab8;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText ed_name, ed_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ed_name = findViewById(R.id.ed_name);
        ed_phone = findViewById(R.id.ed_phone);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_name.length()<1)
                    Toast.makeText(Main2Activity.this,"請輸入姓名",Toast.LENGTH_SHORT).show();
                else if(ed_phone.length()<1)
                    Toast.makeText(Main2Activity.this,"請輸入電話",Toast.LENGTH_SHORT).show();
                else{
                    Bundle b = new Bundle();
                    b.putString("name", ed_name.getText().toString());
                    b.putString("phone", ed_phone.getText().toString());
                    setResult(Activity.RESULT_OK, new Intent().putExtras(b));
                    finish();
                }
            }
        });
    }
}
