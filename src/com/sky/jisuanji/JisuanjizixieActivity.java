package com.sky.jisuanji;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JisuanjizixieActivity extends Activity {
	private int option = 0;//运算符状态
	private boolean newdigital=true;//标记是否是新输入的数字
	private double a=0,b=0;//两个相加的数
	private double c;//表示取正负
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button button0;
	private Button buttonjia;
	private Button buttonjian;
	private Button buttonchen;
	private Button buttonchu;
	private Button buttonzhenfu;
	private Button buttondenyu;
	private Button buttonxiaoshudian;
	private Button buttonqingchu;
	private Button buttonkaifang;
	private Button buttonzhishu;
	private Button buttoncos;
	private Button buttonsin;


	public void onCreate(Bundle savedInstanceState)
	{
		Log.v("onCreate", "开始运行计算机");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button0=(Button)findViewById(R.id.btn0);
		button1=(Button)findViewById(R.id.btn1);
		button2=(Button)findViewById(R.id.btn2);
		button3=(Button)findViewById(R.id.btn3);
		button4=(Button)findViewById(R.id.btn4);
		button5=(Button)findViewById(R.id.btn5);
		button6=(Button)findViewById(R.id.btn6);
		button7=(Button)findViewById(R.id.btn7);
		button8=(Button)findViewById(R.id.btn8);
		button9=(Button)findViewById(R.id.btn9);
		buttonjia=(Button)findViewById(R.id.jia);
		buttonjian=(Button)findViewById(R.id.jian);
		buttonchen=(Button)findViewById(R.id.chen);
		buttonchu=(Button)findViewById(R.id.chu);
		buttonzhenfu=(Button)findViewById(R.id.zhenfu);
		buttondenyu=(Button)findViewById(R.id.denyu);
		buttonqingchu=(Button)findViewById(R.id.qingchu);
		buttonxiaoshudian=(Button)findViewById(R.id.xiaoshudian);
		buttonkaifang=(Button)findViewById(R.id.kaifang);
		buttonzhishu=(Button)findViewById(R.id.zhishu);
		buttoncos=(Button)findViewById(R.id.cos);
		buttonsin=(Button)findViewById(R.id.sin);


		button0.setOnClickListener(lisenter);
		button1.setOnClickListener(lisenter);
		button2.setOnClickListener(lisenter);
		button3.setOnClickListener(lisenter);
		button4.setOnClickListener(lisenter);
		button5.setOnClickListener(lisenter);
		button6.setOnClickListener(lisenter);
		button7.setOnClickListener(lisenter);
		button8.setOnClickListener(lisenter);
		button9.setOnClickListener(lisenter);
		buttonjia.setOnClickListener(lisenter);
		buttonjian.setOnClickListener(lisenter);
		buttonchen.setOnClickListener(lisenter);
		buttonchu.setOnClickListener(lisenter);
		buttondenyu.setOnClickListener(lisenter);
		buttonzhenfu.setOnClickListener(lisenter);
		buttonqingchu.setOnClickListener(lisenter);
		buttonxiaoshudian.setOnClickListener(lisenter);
		buttonkaifang.setOnClickListener(lisenter);
		buttonzhishu.setOnClickListener(lisenter);
		buttoncos.setOnClickListener(lisenter);
		buttonsin.setOnClickListener(lisenter);
	}

	private OnClickListener lisenter=new OnClickListener() {

		public void onClick(View v) {
			TextView viewText = (TextView) findViewById(R.id.editText1);
			TextView text = (TextView) findViewById(R.id.text);
			String s = text.getText().toString();//获取文本框显示的字符串
			Button btn =(Button)v;
			String t=(String) btn.getText();//获取按钮的字符
			if(btn.getId()==R.id.btn0||btn.getId()==R.id.btn1||btn.getId()==R.id.btn2||btn.getId()==R.id.btn3
					||btn.getId()==R.id.btn4||btn.getId()==R.id.btn5||btn.getId()==R.id.btn6||
					btn.getId()==R.id.btn7||btn.getId()==R.id.btn8||btn.getId()==R.id.btn9) {
				if (newdigital) {
					text.setText(s + t);
				} else {
					text.setText(s);
					newdigital = false;
				}
				return;
			}

			if(btn.getId()==R.id.zhenfu)//改变数的正负性
			{ 
				//			c=Double.parseDouble(s);
				//			text.setText(String.valueOf(-c));
				//			return;
				if(s.length()==0) {
					a=0;
					b=0;
					option=0;
					newdigital=true;
					text.setText("");
					viewText.setText("");
					return;
				} else if(s!="") {
					c=Double.parseDouble(s);
					text.setText(String.valueOf(-c));
					newdigital=true;
					return;
				}	
			}

			if(btn.getId()==R.id.jia)//加
			{ 
				a=Double.parseDouble(s);
				option=1;
				text.setText("");
				viewText.setText(a+"+");
				return;
			}

			if(btn.getId()==R.id.jian)//减
			{ 
				a=Double.parseDouble(s);
				option=2;
				text.setText("");
				viewText.setText(a+"-");
				return;
			}

			if(btn.getId()==R.id.chen)//乘
			{ 
				a=Double.parseDouble(s);
				option=3;
				text.setText("");
				viewText.setText(a+"×");
				return;
			}

			if(btn.getId()==R.id.chu)//除
			{ 
				a=Double.parseDouble(s);
				option=4;
				text.setText("");
				viewText.setText(a+"÷");
				return;
			}

			if(btn.getId()==R.id.qingchu)//清除
			{ 
				a=0;
				b=0;
				option=0;
				newdigital=true;
				text.setText("");
				viewText.setText("");
				return;
			}
			if(btn.getId()==R.id.kaifang)//开方
			{   
				if(s.length()==0)
				{
					a=0;
					b=0;
					option=0;
					newdigital=true;
					text.setText("");
					viewText.setText("");
					return;
				}
				else if(s!="")
				{
					double i=Double.parseDouble(s);
					if(i>=0)
					{
						a=Math.sqrt(i);
						viewText.setText("√"+i+"=");
						text.setText(String.valueOf(a));
						newdigital=true;
						return;
					}
					else 
					{
						a=0;
						b=0;
						option=0;
						newdigital=true;
						text.setText("");
						viewText.setText("");
						return;	
					}
				}
			}

			if(btn.getId()==R.id.sin)//sin
			{ 
				if(s.length()==0)
				{
					a=0;
					b=0;
					option=0;
					newdigital=true;
					text.setText("");
					viewText.setText("");
					return;
				}
				else if(s!="")
				{
					a=Math.sin(Double.parseDouble(s));
					text.setText(String.valueOf(a));
					viewText.setText("sin("+s+")=");
					newdigital=true;
					return;
				}			
			}

			if(btn.getId()==R.id.cos)//cos
			{ 
				if(s.length()==0)
				{
					a=0;
					b=0;
					option=0;
					newdigital=true;
					text.setText("");
					viewText.setText("");
					return;
				}
				else if(s!="")
				{
					a=Math.cos(Double.parseDouble(s));
					text.setText(String.valueOf(a));
					viewText.setText("cos("+s+")=");
					newdigital=true;
					return;
				}	
			}

			if(btn.getId()==R.id.zhishu)//指数
			{ 
				a = Double.parseDouble(s);
				option = 5;
				text.setText("");
				viewText.setText(a+"^");
				return;
			}

			if(btn.getId()==R.id.xiaoshudian)//小数点
			{ 
				if(s.indexOf(".")==-1)
					if(s.trim().startsWith("0"))
					{
						text.setText("0.");
						newdigital=true;
					}
					else
					{
						text.setText(s+".");

					}
				return;
			}

			if(btn.getId()==R.id.denyu)//等于号
			{ 
				b=Double.parseDouble(s);
				switch(option)
				{
				case 1:
					viewText.setText(a+"+"+b+"=");
					text.setText(String.valueOf(a+b));break;
				case 2:
					viewText.setText(a+"-"+b+"=");
					text.setText(String.valueOf(a-b));break;
				case 3:
					viewText.setText(a+"×"+b+"=");
					text.setText(String.valueOf(a*b));break;
				case 4:
				{
					if(b!=0)
					{
						viewText.setText(a+"÷"+b+"=");
						text.setText(String.valueOf(a/b));}
					else
					{
						Toast.makeText(JisuanjizixieActivity.this, "除数不能为0！", Toast.LENGTH_SHORT).show();
						text.setText("");
						viewText.setText("");
						a=0;
						b=0;
						option=0;
						newdigital=true;
						return;
					}
					break;
				}
				case 5:
					viewText.setText(a+"^"+b+"=");
					text.setText(String.valueOf(Math.pow(a, b)));break;
				}

				return;
			}
		}

	};

	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 1, "退出");
		menu.add(0, 2, 2, "关于");
		menu.add(0, 3, 3, "帮助");
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==1){finish();}
		if(item.getItemId()==2){Toast.makeText(JisuanjizixieActivity.this, "作者:sky   联系:1174586290@qq.com  \n wyl修改", Toast.LENGTH_LONG).show();}
		if(item.getItemId()==3){Toast.makeText(JisuanjizixieActivity.this, "额，还没有想好", Toast.LENGTH_LONG).show();}
		return super.onOptionsItemSelected(item);
	}


}