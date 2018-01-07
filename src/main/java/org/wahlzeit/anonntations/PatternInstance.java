package org.wahlzeit.anonntations;

import java.lang.annotation.Repeatable;

/**
 * 
 * @author Benjamin
 * AnnontationType to document used DesignPatterns
 */
public @interface PatternInstance {
	String name();
	Class[] participants();
}
