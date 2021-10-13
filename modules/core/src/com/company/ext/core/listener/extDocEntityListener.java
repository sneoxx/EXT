/*
 * Copyright (c) ${YEAR} ${PACKAGE_NAME}
 */

package com.company.ext.core.listener;

import com.haulmont.thesis.core.entity.Doc;
import com.haulmont.thesis.core.listener.DocEntityListener;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

public class extDocEntityListener extends DocEntityListener {

    @Override
    protected String createDescription(Doc entity) {
        StringBuilder description = new StringBuilder();
        description.append(getDocKindName(entity));

        String number = getDescriptionNumber(entity);
        if (StringUtils.isNotBlank(number)) {
            description.append(" ");
            description.append(messages.getMessage(getClass(), "Doc.numberPrefix")).append(" Изменено ");
            description.append(StringUtils.trimToEmpty(number));
        }
        Date date = entity.getDate();
        if (entity.getRegistered()) {
            date = entity.getRegDate();
        }
        if (date != null) {
            description.append(" ").append(messages.getMessage(getClass(), "Doc.datePrefix"))
                    .append(" ").append(String.format("%1$td.%1$tm.%1$tY", date));
        }
        return description.toString();
    }
}
