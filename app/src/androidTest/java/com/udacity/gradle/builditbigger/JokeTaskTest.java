package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class JokeTaskTest {
    @Test
    public void getJoke() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        JokeTask task = new JokeTask() {
            @Override
            protected void onPostExecute(String s) {
                assertNotNull(s);
                latch.countDown();
            }
        };
        task.execute();
        latch.await();
    }
}
