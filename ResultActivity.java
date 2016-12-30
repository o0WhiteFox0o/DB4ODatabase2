package btn.k23.dhcantho.db4odatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sonlonglxag on 12/10/16.
 */

public class ResultActivity extends AppCompatActivity{

    TextView txtScore;
    Button btnReturn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_result);
        // mapping to interface
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        Log.e("Check Result Activity: ", "mapping to interface OK " );
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        Log.e("Check Result Activity: ", "get score: "+ score );
        // show
        txtScore.setText("score: "+ score);
        Log.e("Check Result Activity: ", "show scre: "+ score );

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, LoginActivity.class );
                startActivity(intent);
                finish();
            }
        });
    }
}
