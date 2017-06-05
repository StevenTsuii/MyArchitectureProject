package com.steventsui.testarchitecture.datasource;

import com.steventsui.testarchitecture.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 26/5/2017.
 */

public class LocalDataSource {

    public static List<UserModel> getUserList() {
        List<UserModel> userModels = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            UserModel userModel = new UserModel("User " + i, i, "address " + i);
            userModels.add(userModel);
        }
        return userModels;
    }
}
