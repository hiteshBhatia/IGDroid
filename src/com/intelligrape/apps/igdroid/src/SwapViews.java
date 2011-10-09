package com.intelligrape.apps.igdroid.src;

import com.intelligrape.apps.igdroid.constants.IGConstants;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public final class SwapViews implements Runnable {

	ImageView image1;
	ImageView image2;

	public SwapViews(ImageView image1, ImageView image2) {
		this.image1 = image1;
		this.image2 = image2;
	}

	public void run() {
		final float centerX = image1.getWidth() / 2.0f;
		final float centerY = image1.getHeight() / 2.0f;
		Flip3DAnimation rotation;

		image1.setVisibility(View.GONE);
		image1.clearFocus();
		
		image2.setVisibility(View.VISIBLE);
		image2.requestFocus();
				
		rotation = new Flip3DAnimation(-90, 0, centerX, centerY);

		rotation.setDuration(IGConstants.ANIM_DURATION_SW);
		rotation.setFillAfter(true);
		rotation.setInterpolator(new DecelerateInterpolator());
		image2.startAnimation(rotation);
		image2.requestFocus();
	}
}
