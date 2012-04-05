package de.wsdevel.algorithms.backtracking.nqueens;

import java.util.ArrayList;

import de.wsdevel.algorithms.backtracking.Configuration;

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
 * @version $Author: sweiss $ -- $Revision: 1.1 $ -- $Date: 2009-02-09 13:07:17 $
 */
public class CheckerBoardConfig implements Configuration {

    /**
     * {@link Configuration[]} COMMENT.
     */
    private static final Configuration[] EMPTY_EXTENSIONS = new Configuration[] {};

    /**
     * {@link boolean[][]} COMMENT.
     */
    private boolean[][] board;

    /**
     * @return <code>boolean[][]</code>
     */
    public boolean[][] getBoard() {
	return this.board;
    }

    private int currentRow = 0;

    /**
     * @return <code>int</code>
     */
    public int getCurrentRow() {
	return this.currentRow;
    }

    /**
     * @param currentRowVal
     *            <code>int</code>
     */
    public void setCurrentRow(int currentRowVal) {
	this.currentRow = currentRowVal;
    }

    /**
     * COMMENT.
     * 
     * @param currentRowVal
     *            <code>int</code>
     */
    public CheckerBoardConfig(final int currentRowVal, final int rowCount,
	    final int columnCount) {
	setCurrentRow(currentRowVal);
	this.board = new boolean[rowCount][columnCount];
    }

    /**
     * @return {@link Configuration}
     * @see de.wsdevel.algorithms.backtracking.Configuration#getExtensions()
     */
    @Override
    public final Configuration[] getExtensions() {
	if (getCurrentRow() >= getBoard().length) {
	    return EMPTY_EXTENSIONS;
	}
	ArrayList<Configuration> extensions = new ArrayList<Configuration>();
	for (int i = 0; i < getBoard()[0].length; i++) {
	    if (isOkInNextRow(i)) {
		extensions.add(createExtension(i));
	    }
	}
	return extensions.toArray(new Configuration[extensions.size()]);
    }

    private boolean isOkInNextRow(final int i) {
	if (getCurrentRow() == 0 && !isQueenInRow(0)) {
	    // i'm root, everything is ok in next row!
	    return true;
	}
	for (int row = 0; row <= getCurrentRow(); row++) {
	    for (int column = 0; column < this.board[row].length; column++) {
		if (getBoard()[row][column]) {
		    if (column == i) {
			// same column
			return false;
		    }
		    int deltaRow = getCurrentRow() + 1 - row;
		    if (column + deltaRow == i || column - deltaRow == i) {
			// same diagonal
			return false;
		    }
		}
	    }
	}
	return true;
    }

    /**
     * COMMENT.
     * 
     * @param row
     *            <code>int</code>
     * @return <code>boolean</code>
     */
    public boolean isQueenInRow(int row) {
	boolean val = false;
	for (int i = 0; i < getBoard()[row].length; i++) {
	    val = val || getBoard()[row][i];
	}
	return val;
    }

    private CheckerBoardConfig createExtension(final int i) {
	int currentRowVal = getCurrentRow() + 1;
	if (getCurrentRow() == 0 && !isQueenInRow(0)) {
	    // ok, we're root and next extensions start at row 0 either...
	    currentRowVal = 0;
	}
	CheckerBoardConfig checkerBoardConfig = new CheckerBoardConfig(
		currentRowVal, getBoard().length,
		getBoard()[getBoard().length - 1].length);
	copyRowsTo(checkerBoardConfig);
	checkerBoardConfig.getBoard()[checkerBoardConfig.getCurrentRow()][i] = true;
	return checkerBoardConfig;
    }

    private void copyRowsTo(final CheckerBoardConfig checkerBoardConfig) {
	for (int row = 0; row <= getCurrentRow(); row++) {
	    for (int column = 0; column < this.board[row].length; column++) {
		checkerBoardConfig.getBoard()[row][column] = getBoard()[row][column];
	    }
	}
    }

    /**
     * COMMENT.
     */
    public void printBoard() {
	for (int row = 0; row < this.board.length; row++) {
	    printLine(row);
	    for (int column = 0; column < this.board[row].length; column++) {
		System.out.print(" | " + (this.board[row][column] ? "x" : " "));
		if (column == this.board[row].length - 1) {
		    System.out.print(" |");
		}
	    }
	    System.out.println();
	    if (row == this.board.length - 1) {
		printLine(row);
	    }
	}
	System.out.println();
    }

    private void printLine(int row) {
	System.out.print(" ");
	for (int column = 0; column < this.board[row].length; column++) {
	    System.out.print("----");
	}
	System.out.println("-");
    }

}
//
// $Log: CheckerBoardConfig.java,v $
// Revision 1.1  2009-02-09 13:07:17  sweiss
// *** empty log message ***
//
//
