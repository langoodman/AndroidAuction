package org.ctguwh.app.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;


public abstract class AbsFragmentActivity extends FragmentActivity
{
	public static final int ROOT_CONTAINER_ID = 0x90001;
	protected abstract Fragment getFragment();
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);
		setContentView(layout);
		layout.setId(ROOT_CONTAINER_ID);
		getSupportFragmentManager().beginTransaction()
				.replace(ROOT_CONTAINER_ID, getFragment())
				.commit();
	}
}
