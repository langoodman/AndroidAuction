package org.ctguwh.auction.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.ctguwh.app.base.AbsFragmentActivity;


public class ManageKindActivity extends AbsFragmentActivity
		implements Callbacks
{
	@Override
	protected Fragment getFragment()
	{
		return new ManageKindFragment();
	}

	@Override
	public void onItemSelected(Integer id, Bundle bundle)
	{
		// 当用户单击ManageKindFragment中添加按钮时，启动AddKindActivity
		Intent i = new Intent(this, AddKindActivity.class);
		startActivity(i);
	}
}
