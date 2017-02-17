package luck.android.game.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import luck.android.game.R;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mFirstPlayer;
    private TextView mSecondPlayer;
    private TextView mClickHeading;
    private LinearLayout gifDiceLay;
    private ImageView diceStatic;
    private ImageView mFirst;
    private ImageView mSecond;
    private ImageView mThird;
    private ImageView mFourth;
    private ImageView mFifth;
    private ImageView mSixth;
    private ImageView myNumber;


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

        mFirst = (ImageView) findViewById(R.id.first);
        mSecond = (ImageView) findViewById(R.id.second);
        mThird = (ImageView) findViewById(R.id.third);
        mFourth = (ImageView) findViewById(R.id.fourth);
        mFifth = (ImageView) findViewById(R.id.fifth);
        mSixth = (ImageView) findViewById(R.id.sixth);
        myNumber = (ImageView) findViewById(R.id.mynumber);

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
            myNumber.setVisibility(View.GONE);
            //
            hideGif();
        }
    }

    private int generateRandomNumber()
    {
        int min = 1;
        int max = 6;
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        if(randomNum==0)
        {
            randomNum = 1;
        }
        if(randomNum>6)
        {
            randomNum = 6;
        }
        return randomNum;
    }


    private void hideGif () {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                diceStatic.setVisibility(View.VISIBLE);
                gifDiceLay.setVisibility(View.GONE);
                myNumber.setVisibility(View.VISIBLE);
                int num = generateRandomNumber();
                Log.d("jits","number is-->>"+num);
                switch (num)
                {
                    case 1:
                    {
                        myNumber.setImageDrawable(ContextCompat.getDrawable(GameActivity.this,R.drawable.one));
                        break;
                    }
                    case 2:
                    {
                        myNumber.setImageDrawable(ContextCompat.getDrawable(GameActivity.this,R.drawable.two));
                        break;
                    }
                    case 3:
                    {
                        myNumber.setImageDrawable(ContextCompat.getDrawable(GameActivity.this,R.drawable.three));
                        break;
                    }
                    case 4:
                    {
                        myNumber.setImageDrawable(ContextCompat.getDrawable(GameActivity.this,R.drawable.four));
                        break;
                    }
                    case 5:
                    {
                        myNumber.setImageDrawable(ContextCompat.getDrawable(GameActivity.this,R.drawable.five));
                        break;
                    }
                    case 6:
                    {
                        myNumber.setImageDrawable(ContextCompat.getDrawable(GameActivity.this,R.drawable.six));
                        break;
                    }
                }
            }
        };
        handler.postDelayed(runnable,5000);
    }
}
