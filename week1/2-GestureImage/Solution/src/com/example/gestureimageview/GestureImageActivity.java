package com.example.gestureimageview;

import java.util.ArrayList;
import java.util.List;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class GestureImageActivity extends Activity implements OnTouchListener, OnClickListener {

	private View root;
	private Button btnFrame;
	private Button btnPlay;
	private ImageView image;
	
	List<Animator> animations;

	private PointF finger1;
	private PointF finger2;

	private float prevPanX;
	private float prevPanY;
	private float currPanX;
	private float currPanY;
	private float prevRotation;
	private float currRotation;
	private float prevScale;
	private float currScale;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_gestures);
		root = findViewById(R.id.root);
		root.setOnTouchListener(this);
		btnFrame = (Button) findViewById(R.id.frame);
		btnFrame.setOnClickListener(this);
		btnPlay = (Button) findViewById(R.id.play);
		btnPlay.setOnClickListener(this);
		image = (ImageView) findViewById(R.id.image);
		
		animations = new ArrayList<Animator>();
		
		finger1 = new PointF();
		finger2 = new PointF();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		update(event);

		int pointerCount = event.getPointerCount();
		int action = event.getAction() & MotionEvent.ACTION_MASK;

		switch (action) {
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_POINTER_DOWN:
			if (pointerCount == 2) {
				prevPanX = getCenter(finger1.x, finger2.x);
				prevPanY = getCenter(finger1.y, finger2.y);
				prevRotation = getAngle(finger1, finger2);
				prevScale = getDistance(finger1, finger2);
			} else if (pointerCount == 1) {
				resetPan();
			}
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_POINTER_UP:
		case MotionEvent.ACTION_CANCEL:
			if (event.getPointerCount() == 2) {
				resetPan();
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (pointerCount == 2) {
				currPanX = getCenter(finger1.x, finger2.x);
				currPanY = getCenter(finger1.y, finger2.y);
				currRotation = getAngle(finger1, finger2);
				currScale = getDistance(finger1, finger2);

				float deltaRotation = currRotation - prevRotation;
				float deltaScale = currScale / prevScale;

				image.setRotation(image.getRotation() + deltaRotation);
				image.setScaleX(image.getScaleX() * deltaScale);
				image.setScaleY(image.getScaleY() * deltaScale);

				prevRotation = currRotation;
				prevScale = currScale;
			} else if (pointerCount == 1) {
				currPanX = finger1.x;
				currPanY = finger1.y;
			}

			float deltaPanX = currPanX - prevPanX;
			float deltaPanY = currPanY - prevPanY;

			image.setTranslationX(image.getTranslationX() + deltaPanX);
			image.setTranslationY(image.getTranslationY() + deltaPanY);

			prevPanX = currPanX;
			prevPanY = currPanY;

			break;
		}
		return true;
	}

	private void update(MotionEvent event) {
		for (int pointerIndex = 0; pointerIndex < event.getPointerCount(); pointerIndex++) {
			int pointerId = event.getPointerId(pointerIndex);
			if (pointerId == 0) {
				finger1.x = event.getX(pointerIndex);
				finger1.y = event.getY(pointerIndex);
			}
			if (pointerId == 1) {
				finger2.x = event.getX(pointerIndex);
				finger2.y = event.getY(pointerIndex);
			}
		}
	}

	private void resetPan() {
		prevPanX = finger1.x;
		prevPanY = finger1.y;
	}

	private float getCenter(float x1, float x2) {
		return (x1 + x2) / 2;
	}

	private float getAngle(PointF p1, PointF p2) {
		float xDiff = p2.x - p1.x;
		float yDiff = p2.y - p1.y;
		return (float) Math.toDegrees(Math.atan2(yDiff, xDiff));
	}

	private float getDistance(PointF p1, PointF p2) {
		float xDiff = p2.x - p1.x;
		float yDiff = p2.y - p1.y;
		return (float) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	@Override
	public void onClick(View v) {
		if (v == btnFrame) {
			PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat("translationX", image.getTranslationX());
			PropertyValuesHolder translationY = PropertyValuesHolder.ofFloat("translationY", image.getTranslationY());
			PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", image.getScaleX());
			PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", image.getScaleY());
			PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat("rotation", image.getRotation());
			animations.add(ObjectAnimator.ofPropertyValuesHolder(image, translationX, translationY, scaleX, scaleY, rotation));
		} else if (v == btnPlay) {
			AnimatorSet as = new AnimatorSet();
			as.playSequentially(new ArrayList<Animator>(animations));
			as.start();
			animations.clear();
		}
	}
}
