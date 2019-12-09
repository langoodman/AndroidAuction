package org.ctguwh.auction.client;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.ctguwh.app.base.AbsFragmentActivity;

public class ViewItemActivity extends AbsFragmentActivity
{
	@Override
	protected Fragment getFragment()
	{
		Fragment fragment = new ViewItemFragment();
		Bundle arguments = new Bundle();
		arguments.putString("action", getIntent().getStringExtra("action"));
		fragment.setArguments(arguments);
		return fragment;
	}
}
