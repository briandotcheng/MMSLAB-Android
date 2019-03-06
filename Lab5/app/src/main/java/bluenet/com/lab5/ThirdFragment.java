package bluenet.com.lab5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThirdFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ThirdFragment","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.e("ThirdFragment","onCreateView");
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("ThirdFragment","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("ThirdFragment","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("ThirdFragment","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("ThirdFragment","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("ThirdFragment","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("ThirdFragment","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("ThirdFragment","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("ThirdFragment","onDetach");
    }
}
