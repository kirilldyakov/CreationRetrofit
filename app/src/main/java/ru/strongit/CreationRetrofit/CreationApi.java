package ru.strongit.CreationRetrofit;


/**
 * Created by user on 01.06.17.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.strongit.CreationRetrofit.model.VisitModel;
import ru.strongit.CreationRetrofit.model.OrganizationModel;


public interface CreationApi {
    @GET("/getVisitsListTest")
    Call<List<VisitModel>> getVisitsList();//@Query("name") String resourceName, @Query("num") int count);

    @GET("/getOrganizationListTest")
    Call<List<OrganizationModel>> getOrganizationList();//@Query("name") String resourceName, @Query("num") int count);
}
