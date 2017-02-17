package luck.android.game.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;

import luck.android.game.R;

/**
 * Created by Heena.Aggarwal on 07-11-2016.
 */
public class GIFView extends View {
    private InputStream gifInputStream;
    private Movie gifMovie;
    private int movieWidth, movieHeight;
    private long movieDuration;
    private long movieRunDuration;
    private long lastTick;
    private long nowTick;
    private int screenWidth, screenHeight;

    private boolean repeat = true;
    private boolean running = true;

    public void setRepeat(boolean r) {
        repeat = r;
    }

    public void setRunning(boolean r) {
        running = r;
    }

    public GIFView(Context context) {
        super(context);
        init(context);
    }

    public GIFView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GIFView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context)
    {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        setFocusable(true);
        gifInputStream = context.getResources().openRawResource(R.raw.animated);
        gifMovie = Movie.decodeStream(gifInputStream);
        movieWidth = 250/*gifMovie.width()*/;
        movieHeight = 250/*gifMovie.height()*/;
        movieDuration = gifMovie.duration();
        screenWidth = /*context.getResources().getDisplayMetrics().widthPixels;*/movieWidth;
        screenHeight = /*context.getResources().getDisplayMetrics().heightPixels;*/movieHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(screenWidth, screenHeight);

    }

    public int getMovieWidth() {
        return movieWidth;
    }

    public int getMovieHeight() {
        return movieHeight;
    }

    public long getMovieDuration() {
        return movieDuration;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (gifMovie == null) {
            return;
        }

        nowTick = android.os.SystemClock.uptimeMillis();
        if (lastTick == 0) { // first time
            movieRunDuration = 0;
        } else {
            if (running) {
                movieRunDuration += nowTick - lastTick;
                if (movieRunDuration > movieDuration) {
                    if (repeat) {
                        movieRunDuration = 0;
                    } else {
                        movieRunDuration = movieDuration;
                    }
                }
            }
        }

        gifMovie.setTime((int) movieRunDuration);
        double scalex = (double) screenWidth / (double) gifMovie.width();
        double scaley = (double) screenHeight / (double) gifMovie.height();
        canvas.scale((float) scalex, (float) scaley);
        gifMovie.draw(canvas, (float) scalex, (float) scaley);

        lastTick = nowTick;
        invalidate();

    }
}