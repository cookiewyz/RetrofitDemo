package com.fengchao.retrofitdemo.cook;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fengchao.retrofitdemo.R;
import com.fengchao.retrofitdemo.databinding.CookItemBinding;

import java.util.List;

/**
 * Created by wyz on 16/11/25.
 */

public class MyAdapter extends BaseAdapter {

    private List<CookBean> list;
    Context context;

    public MyAdapter(List<CookBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                CookItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.cook_item, parent, false);
                convertView = binding.getRoot();
                convertView.setTag(binding);
            }

        CookItemBinding itemBinding = (CookItemBinding) convertView.getTag();
        itemBinding.setCook(list.get(position));


        return convertView;
    }
}
