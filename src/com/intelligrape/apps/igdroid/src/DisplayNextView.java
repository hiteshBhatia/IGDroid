package com.intelligrape.apps.igdroid.src;

import java.util.ArrayList;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public final class DisplayNextView implements Animation.AnimationListener {	
	ImageView image1;
	ImageView image2;

	public DisplayNextView(ImageView image,ArrayList<ImageView> imageViewsArray) {
		this.image1= image;
		int index = imageViewsArray.indexOf(image);
		Integer nextIndex = (index + 1) % 4;				
		this.image2 =  imageViewsArray.get(nextIndex);
	}

	public void onAnimationStart(Animation animation) {}

	public void onAnimationEnd(Animation animation) {
		image1.post(new SwapViews(image1, image2));
	}

	public void onAnimationRepeat(Animation animation) {		
	}
}
