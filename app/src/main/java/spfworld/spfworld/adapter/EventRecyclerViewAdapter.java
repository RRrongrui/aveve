package spfworld.spfworld.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.alipay.android.phone.mrpc.core.o;

import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.Content;

/**
 * Created by guozhengke on 2016/9/22.
 * 选择商品页日期滑动适配器
 */
public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder>{
    private List<String> data;
    private LayoutInflater layoutInflater;
    private EventRecyclerViewItemClickListener eventRecyclerViewItemClickListener=null;
    private int layoutPosition;
    public EventRecyclerViewAdapter(Context context,List<String> data){
        this.data=data;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public EventRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.viewitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextView.setText(data.get(position));
        holder.itemView.setTag(data.get(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutPosition = holder.getLayoutPosition();
                notifyDataSetChanged();
                eventRecyclerViewItemClickListener.onItemClick(holder.itemView, (String) holder.itemView.getTag(), layoutPosition);
            }
        });
        //更改状态
        if(position == layoutPosition){
            holder.mTextView.setBackgroundResource(R.color.event_merchandise_grid);
            holder.mTextView.setTextColor(Color.WHITE);
            Content.RCTime=data.get(position);
        }else{
            holder.mTextView.setBackgroundResource(R.color.listview_item_normal);
            holder.mTextView.setTextColor(Color.BLACK);
        }

    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView);

        }
    }

    //回调
    public interface EventRecyclerViewItemClickListener {
        public void onItemClick(View view, String data,int position);
    }
    //暴露接口
    public void setOnItemClickListener(EventRecyclerViewItemClickListener listener){
        this.eventRecyclerViewItemClickListener=listener;
    }
}
