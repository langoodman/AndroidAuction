package org.ctguwh.auction.client;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * 主页监听
 */
class HomeListener implements View.OnClickListener
{
	private Activity activity;
	HomeListener(Activity activity)
	{
		this.activity = activity;
	}
	@Override
	public void onClick(View source)
	{
		Intent i = new Intent(activity, AuctionClientActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		activity.startActivity(i);
	}
}
