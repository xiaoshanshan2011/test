package com.pub.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.junshan.pub.widget.ZLayout;
import com.pub.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjunshan on 12/21/17.
 */

public class SearchView extends RelativeLayout implements View.OnClickListener {
    private Context mContext;
    private TextView tvSearch;
    private ZLayout zlLsss;//历史搜索
    private ZLayout zlRmbq;//热门标签

    public SearchView(Context context) {
        super(context);
        mContext = context;
        initView();
        initEvent();
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initEvent();
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initEvent();
    }

    private void initView() {
        View.inflate(mContext, R.layout.sv_layout, this);
        tvSearch = (TextView) findViewById(R.id.tv_search);
        zlLsss = (ZLayout) findViewById(R.id.zl_ssls);
        zlRmbq = (ZLayout) findViewById(R.id.zl_rmbq);
        binData();
    }

    private void initEvent() {
        setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:

                break;
        }
    }

    private void binData() {
        List<String> data = new ArrayList<>();
        data.add("阿迪达斯");
        data.add("陶瓷");
        data.add("零食");
        data.add("护手霜");
        data.add("水电费");
        data.add("阿萨德");
        data.add("爱施德");
        data.add("阿萨所");
        data.add("青蛙");
        data.add("订单");
        zlLsss.removeAllViews();
        zlRmbq.removeAllViews();
        for (int i = 0; i < data.size(); i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.text_item_layout, null);
            TextView textView = (TextView) view.findViewById(R.id.tv);
            textView.setText(data.get(i));
            zlRmbq.addView(view);
        }
        for (int i = 0; i < data.size(); i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.text_item_layout, null);
            TextView textView = (TextView) view.findViewById(R.id.tv);
            textView.setText(data.get(i));
            zlLsss.addView(view);
        }
    }
}
