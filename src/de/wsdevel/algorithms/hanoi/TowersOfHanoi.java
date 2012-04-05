package de.wsdevel.algorithms.hanoi;

import java.util.LinkedList;

/**
 * Created on 30.12.2007.
 * 
 * for project: Java__Stuff <br>
 * (c) 2007, Weiss und Schmidt, Mediale Systeme GbR - All rights reserved.
 * 
 * @author <a href="mailto:sweiss@weissundschmidt.de">Sebastian A. Weiss - Weiss
 *         und Schmidt, Mediale Systeme GbR</a>
 * @version $Author: sweiss $ -- $Revision: 1.1 $ -- $Date: 2009-02-09 13:07:17 $
 */
public final class TowersOfHanoi {

    /**
     * COMMENT.
     * 
     * @param args
     *            {@link String}[]
     */
    public static void main(final String[] args) {
	long millis = System.currentTimeMillis();
	new TowersOfHanoi(8).resort();
	System.out.println("CALCULATION TIME IN MILLIS: "
		+ (System.currentTimeMillis() - millis));
    }

    /**
     * {@link int} COMMENT.
     */
    private int iterationCount = 0;

    /**
     * {@link boolean} COMMENT.
     */
    private boolean printSingleSteps = false;

    /**
     * {@link List<Integer>} the stacks.
     */
    private LinkedList<Integer> source;

    /**
     * {@link LinkedList<Integer>} COMMENT.
     */
    private LinkedList<Integer> stack;

    /**
     * {@link LinkedList<Integer>} COMMENT.
     */
    private LinkedList<Integer> target;

    /**
     * COMMENT.
     * 
     * @param sizeVal
     *            <code>int</code>
     */
    public TowersOfHanoi(final int sizeVal) {
	this.source = new LinkedList<Integer>();
	this.stack = new LinkedList<Integer>();
	this.target = new LinkedList<Integer>();
	for (int i = sizeVal; i > 0; i--) {
	    this.source.add(i);
	}
	if (sizeVal < 9) {
	    this.printSingleSteps = true;
	} else {
	    this.printSingleSteps = false;
	}
    }

    /**
     * COMMENT.
     * 
     * @param steps
     * @param sourceRef
     * @param targetRef
     * @param stackRef
     */
    private void move(int steps, LinkedList<Integer> sourceRef,
	    LinkedList<Integer> targetRef, LinkedList<Integer> stackRef) {
	if (steps < 1) {
	    return;
	} else if (steps == 1) {
	    moveFromSourceToTarget(sourceRef, targetRef);
	} else {
	    move(steps - 1, sourceRef, stackRef, targetRef);
	    moveFromSourceToTarget(sourceRef, targetRef);
	    move(steps - 1, stackRef, targetRef, sourceRef);
	}
    }

    /**
     * COMMENT.
     * 
     * @param sourceRef
     * @param targetRef
     */
    private void moveFromSourceToTarget(final LinkedList<Integer> sourceRef,
	    final LinkedList<Integer> targetRef) {
	targetRef.add(sourceRef.removeLast());
	this.iterationCount++;
	if (this.printSingleSteps) {
	    printState();
	}
    }

    /**
     * COMMENT.
     */
    private void printState() {
	System.out.println("ITERATION #" + this.iterationCount);
	System.out.println("SOURCE: " + this.source);
	System.out.println("STACK: " + this.stack);
	System.out.println("TARGET: " + this.target);
    }

    /**
     * COMMENT.
     */
    public final void resort() {
	this.iterationCount = 0;
	printState();
	move(this.source.size(), this.source, this.target, this.stack);
	if (!this.printSingleSteps) {
	    printState();
	}
    }

}
//
// $Log: TowersOfHanoi.java,v $
// Revision 1.1  2009-02-09 13:07:17  sweiss
// *** empty log message ***
//
// Revision 1.1 2008-01-08 16:14:40 sweiss
// *** empty log message ***
//
//
