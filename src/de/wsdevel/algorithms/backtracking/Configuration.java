package de.wsdevel.algorithms.backtracking;

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
public interface Configuration {

    /**
     * @return {@link Configuration}[] this Configuration extending
     *         Configurations.
     */
    Configuration[] getExtensions();

}
//
// $Log: Configuration.java,v $
// Revision 1.1  2009-02-09 13:07:17  sweiss
// *** empty log message ***
//
//
