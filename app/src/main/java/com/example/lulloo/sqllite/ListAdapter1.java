package com.example.lulloo.sqllite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListAdapter1 extends BaseAdapter {
    Context context;
    List<Pojo> pojoList;

    SQl_Db1 my;
    public ListAdapter1(Context context, List<Pojo> pojoList) {
        this.context = context;
        this.pojoList = pojoList;
    }

    @Override
    public int getCount() {
        return pojoList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=LayoutInflater.from(context).inflate(R.layout.items,null);
        final TextView id,name,surname,marks;
        ImageView image;
        Button cart;
        id=view.findViewById(R.id.sn);
        name=view.findViewById(R.id.name);
        image=view.findViewById(R.id.imagessss);
        cart=view.findViewById(R.id.cart);
       cart.setVisibility(View.GONE);
        surname=view.findViewById(R.id.surname);
        marks=view.findViewById(R.id.marks);

        final Pojo pojos=pojoList.get(position);
        id.setText(pojos.getId());
        name.setText(pojos.getName());
        marks.setText(pojos.getMarks());
        final byte[] foodImage = pojos.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        image.setImageBitmap(bitmap);

        return view;
    }
}
