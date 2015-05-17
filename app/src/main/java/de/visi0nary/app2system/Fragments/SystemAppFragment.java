package de.visi0nary.app2system.Fragments;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import de.visi0nary.app2system.CustomListAdapter;
import de.visi0nary.app2system.R;

/**
 * Created by visi0nary on 03.05.15.
 */
public class SystemAppFragment extends AppFragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_applist, container, false);

        //TODO: implement adapter sorting logic
        final ArrayList<String> systemAppNamesList = new ArrayList<>();
        super.systemAppList = new ArrayList<>();
        // get all apps
        final PackageManager pm = getActivity().getPackageManager();
        ArrayList<ApplicationInfo> systemPackages = new ArrayList<>();

        //iterate through all apps and decide whether they're system or user apps and put them into the corresponding list
        for(ApplicationInfo appInfo : pm.getInstalledApplications(PackageManager.GET_META_DATA)) {
            // use human readable app name instead of package name
            if(super.checkIfAppIsSystemApp(appInfo)) {
                systemAppNamesList.add(pm.getApplicationLabel(appInfo).toString());
                systemPackages.add(appInfo);
                super.systemAppList.add(appInfo);
            }
        }
        // add apps to adapter
        final CustomListAdapter adapter = new CustomListAdapter(getActivity().getApplicationContext(), systemPackages, systemAppNamesList);
        setListAdapter(adapter);

        return rootView;
    }

    //this method implements the real functionality: if an app is clicked a pop up should appear
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.dialogFactory.create(0, getActivity(), id).show();
    }



}