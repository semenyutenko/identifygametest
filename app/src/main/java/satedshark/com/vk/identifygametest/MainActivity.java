package satedshark.com.vk.identifygametest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    static int numCount = 5;
    static int numVariation = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView1);
    }
    private static String generator(int n, int m){
        StringBuilder a = new StringBuilder();
        for(int i = 0; i < n; i++){
            char b = (char) (Math.random() * m + 'A');
            a.append(b);
        }
        return a.toString();
    }

    public void onClick(View view) {
        TextView tv = (TextView)view;
        tv.setText(generator(numCount, numVariation));
    }
}
