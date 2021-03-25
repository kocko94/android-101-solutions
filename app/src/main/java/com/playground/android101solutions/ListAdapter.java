package com.playground.android101solutions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.playground.android101solutions.model.DummyData;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created on 25/03/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.BaseViewHolder> {
    private final int TYPE_TITLE = 1;
    private final int TYPE_CONTENT = 2;

    private List<DummyData> data;

    public ListAdapter(List<DummyData> data) {
        this.data = data;
    }

    public void updateData(List<DummyData> data) {
        this.data = data;
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        switch (data.get(position).getType()) {
            case TITLE: return TYPE_TITLE;
            case CONTENT: return TYPE_CONTENT;
            default: throw new RuntimeException(String.format("Not described data type '%s'", data.get(position).getType()));
        }
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch(viewType) {
            case TYPE_TITLE: {
                View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_title, parent, false);
                return new TitleViewHolder(parentView);
            }
            case TYPE_CONTENT: {
                View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_content, parent, false);
                return new ContentViewHolder(parentView);
            }
            default: throw new RuntimeException(String.format("Not implemented view type '%d'", viewType));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(this.data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public abstract void bind(DummyData data);
    }

    static class ContentViewHolder extends BaseViewHolder {

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private ImageView getImageView() {
            return super.itemView.findViewById(R.id.image);
        }

        private TextView getTitleView() {
            return super.itemView.findViewById(R.id.title);
        }

        private TextView getDescriptionView() {
            return super.itemView.findViewById(R.id.description);
        }

        @Override
        public void bind(DummyData data) {
            //load asynchronously the image from the internet without blocking the main thread
            Picasso.get()
                    .load(data.getImageUrl())
                    .fit()
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE) //needed because we have randomly generated images from the same URL
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) //needed because we have randomly generated images from the same URL
                    .error(R.drawable.image_error)
                    .placeholder(R.drawable.image_placeholder)
                    .into(getImageView());
            getTitleView().setText(data.getTitle());
            getDescriptionView().setText(data.getDescription());
        }
    }

    static class TitleViewHolder extends BaseViewHolder {

        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        private TextView getTitleView() {
            return super.itemView.findViewById(R.id.title);
        }

        @Override
        public void bind(DummyData data) {
            getTitleView().setText(data.getTitle());
        }
    }
}
