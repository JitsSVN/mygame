package luck.android.game.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Prabhakant.Agnihotri on 17-02-2017.
 */

public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
    }
    public CustomTextView (Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        init(context);
    }
    private void init(Context context) {
        try {
            Typeface myFont = Typeface.createFromAsset(context.getAssets(), "fonts/Pacifico.ttf");
            setTypeface(myFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

