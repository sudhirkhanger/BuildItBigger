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

import android.test.UiThreadTest;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class EndpointsAsyncTaskTest extends TestCase implements JokeDownloader.EndpointListener {

    private static final String[] jokesList = {
            "I find it ironic that the colors red, white, and blue stand for freedom until they are flashing behind you.",
            "Apparently I snore so loudly that it scares everyone in the car I'm driving.",
            "I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness.",
            "Artificial intelligence is no match for natural stupidity.",
            "If you're not supposed to eat at night, why is there a light bulb in the refrigerator?"};

    private JokeDownloader mJokeDownloaders;
    private CountDownLatch signal;

    protected void setUp() throws Exception {
        super.setUp();

        signal = new CountDownLatch(1);
        mJokeDownloaders = new JokeDownloader(this);
    }

    @UiThreadTest
    public void testDownload() throws InterruptedException {
        String result = mJokeDownloaders.executeEndpoints();
        signal.await(30, TimeUnit.SECONDS);

        assertTrue("Joke: " + result,
                result.equals(jokesList[0]) ||
                        result.equals(jokesList[1]) ||
                        result.equals(jokesList[2]) ||
                        result.equals(jokesList[3]) ||
                        result.equals(jokesList[4]));
    }

    @Override
    public void downloadComplete() {
        signal.countDown();
    }
}
