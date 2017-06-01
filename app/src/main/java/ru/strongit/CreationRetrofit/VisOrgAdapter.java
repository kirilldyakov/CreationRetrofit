package ru.strongit.CreationRetrofit;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ru.strongit.CreationRetrofit.model.OrganizationModel;
import ru.strongit.CreationRetrofit.model.VisitModel;

/**
 * Created by user on 01.06.17.
 */

public class VisOrgAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    private List<VisitModel> mVisits;
    private List<OrganizationModel> mOrgs;

    public VisOrgAdapter(List<VisitModel> visits, List<OrganizationModel> orgs)
    {
        this.mVisits = visits;
        this.mOrgs = orgs;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.org_visit_item, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        VisitModel visit = mVisits.get(position);
        OrganizationModel org = getOrgById(mOrgs,visit.getOrganizationId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.mVisit.setText(Html.fromHtml(visit.getTitle(), Html.FROM_HTML_MODE_LEGACY));
            holder.mOrg.setText(Html.fromHtml(org!=null?org.getTitle():"---", Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.mVisit.setText(Html.fromHtml(visit.getTitle()));
            holder.mOrg.setText(Html.fromHtml(org!=null?org.getTitle():"---"));
        }
        //holder.mOrg.setText(post.getSite());

       // holder.myBackground.setSelected(selectedItems.get(position, false));
    }

    private OrganizationModel getOrgById(List<OrganizationModel> orgs, String id){
        for (int i = 0; i < orgs.size(); i++) {
            String oid = orgs.get(i).getOrganizationId();
            if (oid.equals(id)){
                return orgs.get(i);
            }
        }
        return null;
    }

    @Override
    public int getItemCount() {
        if (mVisits == null)
            return 0;
        return mVisits.size();
    }


}

