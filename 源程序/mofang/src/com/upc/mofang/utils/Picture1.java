package com.upc.mofang.utils;

import com.upc.mofang.R;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Picture1 extends FrameLayout{
	//每张图片的标签
		private int num;
		
		private View background = null;
		private TextView textview=null;

		// -------------构造函数------------//
		public Picture1(Context context) {
			super(context);
			LayoutParams lp = null;;

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
			textview.setBackgroundResource(R.drawable.yello);
//			switch (num) {
//			case 1:
//				textview.setBackgroundColor(Color.rgb(0, 245 ,255));
//				break;
//			case 2:
//				textview.setBackgroundColor(Color.rgb(0, 123 ,205));
//				break;
//			case 3:
//				textview.setBackgroundColor(Color.rgb(0 ,255, 0));
//				break;
//			case 4:
//				textview.setBackgroundColor(Color.rgb(255, 246 ,143));
//				break;
//			case 5:
//				textview.setBackgroundColor(Color.rgb(255 ,255, 0));
//				break;
//			case 6:
//				textview.setBackgroundColor(Color.rgb(0 ,250 ,154));
//				break;
//			case 7:
//				textview.setBackgroundColor(Color.rgb(0 ,0, 0));
//			case 8:
//				textview.setBackgroundColor(Color.rgb(205 ,173 ,0));
//				break;
//			case 9:
//				textview.setBackgroundColor(Color.rgb(238, 232 ,170));
//				break;
//			case 10:
//				textview.setBackgroundColor(Color.rgb(139 ,101 ,8));
//				break;
//			case 11:
//				textview.setBackgroundColor(Color.rgb(255, 106, 106));
//				break;
//			case 12:
//				textview.setBackgroundColor(Color.rgb(255, 69, 0));
//				break;
//			case 13:
//				textview.setBackgroundColor(Color.rgb(255, 20 ,147));
//				break;
//			case 14:
//				textview.setBackgroundColor(Color.rgb(255, 64, 155));
//				break;
//			case 15:
//				textview.setBackgroundColor(Color.rgb(25, 25, 250));
//				break;
//			case 16:
//				textview.setBackgroundColor(Color.rgb(20, 0, 0));
//				break;
//			default:
//				textview.setBackgroundColor(Color.GREEN);
//				break;
//			}
		}

}
