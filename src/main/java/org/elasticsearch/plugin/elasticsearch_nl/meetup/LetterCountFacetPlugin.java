package org.elasticsearch.plugin.elasticsearch_nl.meetup;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.search.facet.FacetModule;

public class LetterCountFacetPlugin extends AbstractPlugin  {
	
	final static ESLogger logger = Loggers.getLogger(LetterCountFacetPlugin.class);

	public LetterCountFacetPlugin() {
		logger.info("LetterCountFacet plugin initialized");
    }

	public String name() {
		return "LetterCountFacetPlugin";
	}


	public String description() {
		return "example plugin ES meetup";
	}
	
	@Override
    public void processModule(Module module) {
		if (module instanceof FacetModule) {
			logger.debug("Registering the LetterCounterFacetProcessor");
	    	((FacetModule)module).addFacetProcessor(LetterCountFacetProcessor.class);
		}
    }

}
