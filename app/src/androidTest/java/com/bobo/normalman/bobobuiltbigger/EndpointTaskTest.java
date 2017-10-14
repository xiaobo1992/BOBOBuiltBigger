package com.bobo.normalman.bobobuiltbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by xiaobozhang on 10/13/17.
 */

public class EndpointTaskTest extends AndroidTestCase {

    public void test() {
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();
        asyncTask.execute(getContext());
        String result = null;
        try {
            result = asyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
