/*
 * Copyright (c) 2011-2017 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.ipc.netty.http.client;

import reactor.ipc.netty.tcp.TcpClient;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author Stephane Maldini
 */
final class HttpClientTcpConfig extends HttpClientOperator {

	final TcpClient tcpClient;

	HttpClientTcpConfig(HttpClient client,
			Function<? super TcpClient, ? extends TcpClient> tcpClientMapper) {
		super(client);
		Objects.requireNonNull(tcpClientMapper, "tcpClientMapper");
		this.tcpClient = Objects.requireNonNull(tcpClientMapper.apply(source.tcpConfiguration()),
				"tcpClientMapper");
	}

	@Override
	protected TcpClient tcpConfiguration() {
		return tcpClient;
	}
}
