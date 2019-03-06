package bluenet.com.lab4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText ed_drink;
    private RadioGroup radioGroup, radioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ed_drink = findViewById(R.id.ed_drink);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup2 = findViewById(R.id.radioGroup2);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_drink.length()<1)
                    Toast.makeText(Main2Activity.this, "請輸入飲料名稱", Toast.LENGTH_SHORT).show();
                else{
                    Bundle b = new Bundle();
                    b.putString("drink", ed_drink.getText().toString());
                    b.putString("sugar", ((RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString());
                    b.putString("ice", ((RadioButton)radioGroup2.findViewById(radioGroup2.getCheckedRadioButtonId())).getText().toString());
                    setResult(Activity.RESULT_OK, new Intent().putExtras(b));
                    finish();
                }
            }
        });
    }
}
