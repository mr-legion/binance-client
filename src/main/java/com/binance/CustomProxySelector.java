package com.binance;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * This class selects each time a new proxy from list.
 */
public class CustomProxySelector extends ProxySelector {

    private final List<Proxy> proxies = new ArrayList<>();

    private int currProxyIndex = 0;

    public CustomProxySelector(Set<Proxy> proxies) {
        this.proxies.add(Proxy.NO_PROXY);
        this.proxies.addAll(proxies);
    }

    public List<Proxy> select(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("uri must not be null");
        } else {
            synchronized (this) {
                Proxy proxy = proxies.get(currProxyIndex);
                if (currProxyIndex == (proxies.size() - 1)) {
                    currProxyIndex = 0;
                } else {
                    currProxyIndex++;
                }
                return Collections.singletonList(proxy);
            }
        }
    }

    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        throw new RuntimeException("proxy " + sa + " not working!", ioe);
    }
}
