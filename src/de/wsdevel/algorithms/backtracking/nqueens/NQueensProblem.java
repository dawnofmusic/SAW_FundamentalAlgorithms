package de.wsdevel.algorithms.backtracking.nqueens;

import java.util.Collection;

import de.wsdevel.algorithms.backtracking.Backtracker;
import de.wsdevel.algorithms.backtracking.Configuration;
import de.wsdevel.algorithms.backtracking.Solver;

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
 * @version $Author: sweiss $ -- $Revision: 1.3 $ -- $Date: 2009-02-10 09:53:06 $
 */
public class NQueensProblem {

    /**
     * COMMENT.
     * 
     * @param args
     */
    public static void main(String[] args) {

	Collection<CheckerBoardConfig> simpleBacktrack = Backtracker.simpleBacktrack(
		new CheckerBoardConfig(0, 12, 12),
		new Solver<CheckerBoardConfig>() {

		    @Override
		    public Double getRate(CheckerBoardConfig solution) {
			return null;
		    }

		    @Override
		    public boolean isSolution(CheckerBoardConfig configuration) {
			return configuration.isQueenInRow(configuration
				.getBoard().length - 1);
		    }

		});

	System.out.println("=========== SOLUTIONS ===========");// TODO remove
	// sysout
	for (Configuration configuration : simpleBacktrack) {
	    ((CheckerBoardConfig) configuration).printBoard();
	}

    }
}
//
// $Log: NQueensProblem.java,v $
// Revision 1.3  2009-02-10 09:53:06  sweiss
// bug fixing and cleanup
//
// Revision 1.2  2009-02-09 13:47:24  sweiss
// *** empty log message ***
//
// Revision 1.1  2009-02-09 13:07:17  sweiss
// *** empty log message ***
//
//
