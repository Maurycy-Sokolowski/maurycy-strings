package com.exercises.maurycy.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface MaurycyService extends RemoteService {
  String inspectString(String name) throws IllegalArgumentException;
}
