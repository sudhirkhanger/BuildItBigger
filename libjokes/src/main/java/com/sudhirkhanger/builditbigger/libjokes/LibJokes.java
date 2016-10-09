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

    private static final int MAX = 5;

    // Add Jokes to a List
    private static final String[] jokesList = {
            "I find it ironic that the colors red, white, and blue stand for freedom until they are flashing behind you.",
            "Apparently I snore so loudly that it scares everyone in the car I'm driving.",
            "I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness.",
            "Artificial intelligence is no match for natural stupidity.",
            "If you're not supposed to eat at night, why is there a light bulb in the refrigerator?"};

    public static final String[] numberList = {
            "1",
            "2",
            "3",
            "4",
            "5",
    };

    private static final List<String> jokesArrayList = new ArrayList<>(Arrays.asList(jokesList));
    private static final List<String> numbersArrayList = new ArrayList<>(Arrays.asList(numberList));
    private static Random random = new Random();

    public String getJokes() {
        int randomInt = random.nextInt(MAX);
//        return jokesArrayList.get(randomInt);
        return numbersArrayList.get(randomInt);
    }
}
