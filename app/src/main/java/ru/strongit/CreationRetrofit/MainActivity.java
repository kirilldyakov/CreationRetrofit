package ru.strongit.CreationRetrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.strongit.CreationRetrofit.model.OrganizationModel;
import ru.strongit.CreationRetrofit.model.VisitModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<VisitModel> visits;
    List<OrganizationModel> organisations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visits = new ArrayList<>();
        organisations = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.visits_recycle_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //VisitAdapter visit_adapter = new VisitAdapter(visits);
        //recyclerView.setAdapter(visit_adapter);

        VisOrgAdapter vis_org_adapter = new VisOrgAdapter(visits, organisations);
        recyclerView.setAdapter(vis_org_adapter);

        RetrofitApp.getApi().getOrganizationList().enqueue(new Callback<List<OrganizationModel>>() {
            @Override
            public void onResponse(Call<List<OrganizationModel>> call, Response<List<OrganizationModel>> response) {
                organisations.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<OrganizationModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }

        });

        RetrofitApp.getApi().getVisitsList().enqueue(new Callback<List<VisitModel>>() {

            @Override
            public void onResponse(Call<List<VisitModel>> call, Response<List<VisitModel>> response) {
                visits.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<VisitModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }

        });


    }


}
