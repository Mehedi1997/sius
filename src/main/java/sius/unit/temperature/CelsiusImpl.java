/*
 * Copyright 2014 Mikael Beyene
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
 * 
 */
package sius.unit.temperature;

import sius.dimension.Temperature;
import sius.operation.Operation;
import sius.unit.Unit;
import sius.unit.UnitId;
import sius.unit.UnitIdentifier;

final class CelsiusImpl implements Celsius {

	private final double scalar;
	private final UnitId<Temperature, Kelvin, Celsius> unitId = UnitIdentifier.CELSIUS;
	
	public CelsiusImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Temperature getDimension() {
		return Temperature.INSTANCE;
	}

	@Override
	public UnitId<Temperature, Kelvin, Celsius> getIdentifier() {
		return unitId;
	}

	@Override
	public <OTHER extends Unit<Temperature, Kelvin, OTHER>> Celsius convert(
			OTHER other) {
		Celsius converted;
		if (other.getIdentifier().equals(unitId))
			converted = new CelsiusImpl(other.getScalar());
		else if (other.getIdentifier().equals(UnitIdentifier.KELVIN))
			converted = new CelsiusImpl(other.getScalar() - Constants.CELSIUS_KELVIN_OFFSET);
		else
			converted = Operation.convert(other, unitId);
		
		return converted;
	}

	@Override
	public Kelvin toBaseUnit() {
		return TemperatureFactory.kelvin(scalar + Constants.CELSIUS_KELVIN_OFFSET);
	}

	@Override
	public Celsius valueOf(double d) {
		return new CelsiusImpl(d);
	}

	@Override
	public double getScalar() {
		return scalar;
	}

	@Override
	public String toString() {
		return "Celsius [value=" + scalar + "]";
	}
}