package com.ejemplo;

import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.model.User;

public class MiIndexerPostProcesor extends BaseIndexerPostProcessor {

	@Override
	public void postProcessDocument(Document document, Object obj)
			throws Exception {
		User userEntity = (User) obj;
        String indexerUserTitle = "";
        indexerUserTitle = userEntity.getJobTitle();

        if (indexerUserTitle.length() > 0)
            document.addText(Field.TITLE, indexerUserTitle);
	}
}
