/*
 * Copyright (c) ${YEAR} ${PACKAGE_NAME}
 */

package com.company.ext.web.ui.company;

import com.company.ext.entity.ExtCompany;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.thesis.web.ui.company.CompanyEditor;

import javax.inject.Named;

public class ExtCompanyEdit extends CompanyEditor {

    @Named("ownership")
    LookupPickerField lookupPickerField;

    @Override
    public boolean validateAll () {
        boolean b = super.validateAll();
        ExtCompany extCompanyEdited = (ExtCompany) getItem();
        if (b) {
            if (extCompanyEdited.getOwnership() == null ) {
                showOptionDialog(getMessage( "Внимание" ), getMessage( "В документе не заполнено поле Форма собственности. Желаете сохранить документ?" ),
                        MessageType.CONFIRMATION, new Action[]{
                                new DialogAction(DialogAction.Type.YES, true ) {
                                    @Override
                                    public void actionPerform (Component component) {
                                        close(WINDOW_COMMIT_AND_CLOSE);
                                    }
                                },
                                new DialogAction(DialogAction.Type.NO) {
                                    @Override
                                    public void actionPerform (Component component) {
                                    }
                                }
                        }
                );
                return false ;
            }
        }
        return b;
    }
}
