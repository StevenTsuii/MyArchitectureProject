package livedata;

import android.arch.lifecycle.LiveData;
import android.support.annotation.Nullable;

import com.steventsui.testarchitecture.model.UserModel;

import java.util.List;

/**
 * Created by steven on 29/5/2017.
 */

public class UserModelsLiveData extends LiveData<List<UserModel>>{

    @Override
    protected void setValue(List<UserModel> value) {
        super.setValue(value);
    }

    @Nullable
    @Override
    public List<UserModel> getValue() {
        return super.getValue();
    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
