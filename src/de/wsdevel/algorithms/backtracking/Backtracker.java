package de.wsdevel.algorithms.backtracking;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import de.wsdevel.tools.collection.SingleElementCollection;

/**
 * Created on 06.02.2009.
 * 
 * for project: Java__Algorithms
 * 
 * <br>
 * (c) 2009, Sebastian A. Weiß - All rights reserved.
 * 
 * @author <a href="mailto:post@sebastian-weiss.de">Sebastian A. Weiss</a> <a
 *         href
 *         ="http://www.sebastian-weiss.de">http://www.sebastian-weiss.de</a>
 * @version $Author: sweiss $ -- $Revision: 1.2 $ -- $Date: 2009-02-09 13:07:17
 *          $
 */
public class Backtracker {

    /**
     * @param rootConfiguration
     *            {@link Configuration}
     * @param solver
     *            {@link Solver}
     * @return {@link List}< {@link Configuration}> the solution space.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Configuration> T firstSolutionBacktrack(
	    final T rootConfiguration, final Solver<T> solver) {
	if (solver.isSolution(rootConfiguration)) {
	    return rootConfiguration;
	}
	T firstSolutionBacktrack = null;
	Configuration[] extensions = rootConfiguration.getExtensions();
	for (Configuration configuration : extensions) {
	    firstSolutionBacktrack = firstSolutionBacktrack((T) configuration,
		    solver);
	    if (firstSolutionBacktrack != null) {
		return firstSolutionBacktrack;
	    }
	}
	return null;
    }

    public static final void main(String[] args) {

    }

    /**
     * @param rootConfiguration
     *            {@link Configuration}
     * @param solver
     *            {@link Solver}
     * @return {@link List}< {@link Configuration}> the solution space.
     */
    public static <T extends Configuration> Collection<T> maxDepthBacktrack(
	    final T rootConfiguration, final Solver<T> solver,
	    final int maxDepth) {
	return maxDepthBacktrack(rootConfiguration, solver, maxDepth, 0);
    }

    /**
     * COMMENT.
     * 
     * @param rootConfiguration
     *            {@link Configuration}
     * @param solver
     *            {@link Solver}
     * @param maxDepth
     *            <code>int</code>
     * @param currentdepth
     *            <code>int</code>
     * @return {@link List}< {@link Configuration}> the solution space.
     */
    @SuppressWarnings("unchecked")
    private static <T extends Configuration> Collection<T> maxDepthBacktrack(
	    final T rootConfiguration, final Solver<T> solver,
	    final int maxDepth, final int currentdepth) {
	if (solver.isSolution(rootConfiguration)) {
	    return new SingleElementCollection<T>(rootConfiguration);
	}
	if (maxDepth < currentdepth + 1) {
	    return null;
	}
	List<T> solutions = new LinkedList<T>();
	Configuration[] extensions = rootConfiguration.getExtensions();
	for (Configuration configuration : extensions) {
	    Collection<T> maxDepthBacktrack = maxDepthBacktrack(
		    (T) configuration, solver, maxDepth, currentdepth + 1);
	    if (maxDepthBacktrack != null) {
		solutions.addAll(maxDepthBacktrack);
	    }
	}
	return solutions;
    }

    /**
     * @param rootConfiguration
     *            {@link Configuration}
     * @param solver
     *            {@link Solver}
     * @return {@link SortedSet}< {@link Configuration}> the solution space
     *         sorted by rating given by solver
     * @see {@link Solver#getRate(Configuration)}
     */
    public static <T extends Configuration> SortedSet<T> ratedBacktrack(
	    final T rootConfiguration, final Solver<T> solver) {
	return ratedBacktrack(rootConfiguration, solver, new Comparator<T>() {
	    @Override
	    public int compare(T arg0, T arg1) {
		return solver.getRate(arg0).compareTo(solver.getRate(arg1));
	    }
	});
    }

    /**
     * @param rootConfiguration
     *            {@link Configuration}
     * @param solver
     *            {@link Solver}
     * @param comparator
     *            {@link Comparator}
     * @return {@link SortedSet}< {@link Configuration}> the solution space
     *         sorted by rating given by solver
     * @see {@link Solver#getRate(Configuration)}
     */
    @SuppressWarnings("unchecked")
    private static <T extends Configuration> SortedSet<T> ratedBacktrack(
	    final T rootConfiguration, final Solver<T> solver,
	    final Comparator<T> comparator) {
	if (solver.isSolution(rootConfiguration)) {
	    return new TreeSet<T>(new SingleElementCollection<T>(
		    rootConfiguration));
	}
	TreeSet<T> solutions = new TreeSet<T>(comparator);
	Configuration[] extensions = rootConfiguration.getExtensions();
	for (Configuration configuration : extensions) {
	    solutions.addAll(ratedBacktrack((T) configuration, solver));
	}
	return solutions;
    }

    /**
     * @param rootConfiguration
     *            {@link Configuration}
     * @param solver
     *            {@link Solver}
     * @return {@link List}< {@link Configuration}> the solution space.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Configuration> Collection<T> simpleBacktrack(
	    final T rootConfiguration, final Solver<T> solver) {
	if (solver.isSolution(rootConfiguration)) {
	    // ((CheckerBoardConfig) rootConfiguration).printBoard();
	    return new SingleElementCollection<T>(rootConfiguration);
	}
	Collection<T> solutions = new LinkedList<T>();
	Configuration[] extensions = rootConfiguration.getExtensions();
	for (Configuration configuration : extensions) {
	    solutions.addAll(simpleBacktrack((T) configuration, solver));
	}
	return solutions;
    }

}
//
// $Log: Backtracker.java,v $
// Revision 1.2  2009-02-10 09:53:06  sweiss
// bug fixing and cleanup
//
// Revision 1.1 2009-02-09 13:07:17 sweiss
// *** empty log message ***
//
//
