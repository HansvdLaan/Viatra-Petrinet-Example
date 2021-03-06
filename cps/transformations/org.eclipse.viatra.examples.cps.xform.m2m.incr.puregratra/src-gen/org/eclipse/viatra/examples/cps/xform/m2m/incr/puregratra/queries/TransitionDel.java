/**
 * 
 *   Copyright (c) 2014-2019 Geza Kulcsar, Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Peter Lunk, Istvan David, IncQuery Labs Ltd.
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v. 2.0 which is available at
 *   http://www.eclipse.org/legal/epl-v20.html.
 *   
 *   SPDX-License-Identifier: EPL-2.0
 *  
 */
package org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Generated;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition;
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         pattern transitionDel(behTransition : BehaviorTransition, trace : CPS2DeploymentTrace) {
 *             CPS2DeploymentTrace.deploymentElements(trace,behTransition);
 *             neg find cps2depTrace(_, trace, _, behTransition);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class TransitionDel extends BaseGeneratedEMFQuerySpecification<TransitionDel.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.transitionDel pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private BehaviorTransition fBehTransition;
    
    private CPS2DeploymentTrace fTrace;
    
    private static List<String> parameterNames = makeImmutableList("behTransition", "trace");
    
    private Match(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
      this.fBehTransition = pBehTransition;
      this.fTrace = pTrace;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("behTransition".equals(parameterName)) return this.fBehTransition;
      if ("trace".equals(parameterName)) return this.fTrace;
      return null;
    }
    
    public BehaviorTransition getBehTransition() {
      return this.fBehTransition;
    }
    
    public CPS2DeploymentTrace getTrace() {
      return this.fTrace;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("behTransition".equals(parameterName) ) {
          this.fBehTransition = (BehaviorTransition) newValue;
          return true;
      }
      if ("trace".equals(parameterName) ) {
          this.fTrace = (CPS2DeploymentTrace) newValue;
          return true;
      }
      return false;
    }
    
    public void setBehTransition(final BehaviorTransition pBehTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fBehTransition = pBehTransition;
    }
    
    public void setTrace(final CPS2DeploymentTrace pTrace) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrace = pTrace;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.transitionDel";
    }
    
    @Override
    public List<String> parameterNames() {
      return TransitionDel.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fBehTransition, fTrace};
    }
    
    @Override
    public TransitionDel.Match toImmutable() {
      return isMutable() ? newMatch(fBehTransition, fTrace) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"behTransition\"=" + prettyPrintValue(fBehTransition) + ", ");
      result.append("\"trace\"=" + prettyPrintValue(fTrace));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fBehTransition, fTrace);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TransitionDel.Match)) {
          TransitionDel.Match other = (TransitionDel.Match) obj;
          return Objects.equals(fBehTransition, other.fBehTransition) && Objects.equals(fTrace, other.fTrace);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }
    
    @Override
    public TransitionDel specification() {
      return TransitionDel.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TransitionDel.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pBehTransition the fixed value of pattern parameter behTransition, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TransitionDel.Match newMutableMatch(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
      return new Mutable(pBehTransition, pTrace);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBehTransition the fixed value of pattern parameter behTransition, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TransitionDel.Match newMatch(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
      return new Immutable(pBehTransition, pTrace);
    }
    
    private static final class Mutable extends TransitionDel.Match {
      Mutable(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
        super(pBehTransition, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends TransitionDel.Match {
      Immutable(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
        super(pBehTransition, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.transitionDel pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern transitionDel(behTransition : BehaviorTransition, trace : CPS2DeploymentTrace) {
   *     CPS2DeploymentTrace.deploymentElements(trace,behTransition);
   *     neg find cps2depTrace(_, trace, _, behTransition);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TransitionDel
   * 
   */
  public static class Matcher extends BaseMatcher<TransitionDel.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TransitionDel.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }
    
    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static TransitionDel.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_BEHTRANSITION = 0;
    
    private static final int POSITION_TRACE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TransitionDel.Matcher.class);
    
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }
    
    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pBehTransition the fixed value of pattern parameter behTransition, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TransitionDel.Match> getAllMatches(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pBehTransition, pTrace}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pBehTransition the fixed value of pattern parameter behTransition, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TransitionDel.Match> streamAllMatches(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pBehTransition, pTrace});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBehTransition the fixed value of pattern parameter behTransition, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TransitionDel.Match> getOneArbitraryMatch(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
      return rawGetOneArbitraryMatch(new Object[]{pBehTransition, pTrace});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pBehTransition the fixed value of pattern parameter behTransition, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
      return rawHasMatch(new Object[]{pBehTransition, pTrace});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pBehTransition the fixed value of pattern parameter behTransition, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
      return rawCountMatches(new Object[]{pBehTransition, pTrace});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBehTransition the fixed value of pattern parameter behTransition, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace, final Consumer<? super TransitionDel.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pBehTransition, pTrace}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBehTransition the fixed value of pattern parameter behTransition, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TransitionDel.Match newMatch(final BehaviorTransition pBehTransition, final CPS2DeploymentTrace pTrace) {
      return TransitionDel.Match.newMatch(pBehTransition, pTrace);
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTransition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<BehaviorTransition> rawStreamAllValuesOfbehTransition(final Object[] parameters) {
      return rawStreamAllValues(POSITION_BEHTRANSITION, parameters).map(BehaviorTransition.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTransition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTransition() {
      return rawStreamAllValuesOfbehTransition(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTransition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorTransition> streamAllValuesOfbehTransition() {
      return rawStreamAllValuesOfbehTransition(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTransition.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorTransition> streamAllValuesOfbehTransition(final TransitionDel.Match partialMatch) {
      return rawStreamAllValuesOfbehTransition(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTransition.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorTransition> streamAllValuesOfbehTransition(final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfbehTransition(new Object[]{null, pTrace});
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTransition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTransition(final TransitionDel.Match partialMatch) {
      return rawStreamAllValuesOfbehTransition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTransition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTransition(final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfbehTransition(new Object[]{null, pTrace}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<CPS2DeploymentTrace> rawStreamAllValuesOftrace(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRACE, parameters).map(CPS2DeploymentTrace.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace() {
      return rawStreamAllValuesOftrace(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace() {
      return rawStreamAllValuesOftrace(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final TransitionDel.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final BehaviorTransition pBehTransition) {
      return rawStreamAllValuesOftrace(new Object[]{pBehTransition, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final TransitionDel.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final BehaviorTransition pBehTransition) {
      return rawStreamAllValuesOftrace(new Object[]{pBehTransition, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected TransitionDel.Match tupleToMatch(final Tuple t) {
      try {
          return TransitionDel.Match.newMatch((BehaviorTransition) t.get(POSITION_BEHTRANSITION), (CPS2DeploymentTrace) t.get(POSITION_TRACE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TransitionDel.Match arrayToMatch(final Object[] match) {
      try {
          return TransitionDel.Match.newMatch((BehaviorTransition) match[POSITION_BEHTRANSITION], (CPS2DeploymentTrace) match[POSITION_TRACE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TransitionDel.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TransitionDel.Match.newMutableMatch((BehaviorTransition) match[POSITION_BEHTRANSITION], (CPS2DeploymentTrace) match[POSITION_TRACE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<TransitionDel.Matcher> querySpecification() {
      return TransitionDel.instance();
    }
  }
  
  private TransitionDel() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TransitionDel instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected TransitionDel.Matcher instantiate(final ViatraQueryEngine engine) {
    return TransitionDel.Matcher.on(engine);
  }
  
  @Override
  public TransitionDel.Matcher instantiate() {
    return TransitionDel.Matcher.create();
  }
  
  @Override
  public TransitionDel.Match newEmptyMatch() {
    return TransitionDel.Match.newEmptyMatch();
  }
  
  @Override
  public TransitionDel.Match newMatch(final Object... parameters) {
    return TransitionDel.Match.newMatch((org.eclipse.viatra.examples.cps.deployment.BehaviorTransition) parameters[0], (org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TransitionDel (visibility: PUBLIC, simpleName: TransitionDel, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TransitionDel, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TransitionDel (visibility: PUBLIC, simpleName: TransitionDel, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TransitionDel, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TransitionDel INSTANCE = new TransitionDel();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final TransitionDel.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_behTransition = new PParameter("behTransition", "org.eclipse.viatra.examples.cps.deployment.BehaviorTransition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_trace = new PParameter("trace", "org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_behTransition, parameter_trace);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.transitionDel";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("behTransition","trace");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_behTransition = body.getOrCreateVariableByName("behTransition");
          PVariable var_trace = body.getOrCreateVariableByName("trace");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_behTransition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_behTransition, parameter_behTransition),
             new ExportedParameter(body, var_trace, parameter_trace)
          ));
          //     CPS2DeploymentTrace.deploymentElements(trace,behTransition)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace", "deploymentElements")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentElement")));
          new Equality(body, var__virtual_0_, var_behTransition);
          //     neg find cps2depTrace(_, trace, _, behTransition)
          new NegativePatternCall(body, Tuples.flatTupleOf(var___0_, var_trace, var___1_, var_behTransition), Cps2depTrace.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
