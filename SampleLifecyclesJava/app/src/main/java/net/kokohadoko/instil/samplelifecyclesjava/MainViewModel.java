package net.kokohadoko.instil.samplelifecyclesjava;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

/**
 * Created by katsuya on 2017/10/30.
 */

public class MainViewModel extends ViewModel {

    @Nullable
    private Long startDate;

    @Nullable
    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(final long startDate) {
        this.startDate = startDate;
    }
}
