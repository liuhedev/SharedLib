package com.cleverlib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * @author liuhea
 * @created 16-11-24
 */
public abstract class BaseFragment extends Fragment {

    protected static final String TAG = BaseFragment.class.getSimpleName();
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(getContentViewId(), container, false);

        return mRootView;
    }

    protected abstract int getContentViewId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}


