package com.example.benben.cpapa.ui.adpter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.benben.cpapa.R;


/**
 * Created by Administrator on 2016/5/2.
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftHolder> {

    private String[] mData = null;

    private int choosePosition = -1;
    private OnItemClickListener mListener;

    public LeftAdapter(String[] mData) {
        this.mData = mData;
    }

    /**创建viewHolder*/
    @Override
    public LeftHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, parent, false);
        LeftHolder holder = new LeftHolder(view);
        return holder;
    }

    /**绑定ViewHolder*/
    @Override
    public void onBindViewHolder(final LeftHolder holder, int position) {
        holder.mTextView.setText(mData[position]);

        /**点击事件*/
        if (mListener != null) {
            holder.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=holder.getAdapterPosition();//得到item对象的位置
                    mListener.ItemClickListener(holder.itemView, pos);
                }
            });
        }
    }

    /**得到数量*/
    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class LeftHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        public LeftHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }

    /**
     * 添加点击事件
     */
    public interface OnItemClickListener {
        void ItemClickListener(View view, int position);
    }

    public void setItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public void setChoosePosition(int position) {
        this.choosePosition = position;
    }
}
