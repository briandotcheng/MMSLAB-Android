package bluenet.com.lab9_2;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ed_height, ed_weight;
    private RadioButton btn_boy;
    private TextView tv_weight, tv_bmi, tv_progress;
    private LinearLayout ll_progress;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_height = findViewById(R.id.ed_height);
        ed_weight = findViewById(R.id.ed_weight);
        btn_boy = findViewById(R.id.btn_boy);
        tv_weight = findViewById(R.id.tv_weight);
        tv_bmi = findViewById(R.id.tv_bmi);
        tv_progress = findViewById(R.id.tv_progress);
        ll_progress = findViewById(R.id.ll_progress);
        progressBar2 = findViewById(R.id.progressBar2);

        findViewById(R.id.btn_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_height.length()<1)
                    Toast.makeText(MainActivity.this,"請輸入身高", Toast.LENGTH_SHORT).show();
                else if(ed_weight.length()<1)
                    Toast.makeText(MainActivity.this,"請輸入身高", Toast.LENGTH_SHORT).show();
                else
                    runAsyncTask();
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private void runAsyncTask(){
        new AsyncTask<Void, Integer, Boolean>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                tv_weight.setText("標準體重\n無");
                tv_bmi.setText("體脂肪\n無");

                progressBar2.setProgress(0);
                tv_progress.setText("0%");
                ll_progress.setVisibility(View.VISIBLE);
            }

            @Override
            protected Boolean doInBackground(Void... voids) {
                int progress = 0;
                while (progress <= 100){
                    try {
                        Thread.sleep(50);
                        publishProgress(progress);
                        progress++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar2.setProgress(values[0]);
                tv_progress.setText(values[0] + "%");
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                ll_progress.setVisibility(View.GONE);

                int h = Integer.valueOf(ed_height.getText().toString());
                int w = Integer.valueOf(ed_weight.getText().toString());
                double standWeight, bodyFat;
                if(btn_boy.isChecked()){
                    standWeight = (h - 80) * 0.7;
                    bodyFat = (w - 0.88 * standWeight) / w * 100;
                }else{
                    standWeight = (h - 70) * 0.6;
                    bodyFat = (w - 0.82 * standWeight) / w * 100;
                }

                tv_weight.setText(String.format("標準體重 \n%.2f", standWeight));
                tv_bmi.setText(String.format("體脂肪 \n%.2f", bodyFat));
            }
        }.execute();
    }
}
