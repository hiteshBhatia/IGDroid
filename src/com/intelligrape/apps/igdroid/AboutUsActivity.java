package com.intelligrape.apps.igdroid;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.intelligrape.apps.igdroid.constants.IGConstants;
import com.intelligrape.apps.igdroid.src.DisplayNextView;
import com.intelligrape.apps.igdroid.src.Flip3DAnimation;

public class AboutUsActivity extends Activity {

	ArrayList<ImageView> imageViewsArray = new ArrayList();
	ArrayList<ImageView> imageViewsArrayFull = new ArrayList();
	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	private ImageView image4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_us);
		setupViews();
	}

	public void homeButtonClicked(View view){
		finish();
	}
	
	private void setupViews() {
		image1 = createImageViewByIdAndAddToArray(R.id.testimonial_img_01, false);
		image2 = createImageViewByIdAndAddToArray(R.id.testimonial_img_02, true);
		image3 = createImageViewByIdAndAddToArray(R.id.testimonial_img_03, true);
		image4 = createImageViewByIdAndAddToArray(R.id.testimonial_img_04, true);		
		hideImageViews();
		addOnClickListenerToArrayElements(imageViewsArrayFull);

	}

	private void addOnClickListenerToArrayElements(
			ArrayList<ImageView> imageViewArrayArg) {
		for (final ImageView iv : imageViewArrayArg) {
			iv.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					applyRotation(iv, 0, 90);
				}
			});
		}

	}

	private ImageView createImageViewByIdAndAddToArray(int id, boolean add) {
		ImageView image = (ImageView) findViewById(id);
		imageViewsArrayFull.add(image);
		if (add) {
			imageViewsArray.add(image);
		}
		return image;
	}

	private void hideImageViews() {
		for (ImageView imageView : imageViewsArray) {
			imageView.setVisibility(View.GONE);
		}
	}

	private void applyRotation(ImageView image, float start, float end) {
		final float centerX = image.getWidth() / 2.0f;
		final float centerY = image.getHeight() / 2.0f;

		final Flip3DAnimation rotation = new Flip3DAnimation(start, end,
				centerX, centerY);
		rotation.setDuration(IGConstants.ANIM_DURATION);
		rotation.setFillAfter(true);
		rotation.setInterpolator(new AccelerateInterpolator());
		rotation.setAnimationListener(new DisplayNextView(image,imageViewsArrayFull));
		image.startAnimation(rotation);

	}
}
