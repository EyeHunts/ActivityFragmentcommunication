package in.eyehunt.activityfragmentcommunication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyFragment.SendMessages {

    TextView tv_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_activity = (TextView) findViewById(R.id.tv_activity);

        Button btn_send_act = (Button) findViewById(R.id.btn_send_act);
        //send message to fragment
        btn_send_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                MyFragment myFragment = (MyFragment) manager.findFragmentById(R.id.myfrag);
                myFragment.receiveMsg("Hi Fragment how are you ?");
            }
        });
    }

    // receive data form fragments
    @Override
    public void iAmMSG(String msg) {
        tv_activity.setText(msg);
    }
}
