package luck.android.game.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import luck.android.game.R;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mFirstPlayer;
    private TextView mSecondPlayer;
    private TextView mClickHeading;
    private LinearLayout gifDiceLay;
    private ImageView diceStatic;

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
        gifDiceLay = (LinearLayout) findViewById(R.id.laydiceGif);
        diceStatic = (ImageView) findViewById(R.id.diceStatic);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        mClickHeading.setAnimation(animation);
        Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        mFirstPlayer.setTypeface(myFont);
        mSecondPlayer.setTypeface(myFont);
        mClickHeading.setTypeface(myFont);

        mClickHeading.setOnClickListener(this);
        diceStatic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mClickHeading) {

        }
        else if (view == diceStatic) {
            diceStatic.setVisibility(View.GONE);
            gifDiceLay.setVisibility(View.VISIBLE);
            //
            hideGif();
        }
    }

    private void hideGif () {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                diceStatic.setVisibility(View.VISIBLE);
                gifDiceLay.setVisibility(View.GONE);
            }
        };
        handler.postDelayed(runnable,5000);
    }
}
