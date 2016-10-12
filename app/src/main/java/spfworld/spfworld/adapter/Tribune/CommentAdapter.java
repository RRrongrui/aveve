package spfworld.spfworld.adapter.Tribune;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.Tribune.TribnueCommentReplyData;
import spfworld.spfworld.utils.Contants;
import spfworld.spfworld.widget.percent.view.MyListView;

public class CommentAdapter extends BaseAdapter {
	private View.OnClickListener myOnitemcListener =null;
	private LayoutInflater inflater;
	private List<TribnueCommentReplyData.DataBean> list_comment =new ArrayList<TribnueCommentReplyData.DataBean>(); // 一级评论数据
	private Context context;
	private CommentReplyAdapter myAdapter;

	public CommentAdapter(Context context,
						  ArrayList<TribnueCommentReplyData.DataBean> list_comment) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.list_comment = list_comment;
//		this.list_comment.addAll(list_comment);

	}

	@Override
	public int getCount() {
		return list_comment.size();
	}

	@Override
	public Object getItem(int position) {
		return list_comment.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final  int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_comment_layout, null);
			convertView.setTag(new ViewHolder(convertView));
		}
			initialieViews((TribnueCommentReplyData.DataBean) getItem(position), (ViewHolder) convertView.getTag(),position);
			return convertView;
		}
	public void initialieViews(TribnueCommentReplyData.DataBean list_comment,ViewHolder holder,final int position){
		ImageLoader.getInstance().displayImage(Contants.IMAGE_BASE_URL2+list_comment.getHeadpic(),holder.iv_user_photo);
		if (list_comment.getR_id()!=null){
			holder.tv_user_name.setText(list_comment.getUsername());
			holder.tv_user_comment.setText(list_comment.getReplys());
			holder.tv_rid.setText(list_comment.getR_id());
			holder.tv_time.setText(list_comment.getCreated_at());
		}
		if (list_comment.getCengzhu()!=null&&list_comment.getCengzhu().size()>0){
			myAdapter = new CommentReplyAdapter(context, (ArrayList<TribnueCommentReplyData.DataBean.CengzhuBean>) list_comment.getCengzhu());
			holder.lv_user_comment_replys.setAdapter(myAdapter);
		}
		holder.bt_topic_coment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (commentCallBack !=null){
					commentCallBack.showCommentPop(position);

//					TribuneDatailsFragment.

				}
			}
		});

	}

	public void setCommentCallBack(ICommentCallBack commentCallBack) {
		this.commentCallBack = commentCallBack;
	}

	private  ICommentCallBack commentCallBack;

	public interface ICommentCallBack{
		void showCommentPop(int index);//下标
	}
//	private

	public class ViewHolder {
		private ImageView iv_user_photo; // 品论者 头像
		private TextView tv_user_name; // 品论者 昵称
		private TextView tv_user_comment; // 品论者 一级品论内容
		private ImageView bt_topic_coment; // 品论者 二级品论内容点击事件
		private MyListView lv_user_comment_replys; // 品论者 二级品论内容列表
		private TextView tv_rid;//楼层
		private TextView tv_time;//层主回复时间

		public ViewHolder(View itemview) {
			iv_user_photo = (ImageView) itemview
					.findViewById(R.id.iv);
			tv_user_name = (TextView) itemview
					.findViewById(R.id.tv_title);
			tv_user_comment = (TextView) itemview
					.findViewById(R.id.tv_date);
			tv_rid = (TextView) itemview
					.findViewById(R.id.tv_floor2_two);
			bt_topic_coment = (ImageView) itemview
					.findViewById(R.id.bt_topic_coment);
			lv_user_comment_replys = (MyListView) itemview
					.findViewById(R.id.lv_user_comment_replys);
			tv_time = (TextView) itemview
					.findViewById(R.id.tv_date_two);
		}
	}
}
