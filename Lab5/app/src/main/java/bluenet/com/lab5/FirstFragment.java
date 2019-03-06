package bluenet.com.lab5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("FirstFragment","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.e("FirstFragment","onCreateView");
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("FirstFragment","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("FirstFragment","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("FirstFragment","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("FirstFragment","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("FirstFragment","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("FirstFragment","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("FirstFragment","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("FirstFragment","onDetach");
    }
}
