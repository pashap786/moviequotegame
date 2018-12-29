package saidit.pjects.com.saidit;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.w3c.dom.Text;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    Button start, submit;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        title.setText("Movie Quotes");
        start = (Button) findViewById(R.id.start);
        submit = (Button) findViewById(R.id.quote);


    }

    public void onePlayer(View view) {
        Intent intent = new Intent(this, GameActivity.class);

        startActivity(intent);
    }

    public void submitQuote(View view) {
        Intent intent = new Intent(this, SubmitActivity.class);

        startActivity(intent);
    }
}
