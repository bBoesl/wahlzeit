package org.wahlzeit.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.utils.StringUtilTest;
import org.wahlzeit.utils.VersionTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	EmailAddressTest.class,
	LogBuilderTest.class,
	org.wahlzeit.services.mailing.MailingSuite.class
})
public class ServicesSuite {


}
