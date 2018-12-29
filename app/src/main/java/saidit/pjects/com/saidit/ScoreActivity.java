package saidit.pjects.com.saidit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends Activity {

    public void sendHome(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private TextView score;
    private Button home;
    private int scoreInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Bundle extras = getIntent().getExtras();
        score = (TextView) findViewById(R.id.scoreTxt);
        home = (Button) findViewById(R.id.homeBtn);
        if (extras != null) {
           String v = extras.getString("score");
           score.setText("SCORE: "+v);
        }
    }
}
