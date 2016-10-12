package spfworld.spfworld.adapter.Tribune;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import ab.util.AbToastUtil;
import spfworld.spfworld.R;
import spfworld.spfworld.activity.Tribune.ImagePagerActivity;
import spfworld.spfworld.entity.Tribune.Tribune;
import spfworld.spfworld.utils.ImageLoad;
import spfworld.spfworld.widget.percent.PercentLinearLayout;
import spfworld.spfworld.widget.percent.view.CircleImageView;

/**
 * Created by Administrator on 2016/8/31.
 */
public class TribuneAdapter extends RecyclerView.Adapter<TribuneAdapter.TextViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Tribune.DataBean> objects = new ArrayList<Tribune.DataBean>();
    private ImageLoad imageLoad;
    public static final int TEXT = 1;//文字
    public static final int IMG_TEXT = 2;//图片

    public TribuneAdapter(Context context, List<Tribune.DataBean> objects) {
        this.context = context;
        this.objects = objects;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        TextViewHolder viewHolder = null;
        switch (viewType) {
            case TEXT:
                itemView = inflater.inflate(R.layout.item_tribune, parent, false);
                viewHolder = new TextViewHolder(itemView);
                break;
            case IMG_TEXT:
                break;
        }
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final TextViewHolder holder, final int position) {
//        ImageLoad imageLoad=new ImageLoad();
//        imageLoad.HttpImage();
        ImageLoader.getInstance().displayImage("http://"+objects.get(position).getHeadpic(),holder.iv);
        holder.tvTitle.setText(objects.get(position).getUsername());
        holder.tvContent.setText(objects.get(position).getTitle());
        holder.tvInfo.setText(objects.get(position).getComment());
        holder.tvMinute.setText(objects.get(position).getCreated_at());
        holder.tvLove.setText(objects.get(position).getZan());
        holder.tvComment.setText(objects.get(position).getReplycount());
        if (objects.get(position).getPic()!=null&&objects.get(position).getPic().size()>0){
            holder.mGrid.setVisibility(View.VISIBLE);
            final String[] urls = objects.get(position).getPic().toArray(new String[objects.get(position).getPic().size()]);
            holder.mGrid.setAdapter(new GridAdapter(context, objects.get(position).getPic()));
            holder.mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    enterPhotoDetailed(urls, position);
                    AbToastUtil.showToast(context,"" +position);
                }
            });
        }else {
            holder.mGrid.setVisibility(View.GONE);

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnItemClickListener != null) {
                            mOnItemClickListener.onItemClick(v, objects.get(position).getC_id());
                        }
                    }
                });
        holder.ivLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.ivLove.isSelected()){
                    holder.ivLove.setSelected(false);
                }else {
                    holder.ivLove.setSelected(true);
                }
            }
        });
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
        Log.i("=======", "onClick: " + getItemCount());

    }
    @Override
    public int getItemCount() {
        return objects.size();
    }
    @Override
    public int getItemViewType(int position) {
        int type = 1;
//        if (List<Tribune.DataBean> objects) {
//            return TEXT;
//        } else if (List<Tribune.DataBean> objects) {
//            return IMG_TEXT;
//        }
        return type;
    }


    /**
     * 进入图片详情页
     * @param
     * @param position 角标
     */
    protected void enterPhotoDetailed(String[] urls, int position) {
        Intent intent = new Intent(context, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
        context.startActivity(intent);
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle,tvContent,tvInfo,tvMinute,minuteTv,tvComment,tvLove;
        private ImageView ivComment,ivLove;
        private CircleImageView iv;
        private GridView mGrid;
        private PercentLinearLayout all_layout;

        public TextViewHolder(View itemView) {
            super(itemView);
            all_layout = (PercentLinearLayout) itemView.findViewById(R.id.all_layout);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            tvInfo = (TextView) itemView.findViewById(R.id.tv_info);
            tvMinute = (TextView) itemView.findViewById(R.id.tv_minute);
            minuteTv = (TextView) itemView.findViewById(R.id.minute_tv);
            tvComment = (TextView) itemView.findViewById(R.id.tv_comment);
            tvLove = (TextView) itemView.findViewById(R.id.tv_love);
            ivLove = (ImageView) itemView.findViewById(R.id.iv_love);
            ivComment = (ImageView) itemView.findViewById(R.id.iv_comment);
            iv = (CircleImageView) itemView.findViewById(R.id.iv);
            mGrid = (GridView) itemView.findViewById(R.id.mGrid);
        }
    }


    //点击事件回调接口
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    /**
     * 点击事件的接口回调
     */
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

}
