package bluenet.com.lab15;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.e("Firebase", "onNewToken  " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage msg) {
        super.onMessageReceived(msg);
        Log.e("Firebase","onMessageReceived");
        Log.e("Firebase", msg.getFrom());

        for(Map.Entry<String, String> entry : msg.getData().entrySet())
            Log.e("message",entry.getKey() + "/" + entry.getValue());
    }
}
