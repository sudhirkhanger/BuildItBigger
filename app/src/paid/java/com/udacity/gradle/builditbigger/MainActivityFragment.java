/*
 * Copyright 2016 Sudhir Khanger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sudhirkhanger.app.libdisplayjokes.DisplayJokesActivity;
import com.udacity.gradle.builditbigger.rest.EndpointsAsyncTask;

import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {
    public static final String KEY_JOKE = "KEY_JOKE";
    public static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) root.findViewById(R.id.show_joke_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(getActivity(), DisplayJokesActivity.class);

                String joke = "N/A";

                try {
                    joke = new EndpointsAsyncTask().execute().get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }

                Log.d(LOG_TAG, joke);
                intent.putExtra(KEY_JOKE, joke);
                startActivity(intent);
            }
        });

        return root;
    }
}
