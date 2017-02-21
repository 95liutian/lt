package com.lt.mail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.lt.mail.R;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class HomeFragment extends Fragment{
    private SliderLayout msliderLayout;
    private PagerIndicator mIndicator;
//    private RecyclerView mRecyclerView;
//    private HomeCategoryAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        msliderLayout = (SliderLayout)view.findViewById(R.id.slider);
        mIndicator = (PagerIndicator) view.findViewById(R.id.custom_indicator);
        initSlider();
        return view;
    }
    private void initSlider(){
        TextSliderView textSliderView = new TextSliderView(getActivity());
        textSliderView
                .description("新品推荐")
                .image("http://101.200.167.75:8080/phoenixshop/img/banner/582d4f6eN1d3c912c.jpg")
                .setScaleType(BaseSliderView.ScaleType.Fit);//设置图片的宽高

        TextSliderView textSliderView2 = new TextSliderView(getActivity());
        textSliderView2
                .description("时尚男装")
                .image("http://101.200.167.75:8080/phoenixshop/img/banner/57ff4039N709820d2.jpg")
                .setScaleType(BaseSliderView.ScaleType.Fit);//设置图片的宽和高

        TextSliderView textSliderView3 = new TextSliderView(getActivity());
        textSliderView3
                .description("家电秒杀")
                .image("http://101.200.167.75:8080/phoenixshop/img/banner/582ae45dNa57e1349.jpg")
                .setScaleType(BaseSliderView.ScaleType.Fit);//设置图片的宽和高

        msliderLayout.addSlider(textSliderView);
        msliderLayout.addSlider(textSliderView2);
        msliderLayout.addSlider(textSliderView3);
//      设置默认指示器，样式就是三个圆点的指示器
//      msliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        //设置自定义的指示器
        msliderLayout.setCustomIndicator(mIndicator);
        //设置自定义动画,文字部分是由下向上冒出来的
        msliderLayout.setCustomAnimation(new DescriptionAnimation());
//      设置转场效果
        msliderLayout.setPresetTransformer(SliderLayout.Transformer.RotateUp);
//      设置时间，多少秒一转
        msliderLayout.setDuration(3000);
    }
    //绑定生命周期 结束同步
    @Override
    public void onStop() {
        msliderLayout.stopAutoCycle();
        super.onStop();
    }
}
