package spfworld.spfworld.adapter.Tribune;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.Tribune.TribnueCommentReplyData;

public class CommentReplyAdapter extends BaseAdapter {
	private Context mcontext;
	private LayoutInflater inflater;
	private ArrayList<TribnueCommentReplyData.DataBean.CengzhuBean> list; // 二级评论数据
	private ViewHolder viewHolder;

	public CommentReplyAdapter(Context context,
							   ArrayList<TribnueCommentReplyData.DataBean.CengzhuBean> list) {
		this.mcontext = mcontext;
		this.list = list;
		inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		return list.size();
	}

//	public void clearList() {
//		this.list.clear();
//	}
//
//	public void updateList(ArrayList<TribnueCommentReplyData.DataBean.CengzhuBean> list_comment) {
//		this.list.addAll(list_comment);
//	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}
	@Override
	public long getItemId(int position) {
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_comment_reply, parent,false);
			holder.tv_comment_reply_text = (TextView) convertView
					.findViewById(R.id.tv_comment_reply_text);
			holder.tv_comment_reply_writer = (TextView) convertView
					.findViewById(R.id.tv_comment_reply_writer);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		initiamylistViews((TribnueCommentReplyData.DataBean.CengzhuBean)getItem(position), (ViewHolder) convertView.getTag());
		return convertView;
	}

	public void initiamylistViews(TribnueCommentReplyData.DataBean.CengzhuBean list, ViewHolder holder){
		if (list.getR_id()!=null){
			holder.tv_comment_reply_writer.setText(list.getUsername());
			holder.tv_comment_reply_text.setText(list.getReplys());
		}
	}
	public class ViewHolder {
		private TextView tv_comment_reply_writer; // 评论者昵称
		private TextView tv_comment_reply_text; // 评论 内容
	}
}
