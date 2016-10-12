package ab.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 常见问题adapter
 * @author Administrator
 * @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
	protected Context mContext;// 上下文
	protected List<T> mDatas;// 数据源
	protected LayoutInflater mInflater;// 布局填充器
	protected int mLayoutId;// id

	public CommonAdapter(Context context, List<T> datas, int layoutId) {
		this.mContext = context;
		this.mDatas = datas;
		mInflater = LayoutInflater.from(context);
		this.mLayoutId = layoutId;
	}

	public void setData(List<T> datas) {
		mDatas = datas;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mLayoutId, position);
		convert(holder, getItem(position), position);
		return holder.getConvertView();
	};

	/**
	 * 获取Data
	 */
	public List<T> getDatas() {
		return mDatas;
	}

	/**
	 * 添加Item到指定的位置
	 * 
	 * @param position
	 *            the position
	 * @param
	 */
	public void addItem(int position, T t) {
		mDatas.add(position, t);
		notifyDataSetChanged();
	}

	/**
	 * 添加Item
	 * 
	 * @param
	 *
	 * @param
	 *
	 */
	public void addItem(T t) {
		mDatas.add(t);
		notifyDataSetChanged();
	}

	/**
	 * 添加List到原List中
	 * 
	 *            the image paths
	 */
	public void addItems(List<T> t) {
		mDatas.addAll(t);
		notifyDataSetChanged();
	}

	/**
	 * 清除所有数据
	 */
	public void clearItems() {
		mDatas.clear();
		notifyDataSetChanged();
	}

	/**
	 * 清除某一条数据
	 */
	public void clearItem(int index) {
		mDatas.remove(index);
		notifyDataSetChanged();
	}

	public Activity getActivity() {
		return (Activity) mContext;
	}

	public abstract void convert(ViewHolder holder, T t, int position);
}
