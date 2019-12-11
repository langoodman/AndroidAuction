package org.ctguwh.auction.client;

import android.support.v4.app.Fragment;

import org.ctguwh.app.base.AbsFragmentActivity;

public class ChangePassActivity extends AbsFragmentActivity {
	@Override
	protected Fragment getFragment() {
		return new ChangePassFragment();
	}

}