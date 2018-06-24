package in.eyehunt.activityfragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragment extends Fragment {

    private SendMessages sendMessages;
    TextView tv_frag;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        sendMessages = (SendMessages) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        tv_frag = (TextView) view.findViewById(R.id.tv_fragment);

        // on click button pass data
        Button send = (Button) view.findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessages.iAmMSG("Hello I am fragment ");
            }
        });
        return view;
    }

    // Interface - fragment to activity
    public interface SendMessages {
        void iAmMSG(String msg);
    }

    //Receive message - activity to fragment
    public void receiveMsg(String msg) {
        tv_frag.setText(msg);
    }
}
