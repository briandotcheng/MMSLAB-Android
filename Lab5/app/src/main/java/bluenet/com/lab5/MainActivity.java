package bluenet.com.lab5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity","onCreate");

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.e("MainActivity","onRestart");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("MainActivity","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("MainActivity","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("MainActivity","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("MainActivity","onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity","onDestroy");
    }
}

class ViewPagerAdapter extends FragmentPagerAdapter {

    ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new FirstFragment();
            case 1 : return new SecondFragment();
            default: return new ThirdFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
