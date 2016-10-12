package spfworld.spfworld.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.Content;

/**
 * Created by guozhengke on 2016/9/23.
 * 选择时间段gridview适配器
 */
public class EventRVGridViewAdapter extends RecyclerView.Adapter<EventRVGridViewAdapter.ViewHolder> {
    private List<String> actTime;
    private LayoutInflater layoutInflater;
    private int layoutPosition;
    private EventRVGridViewItemClickListener eventRVGridViewItemClickListener=null;

    public EventRVGridViewAdapter(Context context, List<String> actTime) {
        this.actTime=actTime;
        this.layoutInflater=layoutInflater.from(context);
    }
    @Override
    public EventRVGridViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =layoutInflater.inflate(R.layout.event_merchandise_gridview,parent,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mTextView.setText(actTime.get(position));
        holder.itemView.setTag(actTime.get(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutPosition=holder.getLayoutPosition();
                notifyDataSetChanged();
                eventRVGridViewItemClickListener.onItemClick(holder.itemView, (String) holder.itemView.getTag(),layoutPosition);
            }
        });
        //选择状态
        if (position==layoutPosition){
            holder.mTextView.setBackgroundResource(R.drawable.selector_event_merchandise_gridview_textview);
            holder.mTextView.setTextColor(Color.rgb(253,191,70));
            Content.GRTime=actTime.get(position);
        }else {
            holder.mTextView.setBackgroundResource(R.drawable.selector_event_merchandise_gridview_textview_false);
            holder.mTextView.setTextColor(Color.BLACK);
        }
    }

    //回调
    public interface EventRVGridViewItemClickListener {
        public void onItemClick(View view, String data,int position);
    }
    //暴露接口
    public void setOnItemClickListener(EventRVGridViewItemClickListener listener){
        this.eventRVGridViewItemClickListener=listener;
    }

    @Override
    public int getItemCount() {
        return actTime.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.grid_textview);
        }
    }
}
