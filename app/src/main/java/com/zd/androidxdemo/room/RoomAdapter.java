package com.zd.androidxdemo.room;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.zd.androidxdemo.R;
import com.zd.androidxdemo.databinding.RoomListItemBinding;

import java.util.List;

/**
 * @ClassName: RoomAdapter
 * @Description:
 * @Author: zhangdi
 * @Date: 20-12-29 下午6:22
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    private List<User> mUsers;

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        RoomListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
//                R.layout.room_list_item, parent, false);
//        return new RoomViewHolder(binding);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        holder.binding.setProduct(mProductList.get(position));
//        holder.binding.executePendingBindings();
//    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RoomListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.room_list_item, parent, false);
        return new RoomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.binding.setUser(mUsers.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    static class RoomViewHolder extends RecyclerView.ViewHolder {
        final RoomListItemBinding binding;

        public RoomViewHolder(RoomListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
