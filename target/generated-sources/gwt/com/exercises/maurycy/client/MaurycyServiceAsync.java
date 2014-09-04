package com.exercises.maurycy.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MaurycyServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.exercises.maurycy.client.MaurycyService
     */
    void inspectString( java.lang.String name, AsyncCallback<java.lang.String> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static MaurycyServiceAsync instance;

        public static final MaurycyServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (MaurycyServiceAsync) GWT.create( MaurycyService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
