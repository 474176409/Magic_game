package com.upc.mofang.game;

import com.upc.mofang.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameEight extends Activity{
	private TextView tvtype;
	private Button rstart_btn;
	private int type = 0;
	private static GameEight gameEight = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eight_game);
		tvtype = (TextView) findViewById(R.id.tvtype1);
		rstart_btn = (Button) findViewById(R.id.back_btn);
		rstart_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				GameEight.this.finish();
			}
		});
	}
	public void clearType() {
		type = 0;
		showType();
	}

	public void showType() {
		tvtype.setText(type + "");
	}

	public void addType(int t) {
		type += t;
		showType();
	}
	
	public int getType(){
		return type;
	}
	public GameEight() {
		gameEight = this;
	}
	public static GameEight getGameEight() {
		return gameEight;
	}

}