/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.qpid.jms.provider.amqp;

import java.net.URI;
import java.util.Map;

import org.apache.qpid.jms.JmsSslContext;
import org.apache.qpid.jms.transports.SslTransport;
import org.apache.qpid.jms.transports.Transport;

/**
 * AmqpProvider extension that enables SSL based transports.
 */
public class AmqpSslProvider extends AmqpProvider {

    private final JmsSslContext sslContext;

    public AmqpSslProvider(URI remoteURI) {
        super(remoteURI);
        this.sslContext = JmsSslContext.getCurrentSslContext();
    }

    public AmqpSslProvider(URI remoteURI, Map<String, String> extraOptions) {
        super(remoteURI, extraOptions);
        this.sslContext = JmsSslContext.getCurrentSslContext();
    }

    @Override
    protected Transport createTransport(URI remoteLocation) {
        return new SslTransport(this, remoteLocation, sslContext);
    }
}
