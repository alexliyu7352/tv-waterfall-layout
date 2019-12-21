package com.msisuzney.tv.demo.lbpresenter;

import com.msisuzney.tv.demo.MyStateChangeObservable;
import com.msisuzney.tv.demo.bean.StateBean;
import com.msisuzney.tv.demo.bean.TabBean;
import com.msisuzney.tv.waterfallayout.leanback.Presenter;
import com.msisuzney.tv.waterfallayout.leanback.PresenterSelector;

import com.msisuzney.tv.waterfallayout.OnItemKeyListener;

/**
 * @author: chenxin
 * @date: 2019-12-20
 * @email: chenxin7930@qq.com
 */

/**
 * 行中的运营位的选择器
 */
public class BlockPresenterSelector extends PresenterSelector {

    private ImageViewPresenter imageViewPresenter;
    private ImageViewPresenter2 imageViewPresenter2;
    private StateTextViewPresenter stateTextViewPresenter;

    public BlockPresenterSelector(MyStateChangeObservable observable,
                                  OnItemKeyListener onItemKeyListener) {
        imageViewPresenter = new ImageViewPresenter(onItemKeyListener);
        imageViewPresenter2 = new ImageViewPresenter2(onItemKeyListener);
        stateTextViewPresenter = new StateTextViewPresenter(observable);
    }

    @Override
    public Presenter getPresenter(Object item) {
        if (item instanceof TabBean.ResultBean.AbsLayoutListBean) {
            return imageViewPresenter;
        } else if (item instanceof TabBean.ResultBean.HorizontalLayoutListBean) {
            return imageViewPresenter2;
        } else if (item instanceof StateBean) {
            return stateTextViewPresenter;
        }
        return null;
    }
}
