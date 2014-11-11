package com.example.georgi.puzzle;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class PuzzleActivity extends Activity {

    private Random random;
    private List<ImageView> imageViews;
    private List<Drawable> drawablesOrdered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        random = new Random();
        imageViews = new ArrayList<ImageView>();

        setContentView(R.layout.activity_puzzle);
        final LinearLayout masterParent = (LinearLayout) findViewById(R.id.super_parent);

        drawablesOrdered = obtainDrawables();
        List<Drawable> drawablesScrambled = new ArrayList<Drawable>(drawablesOrdered) {{
            Collections.shuffle(this);
        }};


        for (int y = 0; y < Math.sqrt(drawablesScrambled.size()); y++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            LinearLayout layout = new LinearLayout(this);
            layout.setLayoutParams(params);
            masterParent.addView(layout);
            for (int x = 0; x < Math.sqrt(drawablesScrambled.size()); x++) {
                final ImageView imageView = new ImageView(this);
                imageView.setAdjustViewBounds(true);
                imageView.setPadding(2, 2, 2, 2);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                LayoutParams lp = new LayoutParams(320, 240);
                imageViews.add(imageView);
                imageView.setLayoutParams(lp);
                Drawable d = drawablesScrambled.get((int) (y * Math.sqrt(drawablesScrambled.size()) + x));
                imageView.setImageDrawable(d);
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        View.DragShadowBuilder builder = new View.DragShadowBuilder(view);
                        imageView.startDrag(null, builder, imageView, 0);
                        return false;
                    }
                });
                imageView.setOnDragListener(new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View view, DragEvent dragEvent) {
                        if (dragEvent.getAction() == DragEvent.ACTION_DROP) {
                            ImageView dragSource = (ImageView) dragEvent.getLocalState();
                            //swap drawables
                            Drawable temp = dragSource.getDrawable();
                            dragSource.setImageDrawable(imageView.getDrawable());
                            imageView.setImageDrawable(temp);

                            if (victory()) {
                                toast("You win!");
                            }
                        }
                        return true;
                    }
                });
                layout.addView(imageView);
            }
        }

    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    private boolean victory() {
        return drawablesOrdered.equals(getDrawablesFromViews());
    }

    private List<Drawable> getDrawablesFromViews() {
        List<Drawable> drawables = new ArrayList<Drawable>();
        for (ImageView view : imageViews){
            drawables.add(view.getDrawable());
        }

        return drawables;
    }

    private List<Drawable> obtainDrawables() {
        TypedArray pictures = getResources().obtainTypedArray(R.array.pictures);
        List<Drawable> drawables = new ArrayList<Drawable>();
        for (int i = 0; i < pictures.length(); i++) {
            drawables.add(pictures.getDrawable(i));
        }
        pictures.recycle();

        return drawables;
    }


}
