package org.jboss.test.xerces_time_issue;

import static org.junit.Assert.fail;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXParseException;

public class TimeMaxInclusiveTest {
	@Test
	public void testExtends() throws Exception {
		Source schemaFile = new StreamSource(this.getClass().getClassLoader().getResourceAsStream("time_max.xsd"));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		try {
			Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(schemaFile);
			fail("schema invalid exception is expected");
		} catch (SAXParseException e) {
			e.printStackTrace();
			/*Assert.assertTrue(
					"Unexpected exception",
					e.getMessage().contains(
							"not facet-valid with respect to maxInclusive"));*/
		}
	}

}
