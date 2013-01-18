/*
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
 */

// BSONTimestamp.java

package org.bson.types;

import java.io.Serializable;
import java.util.Date;

/**
 * this is used for internal increment values. for normal dates you should use java.util.Date <b>time</b> is seconds
 * since epoch <b>inc<b> is an ordinal
 */
public class BSONTimestamp implements Comparable<BSONTimestamp>, Serializable {

    private static final long serialVersionUID = -3268482672267936464L;

    private final int inc;
    private final Date time;

    public BSONTimestamp() {
        inc = 0;
        time = null;
    }

    public BSONTimestamp(final int time, final int inc) {
        this.time = new Date(time * 1000L);
        this.inc = inc;
    }

    /**
     * @return get time in seconds since epoch as an int
     */
    public int getTime() {
        if (time == null) {
            return 0;
        }
        return (int) (time.getTime() / 1000);
    }

    public int getInc() {
        return inc;
    }

    public String toString() {
        return "TS time:" + time + " inc:" + inc;
    }

    @Override
    public int compareTo(final BSONTimestamp ts) {
        if (getTime() != ts.getTime()) {
            return getTime() - ts.getTime();
        }
        else {
            return getInc() - ts.getInc();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + inc;
        result = prime * result + getTime();
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BSONTimestamp) {
            final BSONTimestamp t2 = (BSONTimestamp) obj;
            return getTime() == t2.getTime() && getInc() == t2.getInc();
        }
        return false;
    }

}
