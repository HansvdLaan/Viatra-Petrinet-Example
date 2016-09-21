/**
 * 
 *   Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *     Andras Szabolcs Nagy - initial API and implementation
 *  
 */
package org.eclipse.viatra.dse.examples.bpmn.patterns;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.examples.bpmn.patterns.TaskOrderMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.TaskOrderQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.examples.bpmn.patterns.taskOrder pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TaskOrderMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern taskOrder(T1:Task, T2:Task) {
 *     Task.name(T1,name1);
 *     Task.name(T2,name2);
 *     check(name1 {@literal >} name2);
 * }
 * </pre></code>
 * 
 * @see TaskOrderMatch
 * @see TaskOrderProcessor
 * @see TaskOrderQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TaskOrderMatcher extends BaseMatcher<TaskOrderMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TaskOrderMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    TaskOrderMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (TaskOrderMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TaskOrderMatcher create() throws ViatraQueryException {
    return new TaskOrderMatcher();
  }
  
  private final static int POSITION_T1 = 0;
  
  private final static int POSITION_T2 = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TaskOrderMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private TaskOrderMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @return matches represented as a TaskOrderMatch object.
   * 
   */
  public Collection<TaskOrderMatch> getAllMatches(final Task pT1, final Task pT2) {
    return rawGetAllMatches(new Object[]{pT1, pT2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @return a match represented as a TaskOrderMatch object, or null if no match is found.
   * 
   */
  public TaskOrderMatch getOneArbitraryMatch(final Task pT1, final Task pT2) {
    return rawGetOneArbitraryMatch(new Object[]{pT1, pT2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Task pT1, final Task pT2) {
    return rawHasMatch(new Object[]{pT1, pT2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Task pT1, final Task pT2) {
    return rawCountMatches(new Object[]{pT1, pT2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Task pT1, final Task pT2, final IMatchProcessor<? super TaskOrderMatch> processor) {
    rawForEachMatch(new Object[]{pT1, pT2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Task pT1, final Task pT2, final IMatchProcessor<? super TaskOrderMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pT1, pT2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TaskOrderMatch newMatch(final Task pT1, final Task pT2) {
    return TaskOrderMatch.newMatch(pT1, pT2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Task> rawAccumulateAllValuesOfT1(final Object[] parameters) {
    Set<Task> results = new HashSet<Task>();
    rawAccumulateAllValues(POSITION_T1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT1() {
    return rawAccumulateAllValuesOfT1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT1(final TaskOrderMatch partialMatch) {
    return rawAccumulateAllValuesOfT1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT1(final Task pT2) {
    return rawAccumulateAllValuesOfT1(new Object[]{
    null, 
    pT2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Task> rawAccumulateAllValuesOfT2(final Object[] parameters) {
    Set<Task> results = new HashSet<Task>();
    rawAccumulateAllValues(POSITION_T2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT2() {
    return rawAccumulateAllValuesOfT2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT2(final TaskOrderMatch partialMatch) {
    return rawAccumulateAllValuesOfT2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT2(final Task pT1) {
    return rawAccumulateAllValuesOfT2(new Object[]{
    pT1, 
    null
    });
  }
  
  @Override
  protected TaskOrderMatch tupleToMatch(final Tuple t) {
    try {
    	return TaskOrderMatch.newMatch((Task) t.get(POSITION_T1), (Task) t.get(POSITION_T2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TaskOrderMatch arrayToMatch(final Object[] match) {
    try {
    	return TaskOrderMatch.newMatch((Task) match[POSITION_T1], (Task) match[POSITION_T2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TaskOrderMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TaskOrderMatch.newMutableMatch((Task) match[POSITION_T1], (Task) match[POSITION_T2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<TaskOrderMatcher> querySpecification() throws ViatraQueryException {
    return TaskOrderQuerySpecification.instance();
  }
}
