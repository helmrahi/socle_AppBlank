package main.java.fr.socle.web;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProcessXMLFilesRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from(
				"file:///{{files.in}}?antInclude={{files.pattern}}&move={{files.done}}")
				.log("Processing file ${file:onlyname}")
				.to("direct:processXML");

		from("direct:processXML").split().tokenizeXML("user").streaming()
				.setHeader("city").xpath("/user/ville/text()")
				.log("City: ${header.city}");

	}
}