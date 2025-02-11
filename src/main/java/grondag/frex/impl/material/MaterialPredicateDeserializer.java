/*
 *  Copyright 2019, 2020 grondag
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License.  You may obtain a copy
 *  of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package grondag.frex.impl.material;

import static grondag.frex.impl.material.predicate.MaterialPredicate.MATERIAL_ALWAYS_TRUE;

import com.google.gson.JsonObject;

import grondag.frex.impl.material.predicate.ArrayPredicate;
import grondag.frex.impl.material.predicate.MaterialPredicate;

public class MaterialPredicateDeserializer {
	@SuppressWarnings("unchecked")
	public static MaterialPredicate deserialize(JsonObject json) {
		if (json == null || json.isJsonNull()) {
			return MATERIAL_ALWAYS_TRUE;
		}

		ArrayPredicate arrayPredicate = new ArrayPredicate(json);

		if (arrayPredicate.size() == 0) {
			return MATERIAL_ALWAYS_TRUE;
		} else if (arrayPredicate.size() == 1) {
			return arrayPredicate.get(0);
		} else {
			return arrayPredicate;
		}
	}
}
