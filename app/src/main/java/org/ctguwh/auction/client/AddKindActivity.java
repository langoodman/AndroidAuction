package org.ctguwh.auction.client;

import android.support.v4.app.Fragment;

import org.ctguwh.app.base.AbsFragmentActivity;


public class AddKindActivity extends AbsFragmentActivity
{
	@Override
	public Fragment getFragment()
	{
		return new AddKindFragment();
	}
}
