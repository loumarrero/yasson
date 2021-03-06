/*******************************************************************************
 * Copyright (c) 2016, 2017 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * Roman Grigoriadi
 ******************************************************************************/

package org.eclipse.yasson.internal.serializer;

import org.eclipse.yasson.internal.JsonbParser;
import org.eclipse.yasson.internal.JsonbRiParser;
import org.eclipse.yasson.internal.Unmarshaller;
import org.eclipse.yasson.internal.properties.MessageKeys;
import org.eclipse.yasson.internal.properties.Messages;
import org.eclipse.yasson.internal.model.JsonBindingModel;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.bind.JsonbException;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.math.BigDecimal;

/**
 * Common implementation for JSONP Object and Array.
 *
 * @author Roman Grigoriadi
 */
public abstract class AbstractJsonpDeserializer<T extends JsonValue> extends AbstractContainerDeserializer<T> {

    /**
     * Create instance of current item with its builder.
     *
     * @param builder {@link DeserializerBuilder} used to build this instance
     */
    protected AbstractJsonpDeserializer(DeserializerBuilder builder) {
        super(builder);
    }


    @Override
    protected JsonBindingModel getModel() {
        return getWrapperModel();

    }

    @Override
    protected JsonbRiParser.LevelContext moveToFirst(JsonbParser parser) {
        parser.moveToStartStructure();
        return parser.getCurrentLevel();
    }

    @Override
    protected void deserializeNext(JsonParser parser, Unmarshaller context) {
        throw new UnsupportedOperationException("Inner json structures are deserialized by JsonParser.");
    }

    @Override
    public void appendResult(Object result) {
        throw new UnsupportedOperationException("Inner json structures are deserialized by JsonParser.");
    }
}
