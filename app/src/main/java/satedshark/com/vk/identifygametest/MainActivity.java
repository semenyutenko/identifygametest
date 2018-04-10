package satedshark.com.vk.identifygametest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static int numCount = 5;
    static int numVariation = 4;
    static int numTips = 2;
    TextView winview;
    TextView winViewMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winViewMess = findViewById(R.id.textWin);
        LinearLayout linearLayout = findViewById(R.id.liner_layout);
        for (int i = 0; i < linearLayout.getChildCount(); i++){
            TextView tv = (TextView)linearLayout.getChildAt(i);
            tv.setText(generator(numCount, numVariation));
        }
        winview = (TextView)linearLayout.getChildAt((int)(Math.random() *
                (linearLayout.getChildCount() - numTips) + numTips));
        for (int i = 0; i < numTips; i++){
            onClick(linearLayout.getChildAt(i));
        }
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
        tv.setClickable(false);
        tv.setTextColor(getResources().getColor(R.color.colorCh));
        if (tv == winview) {
            winViewMess.setVisibility(View.VISIBLE);
        } else {
            tv.setText(tv.getText() + "    " + coun((String)tv.getText(), (String) winview.getText()).toString());
        }
    }

    private static Integer coun(String z, String y){
        Integer sum = 0;
        for(int i = 0; i < z.length(); i++){
            if(z.charAt(i) == y.charAt(i)){
                sum++;
            }
        }
            return sum;
        }
}
