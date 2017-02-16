package luck.android.game.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import luck.android.game.R;

public class GameActivity extends AppCompatActivity {

    private TextView mFirstPlayer;
    private TextView mSecondPlayer;
    private TextView mClickHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dicegame);
        initializeViews();
    }

    private void initializeViews()
    {
        mFirstPlayer = (TextView)findViewById(R.id.fplayername);
        mSecondPlayer = (TextView)findViewById(R.id.splayername);
        mClickHeading = (TextView)findViewById(R.id.rollabel);
        Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        mFirstPlayer.setTypeface(myFont);
        mSecondPlayer.setTypeface(myFont);
        mClickHeading.setTypeface(myFont);
    }

}
