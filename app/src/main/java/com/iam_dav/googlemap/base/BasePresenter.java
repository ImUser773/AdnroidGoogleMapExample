package com.iam_dav.googlemap.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by champ on 2/7/2560.
 */

public abstract class BasePresenter {

    protected BasePresenter() {}

    @CallSuper
    public void onCreate(@Nullable final Bundle savedInstanceState) {}

    @CallSuper
    public void onResume() {}

    @CallSuper
    public void onPause() {}

    @CallSuper
    public void onSaveInstanceState(@NonNull final Bundle outState) {}

    @CallSuper
    public void onDestroy() {}

}
