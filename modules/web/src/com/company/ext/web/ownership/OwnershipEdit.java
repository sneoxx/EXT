/*
 * Copyright (c) ${YEAR} ${PACKAGE_NAME}
 */

package com.company.ext.web.ownership;

import com.company.ext.entity.Ownership;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Field;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.thesis.core.entity.Employee;
import com.haulmont.thesis.core.entity.Organization;
import com.haulmont.thesis.core.entity.TsUser;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.Set;

public class OwnershipEdit  extends AbstractEditor<Ownership> {

    @Named("fieldGroup")
    protected FieldGroup fieldGroup;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(OwnershipEdit.class);

    @Inject
    UniqueNumbersService uniqueNumbersService;

    @Override
    public void init(Map<String, Object> params){
        super.init(params);
//        fieldGroup.setVisible("code", false);
        fieldGroup.setEditable("code", false);
    }

    @Override
    protected void initNewItem(Ownership item) {
        super.initNewItem(item);
        String uniqueNumber = String.valueOf(( uniqueNumbersService.getNextNumber("CreditTypeCode")));
        item.setCode(uniqueNumber);
        log.info("Номер для CreditType успешно сгенерирован и установлен {} :", uniqueNumber);
    }



//    @Override
//    public void onBeforeInsert(OwnershipEdit) {
//
//        codeFields.setVisible(false);
//    EntityManager em = persistence.getEntityManager();
//    Set<String> fields = persistence.getTools().getDirtyFields(employee);
//    Organization organization = null;
//        if (fields.contains("department")) {
//        organization = employee.getDepartment() == null ? null : employee.getDepartment().getOrganization();
//        employee.setOrganization(organization);
//    }
//    User user = employee.getUser();
//        if (user == null) {
//        return;
//    }
//        if (user instanceof TsUser && fields.contains("department") && organization != null) {
//        user = em.reload(TsUser.class, user.getId(), "w-organization");
//        if (user == null) return;
//        ((TsUser) user).setOrganization(organization);
//    }
}
