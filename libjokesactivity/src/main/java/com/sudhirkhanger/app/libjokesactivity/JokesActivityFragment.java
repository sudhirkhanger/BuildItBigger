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

package com.sudhirkhanger.app.libjokesactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokesActivityFragment extends Fragment {

    public JokesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_jokes, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.textview_joke);

        String joke = rootView.getResources().getString(R.string.app_name);

        Intent intent = getActivity().getIntent();

        if (intent == null) {
            if (intent.getExtras() == null) {
                Log.d("JokesFragment", "Error Intent Null");
            } else {
                joke = getActivity().getIntent().getExtras().getString("KEY_JOKE");
            }
        }
        textView.setText(joke);
        return rootView;
    }
}
