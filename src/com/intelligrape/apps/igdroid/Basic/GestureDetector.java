package com.intelligrape.apps.igdroid.Basic;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MyGestureDetector extends SimpleOnGestureListener {
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		return true;
	
	}
}
