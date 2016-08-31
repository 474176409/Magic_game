package com.upc.mofang.utils;

import com.upc.mofang.R;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Picture2 extends FrameLayout {
		//ÿ��ͼƬ�ı�ǩ
			private int num;
			
			private View background = null;
			private TextView textview=null;

			// -------------���캯��------------//
			public Picture2(Context context) {
				super(context);
				LayoutParams lp = null;;

				background = new View(getContext());
				// background.setBackgroundColor(0x33ffffff);
				background.setBackgroundColor(Color.BLACK);
				// -1����LayoutParams.MATCH_PARENT�����ò��ֵĳߴ罫�������ĸ��ؼ���
				lp = new LayoutParams(-1, -1);
				lp.setMargins(1, 1, 0, 0);
				addView(background, lp);
				
				textview =new TextView(getContext());
				textview.setTextSize(35);
				textview.setGravity(Gravity.CENTER);
				addView(textview,lp);
			}
			//��ȡͼƬ�ı�ǩ
			public int getNum() {
				return num;
			}

			public void setNum(int num) {
				this.num = num;
				if(num!=1&&num!=16)textview.setText(num+"");
				switch (num) {
				case 1:
					textview.setBackgroundResource(R.drawable.up);
				case 16:
					textview.setBackgroundResource(R.drawable.up);
					break;
				default:
					textview.setBackgroundResource(R.drawable.rstart);
					break;
				}
			}

}
