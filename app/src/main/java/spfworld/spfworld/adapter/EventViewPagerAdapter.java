package spfworld.spfworld.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/12.
 * EventViewPagerAdapter
 * 活动页滑动适配器
 */
public class EventViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;
    public EventViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public EventViewPagerAdapter(FragmentManager fm,List<Fragment> mList){
        this(fm);
        this.mList=mList;
    }
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }
    @Override
    public int getCount() {
        return mList.size();
    }
}
