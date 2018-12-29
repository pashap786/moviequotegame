package saidit.pjects.com.saidit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Timer;

public class GameActivity extends Activity {

    private int scoreInt=0;
    private int questionCount=0;
    private Timer timer;
    private TextView question, score;
    private TextView answer;
    private Button ansA, ansB, ansC, ansD;
    Question qq = new Question();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        question = (TextView) findViewById(R.id.question);
        score = (TextView) findViewById(R.id.score);
        answer =(TextView) findViewById(R.id.hide);
        ansA = (Button) findViewById(R.id.ansA);
        ansB = (Button) findViewById(R.id.ansB);
        ansC = (Button) findViewById(R.id.ansC);
        ansD = (Button) findViewById(R.id.ansD);

        setQuestion();
    }

    private void setQuestion() {
        questionCount=questionCount+1;
        if(questionCount >= 20) {
            
        }
        getQuestion();

    }

    private void checkAnswerUpdateScore(String ans) {
        Log.d("ANSWER:  ",ans+"   "+answer.getText().toString());
        if(answer.getText().toString().equalsIgnoreCase(ans)) {
            scoreInt = scoreInt + 1;
            score.setText("Score: "+scoreInt);
        }
        setQuestion();
    }

    public void answerA(View view) {
        checkAnswerUpdateScore("a");
    }

    public void answerB(View view) {
        checkAnswerUpdateScore("b");
    }

    public void answerC(View view) {
        checkAnswerUpdateScore("c");
    }

    public void answerD(View view) {
        checkAnswerUpdateScore("d");
    }
    private void getQuestion() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        QuestionRequest objReq = new QuestionRequest(
                Request.Method.GET,
                WebUrls.QUESTION_URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String object = response.toString();
                        Gson g = new Gson();
                        Question qObj = g.fromJson(object, Question.class);
                        try {
                            Log.d("Response str", object);
                            question.setText(response.getString("question"));
                            answer.setText(response.getString("rightAnswer"));
                            ansA.setText(response.getString("ansA"));
                            ansB.setText(response.getString("ansB"));
                            ansC.setText(response.getString("ansC"));
                            ansD.setText(response.getString("ansD"));
                        }catch(Exception e) {}

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast t = new Toast(getApplicationContext());
                        t.setText("whoopsie");
                        t.show();
                    }
                }
        );

        requestQueue.add(objReq);
        Log.d("after", objReq.toString());
    }

}
