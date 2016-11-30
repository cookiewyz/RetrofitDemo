package com.fengchao.retrofitdemo.cook;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wyz on 16/11/25.
 */

public class Cook {
    @SerializedName("result")
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
