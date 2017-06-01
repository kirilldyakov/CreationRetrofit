package ru.strongit.CreationRetrofit;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.strongit.CreationRetrofit.model.VisitModel;

/**
 * Created by user on 01.06.17.
 */

public class VisitAdapter extends RecyclerView.Adapter<VisitAdapter.ViewHolder> {


    private List<VisitModel> visits;

    public VisitAdapter(List<VisitModel> visits) {
        this.visits = visits;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(ru.strongit.retrofit.R.layout.org_visit_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VisitAdapter.ViewHolder holder, int position) {

        VisitModel visit = visits.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.mVisit.setText(Html.fromHtml(visit.getTitle(), Html.FROM_HTML_MODE_LEGACY));
            holder.mOrg.setText(Html.fromHtml(visit.getOrganizationId(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.mVisit.setText(Html.fromHtml(visit.getTitle()));
            holder.mOrg.setText(Html.fromHtml(visit.getOrganizationId()));
        }
        //holder.mOrg.setText(post.getSite());
    }

    @Override
    public int getItemCount() {
        if (visits == null)
            return 0;
        return visits.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mVisit;
        TextView mOrg;

        public ViewHolder(View itemView) {
            super(itemView);
            mVisit = (TextView) itemView.findViewById(ru.strongit.retrofit.R.id.visitId);
            mOrg = (TextView) itemView.findViewById(ru.strongit.retrofit.R.id.orgId);
        }
    }
}

