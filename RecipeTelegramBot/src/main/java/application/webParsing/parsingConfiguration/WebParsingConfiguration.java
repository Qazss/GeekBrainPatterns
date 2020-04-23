package application.webParsing.parsingConfiguration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class WebParsingConfiguration {
	private static final String CONFIG_FILE_PATH = "webResourceConfig.xml";
	private static final String ROOT_TAG = "webResource";

	private static final Logger log = LogManager.getLogger(WebParsingConfiguration.class);


	public static List<WebResource> getWebResources() {
		List<WebResource> webResources = new ArrayList<>();

		try {
			ClassLoader classLoader = WebParsingConfiguration.class.getClassLoader();
			File xmlFile = new File(classLoader.getResource(CONFIG_FILE_PATH).getFile());

			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(xmlFile);

			Element rootElement = document.getRootElement();
			List<Element> list = rootElement.getChildren(ROOT_TAG);

			for (Element element : list) {
				webResources.add(fillWebResource((Element) element));
			}
		} catch (Exception e) {
			log.error(String.format("Ошибка получения конфигураций из файла %s", CONFIG_FILE_PATH), e);
		}

		return webResources;
	}

	private static WebResource fillWebResource(Element node) {
		WebResource webResource = new WebResource();
		Element nestedNode = node.getChild("itemPage");

		if (nestedNode != null) {
			webResource.getItemPage().setTitleClass(nestedNode.getChildText("titleClass"));
			webResource.getItemPage().setDescriptionClass(nestedNode.getChildText("descriptionClass"));
			webResource.getItemPage().setPortionAmountClass(nestedNode.getChildText("portionClass"));
			webResource.getItemPage().setCookingTimeClass(nestedNode.getChildText("cookingTimeClass"));
			webResource.getItemPage().setIngredientsClass(nestedNode.getChildText("ingredientsClass"));
			webResource.getItemPage().setInstructionsClass(nestedNode.getChildText("instructionsClass"));
			webResource.getItemPage().setImageClass(nestedNode.getChildText("imageClass"));
			webResource.getItemPage().setAdviceClass(nestedNode.getChildText("adviceClass"));
		}

		webResource.setMainURL(node.getChildText("mainURL"));
		webResource.setRequestURL(node.getChildText("requestURL"));
		webResource.setItemClass(node.getChildText("itemClass"));

		return webResource;
	}
}
