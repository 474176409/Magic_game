package com.upc.mofang.rule;

import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import com.upc.mofang.game.GameNine;
import com.upc.mofang.game.GameTen;
import com.upc.mofang.utils.Picture6;
import com.upc.mofang.utils.Picture7;

public class Game9 extends GridLayout{
	public int piece = 9;// ���˼�
	// ÿ��ͼƬ�Ŀ��
	private static int pictureWidth = 0;
	public static int getPictureWidth() {
		return pictureWidth;
	}

	private Picture7[][] pictureMap = new Picture7[piece][piece];

	public Game9(Context context) {
		super(context);
		initGameView();
	}

	public Game9(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initGameView();
	}

	public Game9(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameView();
	}
	public void initGameView() {

		// ��ʼ����ʱ������Ϊ����
		setColumnCount(piece);
		 setBackgroundColor(0xffbbada0);
		//setBackgroundColor(Color.rgb(255, 255, 255));
		// ���ô��������¼������жϵڼ��еڼ��б������ˣ������ﻬ
		setOnTouchListener(new View.OnTouchListener() {
			// ����down������
			private float startX = 0, startY = 0;
			// ����UP������
			private float endX = 0, endY = 0;
			// ����X,Y��ƫ����
			private float offsetX = 0, offsetY = 0;

			@Override
			public boolean onTouch(View view, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					break;
				case MotionEvent.ACTION_UP:
					endX = event.getX();
					endY = event.getY();

					offsetX = startX - endX;
					offsetY = startY - endY;
					// ���ж������ĸ����򻬶���
					if (Math.abs(offsetX) > Math.abs(offsetY)) {
						if (offsetX > 5) {
							swipeLeft(startY);
							isGameEnd();
						} else if (offsetX < -5) {
							swipeRight(startY);
							isGameEnd();
						}
					} else {
						if (offsetY > 5) {
							swipeUp(startX);
							isGameEnd();
						} else if (offsetY < -5) {
							swipeDown(startX);
							isGameEnd();
						}
					}
					break;
				default:
					break;
				}
				return true;
			}
		});
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		// ��̬������Ļ�Ŀ��
		pictureWidth = (Math.min(w, h) - 1) / piece;// ȡ��Ļ��ߵ���Сֵ������Ļ��Ե��1���صĿ�϶
		// �õ���Ƭ�Ŀ��
		addpicture(pictureWidth, pictureWidth);
		startGame();
	}

	public void startGame() {
		GameTen.getGameTen().clearType();
	}

	public void isGameEnd() {
		boolean isEnd = true;
		for (int x = 0; x < piece; x++) {
			for (int y = 0; y < piece; y++) {
				if (pictureMap[x][y].getNum() != x * piece + y + 1) {
					isEnd = false;
				}
			}
		}
			
		if (isEnd) {
			new AlertDialog.Builder(getContext()).setTitle("��ʾ")
					.setMessage("��ϲ�������!").show();
		}
	}

	protected void addpicture(int pictureWidth, int pictureHeight) {
		Picture7 picture = null;
		int a = 0;
		for (int x = 0; x < piece; x++) {
			for (int y = 0; y < piece; y++) {
				picture = new Picture7(getContext());
				a++;
				picture.setNum(a);
				addView(picture, pictureWidth, pictureHeight);
				pictureMap[x][y] = picture;
			}
		}
		for (int i = 0; i < 30; i++) {
			int b = (int) (Math.random() * 4 + 1);
			float c = ((int) (Math.random() * piece)) * Game9.pictureWidth;
			switch (b) {
			case 1:
				swipeDown(c);
				break;
			case 2:
				swipeUp(c);
				break;
			case 3:
				swipeRight(c);
				break;
			case 4:
				swipeLeft(c);
				break;
			default:
				break;
			}
		}
	}

	private void swipeUp(float startX) {
		GameTen.getGameTen().addType(1);
		int num;
		switch ((int) (startX / pictureWidth)) {
		case 0:// ��һ��
			num = pictureMap[0][0].getNum();
			pictureMap[0][0].setNum(pictureMap[1][0].getNum());
			pictureMap[1][0].setNum(pictureMap[2][0].getNum());
			pictureMap[2][0].setNum(pictureMap[3][0].getNum());
			pictureMap[3][0].setNum(pictureMap[4][0].getNum());
			pictureMap[4][0].setNum(pictureMap[5][0].getNum());
			pictureMap[5][0].setNum(pictureMap[6][0].getNum());
			pictureMap[6][0].setNum(pictureMap[7][0].getNum());
			pictureMap[7][0].setNum(pictureMap[8][0].getNum());
			pictureMap[8][0].setNum(num);
			break;
		case 1:// �ڶ���
			num = pictureMap[0][1].getNum();
			pictureMap[0][1].setNum(pictureMap[1][1].getNum());
			pictureMap[1][1].setNum(pictureMap[2][1].getNum());
			pictureMap[2][1].setNum(pictureMap[3][1].getNum());
			pictureMap[3][1].setNum(pictureMap[4][1].getNum());
			pictureMap[4][1].setNum(pictureMap[5][1].getNum());
			pictureMap[5][1].setNum(pictureMap[6][1].getNum());
			pictureMap[6][1].setNum(pictureMap[7][1].getNum());
			pictureMap[7][1].setNum(pictureMap[8][1].getNum());
			pictureMap[8][1].setNum(num);
			break;
		case 2:// ������
			num = pictureMap[0][2].getNum();
			pictureMap[0][2].setNum(pictureMap[1][2].getNum());
			pictureMap[1][2].setNum(pictureMap[2][2].getNum());
			pictureMap[2][2].setNum(pictureMap[3][2].getNum());
			pictureMap[3][2].setNum(pictureMap[4][2].getNum());
			pictureMap[4][2].setNum(pictureMap[5][2].getNum());
			pictureMap[5][2].setNum(pictureMap[6][2].getNum());
			pictureMap[6][2].setNum(pictureMap[7][2].getNum());
			pictureMap[7][2].setNum(pictureMap[8][2].getNum());
			pictureMap[8][2].setNum(num);
			break;
		case 3:// ������
			num = pictureMap[0][3].getNum();
			pictureMap[0][3].setNum(pictureMap[1][3].getNum());
			pictureMap[1][3].setNum(pictureMap[2][3].getNum());
			pictureMap[2][3].setNum(pictureMap[3][3].getNum());
			pictureMap[3][3].setNum(pictureMap[4][3].getNum());
			pictureMap[4][3].setNum(pictureMap[5][3].getNum());
			pictureMap[5][3].setNum(pictureMap[6][3].getNum());
			pictureMap[6][3].setNum(pictureMap[7][3].getNum());
			pictureMap[7][3].setNum(pictureMap[8][3].getNum());
			pictureMap[8][3].setNum(num);
			break;
		case 4:// ������
			num = pictureMap[0][4].getNum();
			pictureMap[0][4].setNum(pictureMap[1][4].getNum());
			pictureMap[1][4].setNum(pictureMap[2][4].getNum());
			pictureMap[2][4].setNum(pictureMap[3][4].getNum());
			pictureMap[3][4].setNum(pictureMap[4][4].getNum());
			pictureMap[4][4].setNum(pictureMap[5][4].getNum());
			pictureMap[5][4].setNum(pictureMap[6][4].getNum());
			pictureMap[6][4].setNum(pictureMap[7][4].getNum());
			pictureMap[7][4].setNum(pictureMap[8][4].getNum());
			pictureMap[8][4].setNum(num);
			break;
		case 5:// ������
			num = pictureMap[0][5].getNum();
			pictureMap[0][5].setNum(pictureMap[1][5].getNum());
			pictureMap[1][5].setNum(pictureMap[2][5].getNum());
			pictureMap[2][5].setNum(pictureMap[3][5].getNum());
			pictureMap[3][5].setNum(pictureMap[4][5].getNum());
			pictureMap[4][5].setNum(pictureMap[5][5].getNum());
			pictureMap[5][5].setNum(pictureMap[6][5].getNum());
			pictureMap[6][5].setNum(pictureMap[7][5].getNum());
			pictureMap[7][5].setNum(pictureMap[8][5].getNum());
			pictureMap[8][5].setNum(num);
			break;
		case 6:// ������
			num = pictureMap[0][6].getNum();
			pictureMap[0][6].setNum(pictureMap[1][6].getNum());
			pictureMap[1][6].setNum(pictureMap[2][6].getNum());
			pictureMap[2][6].setNum(pictureMap[3][6].getNum());
			pictureMap[3][6].setNum(pictureMap[4][6].getNum());
			pictureMap[4][6].setNum(pictureMap[5][6].getNum());
			pictureMap[5][6].setNum(pictureMap[6][6].getNum());
			pictureMap[6][6].setNum(pictureMap[7][6].getNum());
			pictureMap[7][6].setNum(pictureMap[8][6].getNum());
			pictureMap[8][6].setNum(num);
			break;
		case 7:// ��8��
			num = pictureMap[0][7].getNum();
			pictureMap[0][7].setNum(pictureMap[1][7].getNum());
			pictureMap[1][7].setNum(pictureMap[2][7].getNum());
			pictureMap[2][7].setNum(pictureMap[3][7].getNum());
			pictureMap[3][7].setNum(pictureMap[4][7].getNum());
			pictureMap[4][7].setNum(pictureMap[5][7].getNum());
			pictureMap[5][7].setNum(pictureMap[6][7].getNum());
			pictureMap[6][7].setNum(pictureMap[7][7].getNum());
			pictureMap[7][7].setNum(pictureMap[8][7].getNum());
			pictureMap[8][7].setNum(num);
			break;
		case 8:// ��9��
			num = pictureMap[0][8].getNum();
			pictureMap[0][8].setNum(pictureMap[1][8].getNum());
			pictureMap[1][8].setNum(pictureMap[2][8].getNum());
			pictureMap[2][8].setNum(pictureMap[3][8].getNum());
			pictureMap[3][8].setNum(pictureMap[4][8].getNum());
			pictureMap[4][8].setNum(pictureMap[5][8].getNum());
			pictureMap[5][8].setNum(pictureMap[6][8].getNum());
			pictureMap[6][8].setNum(pictureMap[7][8].getNum());
			pictureMap[7][8].setNum(pictureMap[8][8].getNum());
			pictureMap[8][8].setNum(num);
			break;
		default:
			break;
		}
	}

	private void swipeDown(float startX) {
		GameTen.getGameTen().addType(1);
		int num;
		switch ((int) (startX / pictureWidth)) {
		case 0:// ��һ��
			num = pictureMap[0][0].getNum();
			pictureMap[0][0].setNum(pictureMap[8][0].getNum());
			pictureMap[8][0].setNum(pictureMap[7][0].getNum());
			pictureMap[7][0].setNum(pictureMap[6][0].getNum());
			pictureMap[6][0].setNum(pictureMap[5][0].getNum());
			pictureMap[5][0].setNum(pictureMap[4][0].getNum());
			pictureMap[4][0].setNum(pictureMap[3][0].getNum());
			pictureMap[3][0].setNum(pictureMap[2][0].getNum());
			pictureMap[2][0].setNum(pictureMap[1][0].getNum());
			pictureMap[1][0].setNum(num);
			break;
		case 1:// �ڶ���
			num = pictureMap[0][1].getNum();
			pictureMap[0][1].setNum(pictureMap[8][1].getNum());
			pictureMap[8][1].setNum(pictureMap[7][1].getNum());
			pictureMap[7][1].setNum(pictureMap[6][1].getNum());
			pictureMap[6][1].setNum(pictureMap[5][1].getNum());
			pictureMap[5][1].setNum(pictureMap[4][1].getNum());
			pictureMap[4][1].setNum(pictureMap[3][1].getNum());
			pictureMap[3][1].setNum(pictureMap[2][1].getNum());
			pictureMap[2][1].setNum(pictureMap[1][1].getNum());
			pictureMap[1][1].setNum(num);
			break;
		case 2:// ������
			num = pictureMap[0][2].getNum();
			pictureMap[0][2].setNum(pictureMap[8][2].getNum());
			pictureMap[8][2].setNum(pictureMap[7][2].getNum());
			pictureMap[7][2].setNum(pictureMap[6][2].getNum());
			pictureMap[6][2].setNum(pictureMap[5][2].getNum());
			pictureMap[5][2].setNum(pictureMap[4][2].getNum());
			pictureMap[4][2].setNum(pictureMap[3][2].getNum());
			pictureMap[3][2].setNum(pictureMap[2][2].getNum());
			pictureMap[2][2].setNum(pictureMap[1][2].getNum());
			pictureMap[1][2].setNum(num);
			break;
		case 3:// ������
			num = pictureMap[0][3].getNum();
			pictureMap[0][3].setNum(pictureMap[8][3].getNum());
			pictureMap[8][3].setNum(pictureMap[7][3].getNum());
			pictureMap[7][3].setNum(pictureMap[6][3].getNum());
			pictureMap[6][3].setNum(pictureMap[5][3].getNum());
			pictureMap[5][3].setNum(pictureMap[4][3].getNum());
			pictureMap[4][3].setNum(pictureMap[3][3].getNum());
			pictureMap[3][3].setNum(pictureMap[2][3].getNum());
			pictureMap[2][3].setNum(pictureMap[1][3].getNum());
			pictureMap[1][3].setNum(num);
			break;
		case 4:// ������
			num = pictureMap[0][4].getNum();
			pictureMap[0][4].setNum(pictureMap[8][4].getNum());
			pictureMap[8][4].setNum(pictureMap[7][4].getNum());
			pictureMap[7][4].setNum(pictureMap[6][4].getNum());
			pictureMap[6][4].setNum(pictureMap[5][4].getNum());
			pictureMap[5][4].setNum(pictureMap[4][4].getNum());
			pictureMap[4][4].setNum(pictureMap[3][4].getNum());
			pictureMap[3][4].setNum(pictureMap[2][4].getNum());
			pictureMap[2][4].setNum(pictureMap[1][4].getNum());
			pictureMap[1][4].setNum(num);
			break;
		case 5:// ������
			num = pictureMap[0][5].getNum();
			pictureMap[0][5].setNum(pictureMap[8][5].getNum());
			pictureMap[8][5].setNum(pictureMap[7][5].getNum());
			pictureMap[7][5].setNum(pictureMap[6][5].getNum());
			pictureMap[6][5].setNum(pictureMap[5][5].getNum());
			pictureMap[5][5].setNum(pictureMap[4][5].getNum());
			pictureMap[4][5].setNum(pictureMap[3][5].getNum());
			pictureMap[3][5].setNum(pictureMap[2][5].getNum());
			pictureMap[2][5].setNum(pictureMap[1][5].getNum());
			pictureMap[1][5].setNum(num);
			break;
		case 6:// ������
			num = pictureMap[0][6].getNum();
			pictureMap[0][6].setNum(pictureMap[8][6].getNum());
			pictureMap[8][6].setNum(pictureMap[7][6].getNum());
			pictureMap[7][6].setNum(pictureMap[6][6].getNum());
			pictureMap[6][6].setNum(pictureMap[5][6].getNum());
			pictureMap[5][6].setNum(pictureMap[4][6].getNum());
			pictureMap[4][6].setNum(pictureMap[3][6].getNum());
			pictureMap[3][6].setNum(pictureMap[2][6].getNum());
			pictureMap[2][6].setNum(pictureMap[1][6].getNum());
			pictureMap[1][6].setNum(num);
			break;
		case 7:// ��8��
			num = pictureMap[0][7].getNum();
			pictureMap[0][7].setNum(pictureMap[8][7].getNum());
			pictureMap[8][7].setNum(pictureMap[7][7].getNum());
			pictureMap[7][7].setNum(pictureMap[6][7].getNum());
			pictureMap[6][7].setNum(pictureMap[5][7].getNum());
			pictureMap[5][7].setNum(pictureMap[4][7].getNum());
			pictureMap[4][7].setNum(pictureMap[3][7].getNum());
			pictureMap[3][7].setNum(pictureMap[2][7].getNum());
			pictureMap[2][7].setNum(pictureMap[1][7].getNum());
			pictureMap[1][7].setNum(num);
			break;
		case 8:// ��9��
			num = pictureMap[0][8].getNum();
			pictureMap[0][8].setNum(pictureMap[8][8].getNum());
			pictureMap[8][8].setNum(pictureMap[7][8].getNum());
			pictureMap[7][8].setNum(pictureMap[6][8].getNum());
			pictureMap[6][8].setNum(pictureMap[5][8].getNum());
			pictureMap[5][8].setNum(pictureMap[4][8].getNum());
			pictureMap[4][8].setNum(pictureMap[3][8].getNum());
			pictureMap[3][8].setNum(pictureMap[2][8].getNum());
			pictureMap[2][8].setNum(pictureMap[1][8].getNum());
			pictureMap[1][8].setNum(num);
			break;
		default:
			break;
		}
	}

	private void swipeLeft(float startY) {
		GameTen.getGameTen().addType(1);
		int num;
		switch ((int) (startY / pictureWidth)) {
		case 0:// ��һ��
			num = pictureMap[0][0].getNum();
			pictureMap[0][0].setNum(pictureMap[0][1].getNum());
			pictureMap[0][1].setNum(pictureMap[0][2].getNum());
			pictureMap[0][2].setNum(pictureMap[0][3].getNum());
			pictureMap[0][3].setNum(pictureMap[0][4].getNum());
			pictureMap[0][4].setNum(pictureMap[0][5].getNum());
			pictureMap[0][5].setNum(pictureMap[0][6].getNum());
			pictureMap[0][6].setNum(pictureMap[0][7].getNum());
			pictureMap[0][7].setNum(pictureMap[0][8].getNum());
			pictureMap[0][8].setNum(num);
			break;
		case 1:// �ڶ���
			num = pictureMap[1][0].getNum();
			pictureMap[1][0].setNum(pictureMap[1][1].getNum());
			pictureMap[1][1].setNum(pictureMap[1][2].getNum());
			pictureMap[1][2].setNum(pictureMap[1][3].getNum());
			pictureMap[1][3].setNum(pictureMap[1][4].getNum());
			pictureMap[1][4].setNum(pictureMap[1][5].getNum());
			pictureMap[1][5].setNum(pictureMap[1][6].getNum());
			pictureMap[1][6].setNum(pictureMap[1][7].getNum());
			pictureMap[1][7].setNum(pictureMap[1][8].getNum());
			pictureMap[1][8].setNum(num);
			break;
		case 2:// ������
			num = pictureMap[2][0].getNum();
			pictureMap[2][0].setNum(pictureMap[2][1].getNum());
			pictureMap[2][1].setNum(pictureMap[2][2].getNum());
			pictureMap[2][2].setNum(pictureMap[2][3].getNum());
			pictureMap[2][3].setNum(pictureMap[2][4].getNum());
			pictureMap[2][4].setNum(pictureMap[2][5].getNum());
			pictureMap[2][5].setNum(pictureMap[2][6].getNum());
			pictureMap[2][6].setNum(pictureMap[2][7].getNum());
			pictureMap[2][7].setNum(pictureMap[2][8].getNum());
			pictureMap[2][8].setNum(num);
			break;
		case 3:// ������
			num = pictureMap[3][0].getNum();
			pictureMap[3][0].setNum(pictureMap[3][1].getNum());
			pictureMap[3][1].setNum(pictureMap[3][2].getNum());
			pictureMap[3][2].setNum(pictureMap[3][3].getNum());
			pictureMap[3][3].setNum(pictureMap[3][4].getNum());
			pictureMap[3][4].setNum(pictureMap[3][5].getNum());
			pictureMap[3][5].setNum(pictureMap[3][6].getNum());
			pictureMap[3][6].setNum(pictureMap[3][7].getNum());
			pictureMap[3][7].setNum(pictureMap[3][8].getNum());
			pictureMap[3][8].setNum(num);
			break;
		case 4:// ������
			num = pictureMap[4][0].getNum();
			pictureMap[4][0].setNum(pictureMap[4][1].getNum());
			pictureMap[4][1].setNum(pictureMap[4][2].getNum());
			pictureMap[4][2].setNum(pictureMap[4][3].getNum());
			pictureMap[4][3].setNum(pictureMap[4][4].getNum());
			pictureMap[4][4].setNum(pictureMap[4][5].getNum());
			pictureMap[4][5].setNum(pictureMap[4][6].getNum());
			pictureMap[4][6].setNum(pictureMap[4][7].getNum());
			pictureMap[4][7].setNum(pictureMap[4][8].getNum());
			pictureMap[4][8].setNum(num);
			break;
		case 5:// ������
			num = pictureMap[5][0].getNum();
			pictureMap[5][0].setNum(pictureMap[5][1].getNum());
			pictureMap[5][1].setNum(pictureMap[5][2].getNum());
			pictureMap[5][2].setNum(pictureMap[5][3].getNum());
			pictureMap[5][3].setNum(pictureMap[5][4].getNum());
			pictureMap[5][4].setNum(pictureMap[5][5].getNum());
			pictureMap[5][5].setNum(pictureMap[5][6].getNum());
			pictureMap[5][6].setNum(pictureMap[5][7].getNum());
			pictureMap[5][7].setNum(pictureMap[5][8].getNum());
			pictureMap[5][8].setNum(num);
			break;
		case 6:// ������
			num = pictureMap[6][0].getNum();
			pictureMap[6][0].setNum(pictureMap[6][1].getNum());
			pictureMap[6][1].setNum(pictureMap[6][2].getNum());
			pictureMap[6][2].setNum(pictureMap[6][3].getNum());
			pictureMap[6][3].setNum(pictureMap[6][4].getNum());
			pictureMap[6][4].setNum(pictureMap[6][5].getNum());
			pictureMap[6][5].setNum(pictureMap[6][6].getNum());
			pictureMap[6][6].setNum(pictureMap[6][7].getNum());
			pictureMap[6][7].setNum(pictureMap[6][8].getNum());
			pictureMap[6][8].setNum(num);
			break;
		case 7:// ��8��
			num = pictureMap[7][0].getNum();
			pictureMap[7][0].setNum(pictureMap[7][1].getNum());
			pictureMap[7][1].setNum(pictureMap[7][2].getNum());
			pictureMap[7][2].setNum(pictureMap[7][3].getNum());
			pictureMap[7][3].setNum(pictureMap[7][4].getNum());
			pictureMap[7][4].setNum(pictureMap[7][5].getNum());
			pictureMap[7][5].setNum(pictureMap[7][6].getNum());
			pictureMap[7][6].setNum(pictureMap[7][7].getNum());
			pictureMap[7][7].setNum(pictureMap[7][8].getNum());
			pictureMap[7][8].setNum(num);
			break;
		case 8:// ��9��
			num = pictureMap[8][0].getNum();
			pictureMap[8][0].setNum(pictureMap[8][1].getNum());
			pictureMap[8][1].setNum(pictureMap[8][2].getNum());
			pictureMap[8][2].setNum(pictureMap[8][3].getNum());
			pictureMap[8][3].setNum(pictureMap[8][4].getNum());
			pictureMap[8][4].setNum(pictureMap[8][5].getNum());
			pictureMap[8][5].setNum(pictureMap[8][6].getNum());
			pictureMap[8][6].setNum(pictureMap[8][7].getNum());
			pictureMap[8][7].setNum(pictureMap[8][8].getNum());
			pictureMap[8][8].setNum(num);
			break;
		default:
			break;
		}
	}

	private void swipeRight(float startY) {
		GameTen.getGameTen().addType(1);
		int num;
		switch ((int) (startY / pictureWidth)) {
		case 0:// ��һ��
			num = pictureMap[0][0].getNum();
			pictureMap[0][0].setNum(pictureMap[0][8].getNum());
			pictureMap[0][8].setNum(pictureMap[0][7].getNum());
			pictureMap[0][7].setNum(pictureMap[0][6].getNum());
			pictureMap[0][6].setNum(pictureMap[0][5].getNum());
			pictureMap[0][5].setNum(pictureMap[0][4].getNum());
			pictureMap[0][4].setNum(pictureMap[0][3].getNum());
			pictureMap[0][3].setNum(pictureMap[0][2].getNum());
			pictureMap[0][2].setNum(pictureMap[0][1].getNum());
			pictureMap[0][1].setNum(num);
			break;
		case 1:// �ڶ���
			num = pictureMap[1][0].getNum();
			pictureMap[1][0].setNum(pictureMap[1][8].getNum());
			pictureMap[1][8].setNum(pictureMap[1][7].getNum());
			pictureMap[1][7].setNum(pictureMap[1][6].getNum());
			pictureMap[1][6].setNum(pictureMap[1][5].getNum());
			pictureMap[1][5].setNum(pictureMap[1][4].getNum());
			pictureMap[1][4].setNum(pictureMap[1][3].getNum());
			pictureMap[1][3].setNum(pictureMap[1][2].getNum());
			pictureMap[1][2].setNum(pictureMap[1][1].getNum());
			pictureMap[1][1].setNum(num);
			break;
		case 2:// ������
			num = pictureMap[2][0].getNum();
			pictureMap[2][0].setNum(pictureMap[2][8].getNum());
			pictureMap[2][8].setNum(pictureMap[2][7].getNum());
			pictureMap[2][7].setNum(pictureMap[2][6].getNum());
			pictureMap[2][6].setNum(pictureMap[2][5].getNum());
			pictureMap[2][5].setNum(pictureMap[2][4].getNum());
			pictureMap[2][4].setNum(pictureMap[2][3].getNum());
			pictureMap[2][3].setNum(pictureMap[2][2].getNum());
			pictureMap[2][2].setNum(pictureMap[2][1].getNum());
			pictureMap[2][1].setNum(num);
			break;
		case 3:// ������
			num = pictureMap[3][0].getNum();
			pictureMap[3][0].setNum(pictureMap[3][8].getNum());
			pictureMap[3][8].setNum(pictureMap[3][7].getNum());
			pictureMap[3][7].setNum(pictureMap[3][6].getNum());
			pictureMap[3][6].setNum(pictureMap[3][5].getNum());
			pictureMap[3][5].setNum(pictureMap[3][4].getNum());
			pictureMap[3][4].setNum(pictureMap[3][3].getNum());
			pictureMap[3][3].setNum(pictureMap[3][2].getNum());
			pictureMap[3][2].setNum(pictureMap[3][1].getNum());
			pictureMap[3][1].setNum(num);
			break;
		case 4:// ������
			num = pictureMap[4][0].getNum();
			pictureMap[4][0].setNum(pictureMap[4][8].getNum());
			pictureMap[4][8].setNum(pictureMap[4][7].getNum());
			pictureMap[4][7].setNum(pictureMap[4][6].getNum());
			pictureMap[4][6].setNum(pictureMap[4][5].getNum());
			pictureMap[4][5].setNum(pictureMap[4][4].getNum());
			pictureMap[4][4].setNum(pictureMap[4][3].getNum());
			pictureMap[4][3].setNum(pictureMap[4][2].getNum());
			pictureMap[4][2].setNum(pictureMap[4][1].getNum());
			pictureMap[4][1].setNum(num);
			break;
		case 5:// ������
			num = pictureMap[5][0].getNum();
			pictureMap[5][0].setNum(pictureMap[5][8].getNum());
			pictureMap[5][8].setNum(pictureMap[5][7].getNum());
			pictureMap[5][7].setNum(pictureMap[5][6].getNum());
			pictureMap[5][6].setNum(pictureMap[5][5].getNum());
			pictureMap[5][5].setNum(pictureMap[5][4].getNum());
			pictureMap[5][4].setNum(pictureMap[5][3].getNum());
			pictureMap[5][3].setNum(pictureMap[5][2].getNum());
			pictureMap[5][2].setNum(pictureMap[5][1].getNum());
			pictureMap[5][1].setNum(num);
			break;
		case 6:// ������
			num = pictureMap[6][0].getNum();
			pictureMap[6][0].setNum(pictureMap[6][8].getNum());
			pictureMap[6][8].setNum(pictureMap[6][7].getNum());
			pictureMap[6][7].setNum(pictureMap[6][6].getNum());
			pictureMap[6][6].setNum(pictureMap[6][5].getNum());
			pictureMap[6][5].setNum(pictureMap[6][4].getNum());
			pictureMap[6][4].setNum(pictureMap[6][3].getNum());
			pictureMap[6][3].setNum(pictureMap[6][2].getNum());
			pictureMap[6][2].setNum(pictureMap[6][1].getNum());
			pictureMap[6][1].setNum(num);
			break;
		case 7:// ��8��
			num = pictureMap[7][0].getNum();
			pictureMap[7][0].setNum(pictureMap[7][8].getNum());
			pictureMap[7][8].setNum(pictureMap[7][7].getNum());
			pictureMap[7][7].setNum(pictureMap[7][6].getNum());
			pictureMap[7][6].setNum(pictureMap[7][5].getNum());
			pictureMap[7][5].setNum(pictureMap[7][4].getNum());
			pictureMap[7][4].setNum(pictureMap[7][3].getNum());
			pictureMap[7][3].setNum(pictureMap[7][2].getNum());
			pictureMap[7][2].setNum(pictureMap[7][1].getNum());
			pictureMap[7][1].setNum(num);
			break;
		case 8:// ��9��
			num = pictureMap[8][0].getNum();
			pictureMap[8][0].setNum(pictureMap[8][8].getNum());
			pictureMap[8][8].setNum(pictureMap[8][7].getNum());
			pictureMap[8][7].setNum(pictureMap[8][6].getNum());
			pictureMap[8][6].setNum(pictureMap[8][5].getNum());
			pictureMap[8][5].setNum(pictureMap[8][4].getNum());
			pictureMap[8][4].setNum(pictureMap[8][3].getNum());
			pictureMap[8][3].setNum(pictureMap[8][2].getNum());
			pictureMap[8][2].setNum(pictureMap[8][1].getNum());
			pictureMap[8][1].setNum(num);
			break;
		default:
			break;
		}
	}

}

