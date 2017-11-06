package org.wahlzeit.model.persistence;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.LogBuilderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AbstractAdapterTest.class,
	DatastoreAdapterTest.class
})
public class PersistenceSuite {


}
