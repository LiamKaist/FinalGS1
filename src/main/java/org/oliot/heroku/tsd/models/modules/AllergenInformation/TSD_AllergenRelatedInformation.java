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

package org.oliot.heroku.tsd.models.modules.AllergenInformation;

import lombok.Data;
import org.oliot.heroku.tsd.models.common.FormattedDescription1000;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.ArrayList;
import java.util.List;


//FIXME: This class is not compatible with GS1 TSD standard
//   Contact GS1 Source working group to point out the problems in TSD_AllergenRelatedInformation structure:
//     1. Cardinality of at-least one element should be 1
@Data
public class TSD_AllergenRelatedInformation {
    /**
     * Textual description of the presence or absence of allergens
     * as governed by local rules and regulations, specified as one string.
     * Each TSD_FormattedDescription1000 structure SHALL have a different
     * language code, and SHALL represent presentations
     * of the same value in different languages.
     */
    private List<FormattedDescription1000> allergenStatements;

    /**
     * Agency that controls the allergen definition.
     */
    private String allergenSpecificationAgency;

    /**
     * Free text field containing the name and version of the regulation
     * or standard that contains the definition of the allergen.
     */
    private String allergenSpecificationName;

    /**
     * Detailed information per individual allergen.
     */
    private List<TSD_Allergen> allergens;

    public TSD_AllergenRelatedInformation
            (FormattedDescription1000 statement) {
        this.allergenStatements = new ArrayList<FormattedDescription1000>();
        this.allergenStatements.add(statement);
    }

    @PersistenceConstructor
    private TSD_AllergenRelatedInformation
            (List<FormattedDescription1000> allergenStatements) {
        this.allergenStatements = allergenStatements;
    }

    public TSD_AllergenRelatedInformation
    addAllergenStatement(FormattedDescription1000 statement) {
        this.allergenStatements.add(statement);
        return this;
    }

    public TSD_AllergenRelatedInformation
    addAllergens(TSD_Allergen allergen) {
        if (this.allergens == null) {
            this.allergens = new ArrayList<TSD_Allergen>();
        }
        this.allergens.add(allergen);
        return this;
    }
}
