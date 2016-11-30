package com.fengchao.retrofitdemo.cook;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wyz on 16/11/25.
 */

public class Result {
    @SerializedName("data")
    List<CookBean> cookBeanList;

    public List<CookBean> getCookBeanList() {
        return cookBeanList;
    }

    public void setCookBeanList(List<CookBean> cookBeanList) {
        this.cookBeanList = cookBeanList;
    }
}
