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

package org.oliot.heroku.tsd.models.ProductData;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DayOfTheWeekEnumerationType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DayOfTheWeekEnumerationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FRIDAY"/>
 *     &lt;enumeration value="MONDAY"/>
 *     &lt;enumeration value="SATURDAY"/>
 *     &lt;enumeration value="SUNDAY"/>
 *     &lt;enumeration value="THURSDAY"/>
 *     &lt;enumeration value="TUESDAY"/>
 *     &lt;enumeration value="WEDNESDAY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "DayOfTheWeekEnumerationType")
@XmlEnum
public enum DayOfTheWeekEnumerationType {

    FRIDAY,
    MONDAY,
    SATURDAY,
    SUNDAY,
    THURSDAY,
    TUESDAY,
    WEDNESDAY;

    public static DayOfTheWeekEnumerationType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
