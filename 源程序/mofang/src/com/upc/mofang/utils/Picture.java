package com.upc.mofang.utils;



import com.upc.mofang.R;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Picture extends FrameLayout {
	//每张图片的标签
	private int num;
	
	private View background = null;
	private TextView textview=null;

	// -------------构造函数------------//
	public Picture(Context context) {
		super(context);
		LayoutParams lp = null;

		background = new View(getContext());
		// background.setBackgroundColor(0x33ffffff);
		background.setBackgroundColor(Color.BLACK);
		// -1代表LayoutParams.MATCH_PARENT，即该布局的尺寸将填满它的父控件；
		lp = new LayoutParams(-1, -1);
		lp.setMargins(1, 1, 0, 0);
		addView(background, lp);
		
		textview =new TextView(getContext());
		textview.setTextSize(35);
		textview.setGravity(Gravity.CENTER);
		addView(textview,lp);
	}
	//获取图片的标签
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		textview.setText(num+"");
		textview.setBackgroundResource(R.drawable.green);
//		switch (num) {
//		case 1:
//			textview.setBackgroundColor(0x00000000);
//			break;
//		case 2:
//			textview.setBackgroundColor(0xffeee4da);
//			break;
//		case 3:
//			textview.setBackgroundColor(0xffede0c8);
//			break;
//		case 4:
//			textview.setBackgroundColor(0xfff2b179);
//			break;
//		case 5:
//			textview.setBackgroundColor(0xfff59563);
//			break;
//		case 6:
//			textview.setBackgroundColor(0xfff67c5f);
//			break;
//		case 7:
//			textview.setBackgroundColor(0xfff65e3b);
//			break;
//		case 8:
//			textview.setBackgroundColor(0xffedcf72);
//			break;
//		case 9:
//			textview.setBackgroundColor(0xffedcc61);
//			break;
//		default:
//			break;
//		}
	}
}
