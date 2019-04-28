/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos.bases

import org.eclipse.emf.ecore.EObject
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.IConstraints
import org.eclipse.viatra.examples.cps.planexecutor.api.Initializer
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment

@Data
abstract class GeneratorInput<ModelType extends EObject> extends GeneratorConfiguration<ModelType> implements Initializer<CPSFragment> {
	long seed;
	IConstraints constraints;
	
	new(long seed, IConstraints constraints, ModelType modelRoot) {
		this._seed = seed;
		this._constraints = constraints;
		this.modelRoot = modelRoot;
	}
	
}
