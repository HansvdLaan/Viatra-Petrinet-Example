/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Tamas Borbas, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos.constraints.impl

import java.util.HashMap
import org.eclipse.viatra.examples.cps.generator.dtos.AppClass
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData
import org.eclipse.viatra.examples.cps.generator.dtos.Percentage
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints

class SimpleCPSConstraints implements ICPSConstraints {
	
	public String name = "Simple"
	val hostClass = new HostClass(
						"FirstHostClass",
						new MinMaxData(1, 1), // HostTypes
						new MinMaxData(2, 2), // HostInstances
						new MinMaxData(1, 1) // CommLines
						,new HashMap // Host Comm Ratio
					)
	
	override getNumberOfSignals() {
		new MinMaxData(1, 10);
	}
	
	override getApplicationClasses() {
		val firstAppClassAllocations = new HashMap();
		firstAppClassAllocations.put(hostClass, 1);
		#[
			new AppClass(
				"FirstAppClass",
				new MinMaxData(1, 1), // AppTypes
				new MinMaxData(1, 1), // AppInstances
				new MinMaxData(2, 2), // States
				new MinMaxData(1, 1) // Transitions
				, new Percentage(100)
				, firstAppClassAllocations
				, new Percentage(100)
				, new Percentage(50)
			)
		];
	}
	
	override getHostClasses() {
		hostClass.communicationRatios.put(hostClass, 1);
		#[
			hostClass
		];
	}

	override getName() {
		return this.class.simpleName;
	}
	
}