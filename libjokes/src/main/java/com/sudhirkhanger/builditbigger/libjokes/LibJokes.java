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

package com.sudhirkhanger.builditbigger.libjokes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LibJokes {

    public static final int MIN = 0;
    public static final int MAX = 10;

    // Add Jokes to a List
    String[] jokesList = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
    };
    List<String> jokesArrayList = new ArrayList<>(Arrays.asList(jokesList));

    // Generate a random number
    Random mRandom = new Random();
    int random = mRandom.nextInt(MAX - MIN) + MIN;

    // Jokes getter

    public String getJokes() {
        return jokesArrayList.get(random);
    }
}
