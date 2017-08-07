/*
 * Copyright 2017 Open Language for Internet of Things (Oliot)
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

package org.oliot.heroku.tsd.models.FoodAndBeveragePreparationInformationModule;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentStatusEnumerationType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DocumentStatusEnumerationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADDITIONAL_TRANSMISSION"/>
 *     &lt;enumeration value="COPY"/>
 *     &lt;enumeration value="ORIGINAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "DocumentStatusEnumerationType", namespace = "urn:gs1:shared:shared_common:xsd:3")
@XmlEnum
public enum DocumentStatusEnumerationType {

    ADDITIONAL_TRANSMISSION,
    COPY,
    ORIGINAL;

    public static DocumentStatusEnumerationType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
