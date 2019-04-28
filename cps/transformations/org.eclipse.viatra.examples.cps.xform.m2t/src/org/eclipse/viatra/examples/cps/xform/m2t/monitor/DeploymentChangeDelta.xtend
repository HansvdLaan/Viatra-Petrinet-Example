/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, Robert Doczi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.monitor

import java.util.Map
import java.util.Set
import org.eclipse.viatra.examples.cps.deployment.DeploymentElement

@Data class DeploymentChangeDelta {
	public Set<DeploymentElement> appeared
	public Set<DeploymentElement> updated
	public Set<DeploymentElement> disappeared
	public Map<DeploymentElement, String> oldNamesForDeletion
	public boolean deploymentChanged
}