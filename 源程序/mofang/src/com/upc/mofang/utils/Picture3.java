package com.upc.mofang.utils;

import com.upc.mofang.R;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;

public class Picture3 extends FrameLayout {

	// 每张图片的标签
	private int num;

	private View background = null;
	private TextView textview = null;

	// -------------构造函数------------//
	public Picture3(Context context) {
		super(context);
		LayoutParams lp = null;
		;

		background = new View(getContext());
		// background.setBackgroundColor(0x33ffffff);
		background.setBackgroundColor(Color.BLACK);
		// -1代表LayoutParams.MATCH_PARENT，即该布局的尺寸将填满它的父控件；
		lp = new LayoutParams(-1, -1);
		lp.setMargins(1, 1, 0, 0);
		addView(background, lp);

		textview = new TextView(getContext());
		textview.setTextSize(35);
		textview.setGravity(Gravity.CENTER);
		addView(textview, lp);
	}

	// 获取图片的标签
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		textview.setText(num+"");
		if (num == 1 || num == 2 || num == 3 || num == 7 || num == 8
				|| num == 9 || num == 13 || num == 14 || num == 15) {
			textview.setBackgroundResource(R.drawable.yello);
		}
		if (num == 4 || num == 5 || num == 6 || num == 10 || num == 11
				|| num == 12 || num == 16 || num == 17 || num == 18) {
			textview.setBackgroundResource(R.drawable.bule);
		}
		if (num == 19 || num == 20 || num == 21 || num == 25 || num == 26
				|| num == 27 || num == 31 || num == 32 || num == 33) {
			textview.setBackgroundResource(R.drawable.rstart);
		}
		if (num == 22 || num == 23 || num == 24 || num == 28 || num == 29
				|| num == 30 || num == 34 || num == 35 || num == 36) {
			textview.setBackgroundResource(R.drawable.green);
		}
	}
}