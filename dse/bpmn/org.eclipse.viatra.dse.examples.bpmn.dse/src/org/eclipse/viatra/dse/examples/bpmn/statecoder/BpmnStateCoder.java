/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.statecoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariant;
import org.eclipse.viatra.dse.examples.bpmn.patterns.CreateResource;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeParallel;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequential;
import org.eclipse.viatra.dse.examples.bpmn.problems.SimplifiedBpmnBuilder;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;
import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

public class BpmnStateCoder implements IStateCoder {

    private SimplifiedBPMN model;
    private ArrayList<ResourceTypeVariant> sortedResourceTypes;
    private ArrayList<Task> sortedTasks;

    
    @Override
    public void init(Notifier notifier) {
        
        model = (SimplifiedBPMN) notifier;
        
        sortedResourceTypes = new ArrayList<ResourceTypeVariant>();
        for (ResourceType resourceType : model.getResourceTypes()) {
            sortedResourceTypes.addAll(resourceType.getVariants());
        }
        Collections.sort(sortedResourceTypes, new Comparator<ResourceTypeVariant>() {

            @Override
            public int compare(ResourceTypeVariant o1, ResourceTypeVariant o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        sortedTasks = new ArrayList<Task>(model.getTasks());
        Collections.sort(sortedTasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    @Override
    public Object createStateCode() {
        StringBuilder sb = new StringBuilder();
        for (ResourceTypeVariant resourceTypeVariant : sortedResourceTypes) {
            sb.append(resourceTypeVariant.getName());
            sb.append(":");
            sb.append(resourceTypeVariant.getInstances().size());
            sb.append(";");
        }
        for (Task task : sortedTasks) {
            ResourceTypeVariant variant = task.getVariant();
            if (variant != null) {
                sb.append(task.getName());
                sb.append("-");
                sb.append(task.getVariant().getName());
                sb.append(";");
            }
        }
        ArrayList<ParallelGateway> pgs = new ArrayList<ParallelGateway>(model.getParallelGateways());
        Collections.sort(pgs, new Comparator<ParallelGateway>() {
            @Override
            public int compare(ParallelGateway o1, ParallelGateway o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (ParallelGateway parallelGateway : pgs) {
            sb.append(parallelGateway.getName());
            sb.append(";");
        }
        return sb.toString();
    }

    @Override
    public Object createActivationCode(IPatternMatch match) {

        if (match instanceof CreateResource.Match) {
            CreateResource.Match m = (CreateResource.Match) match;
            return m.getRTV().getName().intern();
        } else if (match instanceof AllocateTaskToVariant.Match) {
            AllocateTaskToVariant.Match m = (AllocateTaskToVariant.Match) match;
            return (m.getT().getName() + "-" + m.getRTV().getName()).intern();
        } else if (match instanceof MakeParallel.Match) {
            MakeParallel.Match m = (MakeParallel.Match) match;
            return ("Parallel:" + SimplifiedBpmnBuilder.createOrderedString(m.getT1().getName(), m.getT2().getName())).intern();
        } else if (match instanceof MakeSequential.Match) {
            MakeSequential.Match m = (MakeSequential.Match) match;
            return ("Sequential:" + SimplifiedBpmnBuilder.createOrderedString(m.getT1().getName(), m.getT2().getName())).intern();
        } else {
            throw new DSEException("Unsupported rule.");
        }
    }

}
