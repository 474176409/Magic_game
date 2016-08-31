package com.upc.mofang;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.upc.mofang.GameView.MyViewPagerAdapter;
import com.upc.mofang.game.GameEight;
import com.upc.mofang.game.GameFive;
import com.upc.mofang.game.GameFour;
import com.upc.mofang.game.GameNine;
import com.upc.mofang.game.GameOne;
import com.upc.mofang.game.GameSeven;
import com.upc.mofang.game.GameSix;
import com.upc.mofang.game.GameTen;
import com.upc.mofang.game.GameThree;
import com.upc.mofang.game.GameTwo;

public class GameView2 extends Activity{
	private ViewPager pager;
	private List<View> list;
	private int imageView[]={R.drawable.a2,R.drawable.a3,R.drawable.a5,R.drawable.a4};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.game2_view);
		pager=(ViewPager) findViewById(R.id.game_pager);
		initViewPager();
	}
	//初始化viewpager的方法
		public void initViewPager(){
			list =new ArrayList<View>();
			for(int i=0;i<4;i++){
				ImageView iv=new ImageView(this);
				iv.setImageResource(imageView[i]);
				list.add(iv);
			}
			pager.setAdapter(new MyViewPagerAdapter());
			//监听Viewpager的滑动效果
			pager.setOnPageChangeListener(new OnPageChangeListener() {
				//页卡被选中的函数
				@Override
				public void onPageSelected(int arg0) {
					if(arg0==1){
						list.get(1).setOnClickListener(new View.OnClickListener() {							
							@Override
							public void onClick(View arg0) {
								startActivity(new Intent(GameView2.this,GameTwo.class));
							}
						});
					}
					if(arg0==2){
						list.get(2).setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								startActivity(new Intent(GameView2.this,GameFour.class));
							}
						});
					}
					if(arg0==3){
						list.get(3).setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								startActivity(new Intent(GameView2.this,GameThree.class));
							}
						});
					}
				}
				
				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onPageScrollStateChanged(int arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		//定义viewpager的适配器
		class MyViewPagerAdapter extends PagerAdapter{
			//计算需要多少ITEM显示
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return list.size();
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0==arg1;
			}
			//初始化item实例的方法
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.addView(list.get(position));
				return list.get(position);
			}
			//item销毁的方法
			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {

//				super.destroyItem(container, position, object);
				container.removeView(list.get(position));
			}
		}
}
