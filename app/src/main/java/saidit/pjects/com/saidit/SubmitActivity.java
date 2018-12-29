package saidit.pjects.com.saidit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubmitActivity extends Activity {

    private EditText quote, answer;
    private Button send;

    public void sendQuote(View view) {
        Question q = new Question();

        q.setQuestion(quote.getText().toString());
        q.setRightAnswer(quote.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        String message = "You submitted a movie quote!";
        intent.putExtra("mes", message);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        quote = (EditText) findViewById(R.id.quote);
        answer = (EditText) findViewById(R.id.answer);
        send = (Button) findViewById(R.id.send);

    }
}
