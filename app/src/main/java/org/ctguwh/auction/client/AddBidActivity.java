package org.ctguwh.auction.client;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.ctguwh.app.base.AbsFragmentActivity;

/**
 * 在Activity中创建Bundle数据包,调用Fragment实例的setArguments(bundle) 从而将Bundle数据包传给Fragment,
 * 然后Fragment中调用getArguments获得 Bundle对象,然后进行解析就可以了
 */
public class AddBidActivity extends AbsFragmentActivity
{
	@Override
	public Fragment getFragment()
	{
		Fragment fragment = new AddBidFragment();
		Bundle args = new Bundle();
		args.putInt("itemId", getIntent().getIntExtra("itemId", -1));
		fragment.setArguments(args);
		return fragment;
	}
}
