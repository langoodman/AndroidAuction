package org.ctguwh.auction.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.ctguwh.app.base.AbsFragmentActivity;


public class ChooseItemActivity extends AbsFragmentActivity
		implements Callbacks
{
	@Override
	protected Fragment getFragment()
	{
		Fragment fragment = new ChooseItemFragment();
		Bundle args = new Bundle();
		args.putLong("kindId", getIntent()
				.getLongExtra("kindId", -1));
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onItemSelected(Integer id, Bundle bundle)
	{
		Intent intent = new Intent(this, AddBidActivity.class);
		intent.putExtra("itemId", bundle.getInt("itemId"));
		startActivity(intent);
	}
}
