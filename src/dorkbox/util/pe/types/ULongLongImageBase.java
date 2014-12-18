/*
 * Copyright 2012 dorkbox, llc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dorkbox.util.pe.types;

import dorkbox.util.OS;
import dorkbox.util.pe.misc.ImageBase;

public class ULongLongImageBase extends ByteDefinition<Long> {

    private final long value;

    public ULongLongImageBase(long value, String descriptiveName) {
        super(descriptiveName);
        this.value = value;
    }

    @Override
    public final Long get() {
        return this.value;
    }

    @Override
    public void format(StringBuilder b) {
        ImageBase imageBase = ImageBase.get((int)this.value);
        b.append(getDescriptiveName()).append(": ")
         .append(this.value).append(" (0x").append(Long.toHexString(this.value)).append(") (");

        if (imageBase != null) {
            b.append(imageBase.getDescription());
        } else {
            b.append("no image base default");
        }
        b.append(")").append(OS.LINE_SEPARATOR);
    }
}
