package btn.k23.dhcantho.db4odatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    boolean check = true;
    int rid=0;
    Question currentQ;
    TextView txtCheck;
    TextView txtQuestion;
    TextView txtSample;
    RadioButton rda, rdb, rdc, rdd;
    Button btnChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mappings with interface
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtSample = (TextView) findViewById(R.id.txtSample);
        rda = (RadioButton) findViewById(R.id.radioButton1);
        rdb = (RadioButton) findViewById(R.id.radioButton2);
        rdc = (RadioButton) findViewById(R.id.radioButton3);
        rdd = (RadioButton) findViewById(R.id.radioButton4);
        btnChoice = (Button) findViewById(R.id.btnChoose);
        Log.e("mapping interface: ", "OK " );

        //Create the DB:
        String dbPath =  "/data/data/" + getPackageName() + "/Db4oDatabase.db4o";
        Log.e("String Data Main: ",dbPath);
        //ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbPath);

        DbHelper data =new DbHelper(dbPath);
        quesList=data.getAllQuestions();
        currentQ=quesList.get(qid);

        setQuestionView();

        // Game Play -- Xử lý trong trò chơi
        btnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                RadioGroup grp=(RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.e("Check answer: ", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                else check = false;

                if(check==true ){
                    Random random = new Random();
                    rid= random.nextInt(quesList.size());

                    currentQ=quesList.get(rid );
                    setQuestionView();
                }else{
                    Log.e("Check Intent: ", "Begin ... " );
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    Log.e("Check Intent: ", "Set Intent " );
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    Log.e("Check Intent: ", "PutExtras OK " );
                    startActivity(intent);
                    Log.e("Check Intent: ", "Start Activity intent " );
                    finish();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     return super.onCreateOptionsMenu(menu);
    }

    private void setQuestionView() { // -- set value for interface

        Log.e("Set QuestionView: ", "Begin ...  " );
        txtQuestion.setText(currentQ.getQUESTION());
        Log.e("Set QuestionView: ", "Question value: " + currentQ.getQUESTION());
        txtSample.setText(currentQ.getSAMPLE());
        Log.e("Set QuestionView: ", "Sample value: " + currentQ.getSAMPLE());
        rda.setText(currentQ.getOPTA());
        Log.e("Set QuestionView: ", "A value: " + currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        Log.e("Set QuestionView: ", "B value: " + currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        Log.e("Set QuestionView: ", "C value: " + currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());
        Log.e("Set QuestionView: ", "D value: " + currentQ.getOPTD());
        qid++;
        Log.e("Set QuestionView: ", "End -- OK " );


    }
}
