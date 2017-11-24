package com.kardiga.nicolas.vinditindi.first_screen.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kardiga.nicolas.vinditindi.R;
import com.kardiga.nicolas.vinditindi.databinding.ItemCardBinding;
import com.kardiga.nicolas.vinditindi.first_screen.entity.Photo;
import com.kardiga.nicolas.vinditindi.utils.DataBindingAdapter;
import com.kardiga.nicolas.vinditindi.utils.FlickrImageUrlGeneratorUtil;

import java.util.List;

/**
 * Created by Nicolas on 24.11.2017.
 */

public class SwipeDeckAdapter extends BaseAdapter {

    private List<Photo> data;
    private Context context;

    public SwipeDeckAdapter(List<Photo> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        PhotoViewHolder viewHolder;
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            viewHolder = new PhotoViewHolder(DataBindingUtil.inflate(inflater,
                    R.layout.item_card, parent, false));
            v = viewHolder.mBinding.getRoot();
            v.setTag(viewHolder);
        } else {
            viewHolder = (PhotoViewHolder) v.getTag();
        }
        viewHolder.mBinding.setPhoto(data.get(position));
        DataBindingAdapter.loadImage(viewHolder.mBinding.image,
                FlickrImageUrlGeneratorUtil.generateUrlFromFlickrPhoto(data.get(position)));
        v.setOnClickListener(view -> {
            Log.i("Layer type: ", Integer.toString(view.getLayerType()));
            Log.i("Hardware Accel type:", Integer.toString(View.LAYER_TYPE_HARDWARE));
        });
        return v;
    }

    public void addData(List<Photo> newPhotos) {
        data.addAll(newPhotos);
        notifyDataSetChanged();
    }

    class PhotoViewHolder {
        ItemCardBinding mBinding;

        public PhotoViewHolder(ItemCardBinding binding) {
            mBinding = binding;
        }
    }
}
