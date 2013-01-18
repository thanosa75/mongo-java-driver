/**
 * Copyright (c) 2008 - 2012 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.mongodb.serialization.serializers;

import org.bson.BSONReader;
import org.bson.BSONWriter;
import org.bson.types.BSONTimestamp;
import org.mongodb.serialization.BsonSerializationOptions;
import org.mongodb.serialization.Serializer;

/**
 * Knows how to serialize and deserialize BSON timestamps.
 */
public class TimestampSerializer implements Serializer<BSONTimestamp> {
    @Override
    public void serialize(final BSONWriter bsonWriter, final BSONTimestamp value, final BsonSerializationOptions options) {
        bsonWriter.writeTimestamp(value);
    }

    @Override
    public BSONTimestamp deserialize(final BSONReader reader, final BsonSerializationOptions options) {
        return reader.readTimestamp();
    }

    @Override
    public Class<BSONTimestamp> getSerializationClass() {
        return BSONTimestamp.class;
    }
}
