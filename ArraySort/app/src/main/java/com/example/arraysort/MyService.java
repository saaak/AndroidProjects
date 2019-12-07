package com.example.arraysort;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MyService extends Service {
    private final IBinder mbinder = new LocalBinder();

    public class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }
    /**
     * Return the communication channel to the service.  May return null if
     * clients can not bind to the service.  The returned
     * {@link IBinder} is usually for a complex interface
     * that has been <a href="{@docRoot}guide/components/aidl.html">described using
     * aidl</a>.
     *
     * <p><em>Note that unlike other application components, calls on to the
     * IBinder interface returned here may not happen on the main thread
     * of the process</em>.  More information about the main thread can be found in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html">Processes and
     * Threads</a>.</p>
     *
     * @param intent The Intent that was used to bind to this service,
     *               as given to {@link Context#bindService
     *               Context.bindService}.  Note that any extras that were included with
     *               the Intent at that point will <em>not</em> be seen here.
     * @return Return an IBinder through which clients can call on to the
     * service.
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("绑定了");
        return mbinder;
    }

    public Boolean OnUnbind(Intent intent){
        return false;
    }

    public ArrayList mySplit(String s){

        String[] splitS = s.split("\\s+");
        System.out.println(splitS.length);
        ArrayList arrayLists = new ArrayList(splitS.length);
        for (int i=0;i<splitS.length;i++){
            arrayLists.add(Integer.valueOf(splitS[i]));
        }
        return arrayLists;
    }

    public ArrayList mySort(ArrayList list){
        Collections.sort(list);
        return list;
    }
}
