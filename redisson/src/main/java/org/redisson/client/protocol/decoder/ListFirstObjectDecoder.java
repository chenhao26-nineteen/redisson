/**
 * Copyright (c) 2013-2022 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.client.protocol.decoder;

import org.redisson.client.handler.State;
import org.redisson.client.protocol.convertor.Convertor;

import java.util.List;

/**
 * 
 * @author Nikita Koksharov
 *
 */
public class ListFirstObjectDecoder implements MultiDecoder<Object> {

    private final Convertor<?> convertor;

    public ListFirstObjectDecoder() {
        this(null);
    }

    public ListFirstObjectDecoder(Convertor<?> convertor) {
        this.convertor = convertor;
    }

    @Override
    public Object decode(List<Object> parts, State state) {
        if (!parts.isEmpty()) {
            return parts.get(0);
        }
        if (convertor != null) {
            return convertor.convert(null);
        }
        return null;
    }

}
