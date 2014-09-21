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
package org.beyene.sius.operation.functor;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.unit.Unit;

/**
 * Functor that performs operation on arbitrary number of operands.
 * 
 * @author mbeyene
 *
 * @param <D> dimension
 * @param <B> base unit
 * @param <CU> target unit
 * @param <F> self reference
 */
public interface Functor<D extends Dimension<D>, B extends Unit<D, B, B>,  CU extends Unit<D, B, CU>, F extends Functor<D, B, CU, F>> {

	/**
	 * Adds operand.
	 * 
	 * @param op operand to be added
	 * @return <code>this</code>
	 */
	public F op(Unit<D, B, ?> op);
	
	/**
	 * Applies functor.
	 * 
	 * @return result
	 */
	public CU apply();
	
	@Override
	public String toString();
}