package org.ctguwh.auction.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.ctguwh.auction.client.util.DialogUtil;
import org.ctguwh.auction.client.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 修改密码
 */
public class ChangePassFragment extends Fragment
{
	// 定义界面中两个文本框
	private EditText newPass;
	private EditText surePass;

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.changepass, container, false);
		// 获取界面中两个编辑框
		newPass = rootView.findViewById(R.id.newpass);
		surePass = rootView.findViewById(R.id.surepass);
		// 定义并获取界面中两个按钮
		Button bnChange = rootView.findViewById(R.id.bnChange);
		Button bnCancel = rootView.findViewById(R.id.bnCancel);
		// 为取消按钮的单击事件绑定事件监听器
		bnCancel.setOnClickListener(new HomeListener(getActivity()));
		bnChange.setOnClickListener(view -> {
			// 输入校验
			if (validate())
			{
				// 获取用户输入新密码 确认密码
				String newPassword = newPass.getText().toString();
				String surePassword = surePass.getText().toString();
				try
				{
					// 修改密码
					String result = changePassword(newPassword, surePassword);
					if (result != null && Integer.parseInt(result) > 0)
					{
						DialogUtil.showDialog(getActivity(),
								"修改成功，请重新登录吧！", false);
						Intent intent = new Intent(getActivity(), LoginActivity.class);
						startActivity(intent);
					}
					else{
						DialogUtil.showDialog(getActivity(), "服务器响应异常，请稍后再试！", false);
					}
				}
				catch (Exception e)
				{
					DialogUtil.showDialog(getActivity(), "服务器响应异常，请稍后再试！", false);
					e.printStackTrace();
				}
			}
		});
		return rootView;
	}


	// 对用户输入的密码进行校验
	private boolean validate()
	{

		String newPassw = newPass.getText().toString().trim();
		if (newPassw.equals(""))
		{
			DialogUtil.showDialog(getActivity(), "新密码是必填项！", false);
			return false;
		}
		String surePassw = surePass.getText().toString().trim();
		if (surePassw.equals(""))
		{
			DialogUtil.showDialog(getActivity(), "确认密码是必填项！", false);
			return false;
		}
		System.out.println(surePassw);
		System.out.println(newPassw);
		if (!surePassw.equals(newPassw))
		{
			DialogUtil.showDialog(getActivity(), "两次密码不一样！", false);
			return false;
		}
		return true;
	}

	/**
	 * 修改密码
	 * @param newpass
	 * @param surepass
	 * @return
	 */
	// 定义发送请求的方法 修改密码
	private String changePassword(String newpass, String surepass) throws Exception
	{
		// 使用Map封装请求参数
		Map<String, String> map = new HashMap<>();
		map.put("newpass", newpass);
		map.put("surepass", surepass);
		// 定义发送请求的URL
		String url = HttpUtil.BASE_URL + "users/changepass";
		// 发送请求
		return HttpUtil.postRequest(url, map);
	}


}
