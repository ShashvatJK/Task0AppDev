package com.example.hp.task0;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;






public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Random r= new Random();
    int payable=r.nextInt(101-1)+1;
    Button button1,button2,button5,button10,buttonclr,buttonexit,buttonreset;
    TextView textView,textView2,caption,count1,count2,count5,count10;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //random number
        textView = findViewById(R.id.textView);
        textView.setText(payable+"");

        //updating value to match random number
        button1= (Button)findViewById(R.id.button1);
        button2= (Button)findViewById(R.id.button2);
        button5= (Button)findViewById(R.id.button5);
        button10= (Button)findViewById(R.id.button10);
        count1= (TextView)findViewById(R.id.count1);
        count2= (TextView)findViewById(R.id.count2);
        count5= (TextView)findViewById(R.id.count5);
        count10= (TextView)findViewById(R.id.count10);
        update(button1,count1,1);
        update(button2,count2,2);
        update(button5,count5,5);
        update(button10,count10,10);

        //clear button
        buttonclr = (Button)findViewById(R.id.buttonclr);
        buttonclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2 = (TextView)findViewById(R.id.textView2);
                caption = (TextView)findViewById(R.id.caption);
                textView2.setText("0");
                count1.setText("0");
                count2.setText("0");
                count5.setText("0");
                count10.setText("0");
                caption.setText("Please tender change for the above amount.");
                button1.setEnabled(true);
                button2.setEnabled(true);
                button5.setEnabled(true);
                button10.setEnabled(true);
                setFrameBackgroundColor(Color.WHITE);
            }
        });

        //reset button
        buttonreset = (Button)findViewById(R.id.buttonreset);
        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2 = (TextView)findViewById(R.id.textView2);
                caption = (TextView)findViewById(R.id.caption);
                textView2.setText("0");
                count1.setText("0");
                count2.setText("0");
                count5.setText("0");
                count10.setText("0");
                payable=r.nextInt(101-1)+1;
                textView.setText(payable+"");
                caption.setText("Please tender change for the above amount.");
                button1.setEnabled(true);
                button2.setEnabled(true);
                button5.setEnabled(true);
                button10.setEnabled(true);
                setFrameBackgroundColor(Color.WHITE);
            }
        });

        //exit button
        buttonexit = findViewById(R.id.buttonexit);
        buttonexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    // update function
    public void update(final Button b, final TextView count, final int i ){
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2 = (TextView)findViewById(R.id.textView2);
                caption = (TextView)findViewById(R.id.caption);
                int val=Integer.parseInt(textView2.getText().toString());
                textView2.setText((val+=i)+"");
                if(val==payable){
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button5.setEnabled(false);
                    button10.setEnabled(false);
                    caption.setText("Change paid! Click Reset to pay again.");
                    setFrameBackgroundColor(Color.GREEN);
                }
                if(val>payable){
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button5.setEnabled(false);
                    button10.setEnabled(false);
                    caption.setText("Mispayment! Click Clear to continue.");
                    setFrameBackgroundColor(Color.RED);
                }
                count.setText(Integer.parseInt(count.getText().toString())+1 +"");
            }
        });
    }
    public final void setFrameBackgroundColor(int color){
        ConstraintLayout bg = (ConstraintLayout)findViewById(R.id.bg);
        bg.setBackgroundColor(color);
    }
}

