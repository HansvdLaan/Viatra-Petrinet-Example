/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.utils

import org.eclipse.viatra.query.runtime.base.api.IEClassifierProcessor.IEClassProcessor
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.viatra.query.runtime.base.api.IStructuralFeatureInstanceProcessor

class SumProcessor implements IEClassProcessor, IStructuralFeatureInstanceProcessor {
	
	var sum = 0;
		
	override process(EClass type, EObject instance) {
		sum++
	}
	
	override process(EObject source, Object target) {
		sum++
	}
	
	def getSum(){
		return sum
	}
	
	def resetSum(){
		sum = 0
	}
		
}