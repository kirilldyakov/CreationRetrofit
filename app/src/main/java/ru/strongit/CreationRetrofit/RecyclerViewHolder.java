package ru.strongit.CreationRetrofit;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 01.06.17.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView mVisit;
    TextView mOrg;


    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mVisit = (TextView) itemView.findViewById(R.id.visitId);
        mOrg = (TextView) itemView.findViewById(R.id.orgId);

    }

    @Override
    public void onClick(View v) {
        // Save the selected positions to the SparseBooleanArray


        if (selectedItems.get(getAdapterPosition(), false)) {
            selectedItems.delete(getAdapterPosition());
            itemView.setSelected(false);
        } else {
            RecyclerView res = (RecyclerView) v.getParent();
            for (int i = 0; i < res.getAdapter().getItemCount(); i++) {
                res.getAdapter().notifyItemChanged(i);
            }
            selectedItems.clear();
            selectedItems.put(getAdapterPosition(), true);
            //selectedItems.clear();
            itemView.setSelected(true);


        }


    }



}
