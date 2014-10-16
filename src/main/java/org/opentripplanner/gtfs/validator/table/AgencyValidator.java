/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.gtfs.validator.table;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import org.opentripplanner.gtfs.model.Agency;

import java.util.Iterator;
import java.util.Map;

import static org.opentripplanner.gtfs.model.Agency.FEED_FILE;

public class AgencyValidator extends TableValidator<Agency> {
    public AgencyValidator(Iterable<Map<String, String>> input) {
        super(FEED_FILE, input);
    }

    @Override
    public Iterator<Agency> iterator() {
        return Iterators.transform(maps.iterator(),
                new Function<Map<String, String>, Agency>() {
                    @Override
                    public Agency apply(Map<String, String> row) {
                        return new Agency(row);
                    }
                });
    }
}