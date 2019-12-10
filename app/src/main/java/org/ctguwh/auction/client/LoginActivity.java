package org.ctguwh.auction.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.ctguwh.auction.client.util.DialogUtil;
import org.ctguwh.auction.client.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录
 */
public class LoginActivity extends Activity
{
	// 定义界面中两个文本框
	private EditText etName;
	private EditText etPass;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		// 获取界面中两个编辑框
		etName = findViewById(R.id.userEditText);
		etPass = findViewById(R.id.pwdEditText);
		// 定义并获取界面中3个按钮
		Button bnLogin = findViewById(R.id.bnLogin);
		Button bnCancel = findViewById(R.id.bnCancel);
		Button bnRegister = findViewById(R.id.bnRegister);

		// 为bnCancal按钮的单击事件绑定事件监听器
		bnCancel.setOnClickListener(new HomeListener(this));
		//登录事件
		bnLogin.setOnClickListener(view -> {
			// 执行输入校验
			if (validate()) // ①
			{
				// 如果登录成功
				if (loginPro()) // ②
				{
					// 启动AuctionClientActivity
					Intent intent = new Intent(LoginActivity.this, AuctionClientActivity.class);
					startActivity(intent);
					// 结束该Activity
					finish();
				}
				else
				{
					DialogUtil.showDialog(LoginActivity.this,
							"用户名或者密码错误，请重新输入！", false);
				}
			}
		});
		//注册事件
		bnRegister.setOnClickListener(view -> {
			// 执行输入校验
			if (validate()) // ①
			{
				// 如果注册成功
				if (registerPro()) // ②
				{
					DialogUtil.showDialog(LoginActivity.this,
							"注册成功，赶快登录吧！", false);
					// 启动AuctionClientActivity
//					Intent intent = new Intent(LoginActivity.this, AuctionClientActivity.class);
					Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
					startActivity(intent);
					// 结束该Activity
					finish();
				}
				else
				{
					DialogUtil.showDialog(LoginActivity.this,
							"注册失败，服务器响应异常，请稍后再试！", false);
				}
			}
		});
	}

	//判断是否登录成功
	private boolean loginPro()
	{
		// 获取用户输入的用户名、密码
		String username = etName.getText().toString();
		String pwd = etPass.getText().toString();
		try
		{
			String result = query(username, pwd);
			// 如果result大于0
			if (result != null && Integer.parseInt(result) > 0)
			{
				return true;
			}
		}
		catch (Exception e)
		{
			DialogUtil.showDialog(this, "服务器响应异常，请稍后再试！", false);
			e.printStackTrace();
		}
		return false;
	}

	//判断是否注册成功
	private boolean registerPro()
	{
		// 获取用户输入的用户名、密码
		String username = etName.getText().toString();
		String pwd = etPass.getText().toString();
		try
		{
			String result = register(username, pwd);
			// 如果result大于0
			if (result != null && Integer.parseInt(result) > 0)
			{
				return true;
			}
		}
		catch (Exception e)
		{
			DialogUtil.showDialog(this, "服务器响应异常，请稍后再试！", false);
			e.printStackTrace();
		}
		return false;
	}
	// 对用户输入的用户名、密码进行校验
	private boolean validate()
	{
		String username = etName.getText().toString().trim();
		if (username.equals(""))
		{
			DialogUtil.showDialog(this, "用户账户是必填项！", false);
			return false;
		}
		String pwd = etPass.getText().toString().trim();
		if (pwd.equals(""))
		{
			DialogUtil.showDialog(this, "用户口令是必填项！", false);
			return false;
		}
		return true;
	}

	// 定义发送请求的方法 登录
	private String query(String username, String password) throws Exception
	{
		// 使用Map封装请求参数
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("userpass", password);
		// 定义发送请求的URL
		String url = HttpUtil.BASE_URL + "users/login";
		// 发送请求
		return HttpUtil.postRequest(url, map);
	}

	/**
	 * 注册
	 * @param username
	 * @param password
	 * @return
	 */
	private String register(String username, String password) throws Exception
	{
		// 使用Map封装请求参数
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("userpass", password);
		// 定义发送请求的URL
		String url = HttpUtil.BASE_URL + "users/register";
		// 发送请求
		return HttpUtil.postRequest(url, map);
	}
}
