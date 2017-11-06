import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersSuite;
import org.wahlzeit.model.ModelSuite;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.LogBuilderTest;
import org.wahlzeit.services.ServicesSuite;
import org.wahlzeit.utils.UtilsSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	HandlersSuite.class,
	ModelSuite.class,
	ServicesSuite.class,
	UtilsSuite.class,
})
public class WahlzeitTestSuite {


}
