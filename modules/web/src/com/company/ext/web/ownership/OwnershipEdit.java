/*
 * Copyright (c) ${YEAR} ${PACKAGE_NAME}
 */

package com.company.ext.web.ownership;

import com.company.ext.entity.Ownership;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.gui.WindowParams;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.data.DsContext;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;


public class OwnershipEdit extends AbstractEditor<Ownership> {

    @Named("fieldGroup")
    protected FieldGroup fieldGroup;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(OwnershipEdit.class);

    @Inject
    UniqueNumbersService uniqueNumbersService;

    @Override
    public void init(Map<String, Object> params){
        super.init(params);
        fieldGroup.setVisible("code", false);
        fieldGroup.setEditable("code", false);
    }

    @Override
    protected void initNewItem(final Ownership item) {
        getDsContext().addListener(new DsContext.CommitListenerAdapter() {
            @Override
            public void beforeCommit(CommitContext context) {
                String uniqueNumber = String.valueOf(( uniqueNumbersService.getNextNumber("CreditTypeCode")));
                item.setCode(uniqueNumber);
                context.getCommitInstances().add(item);
                log.info("Номер для Ownership успешно сгенерирован и установлен {} :", uniqueNumber);
            }
        });
    }

//    public void init(Map<String, Object> params) {
//        getDsContext().addListener(new DsContext.CommitListenerAdapter() {
//            @Override
//            public void beforeCommit(CommitContext context) {
//                if (customer != null)
//                    context.getCommitInstances().add(customer);
//            }
//        });
//    }


//    @PostConstruct
//    @Override
//    public void init(Map<String, Object> params){
//        super.init(params);
//        String uniqueNumber = String.valueOf(( uniqueNumbersService.getNextNumber("CreditTypeCode")));
//        Ownership item = WindowParams.ITEM.getEntity(params);
//        item.setCode(uniqueNumber);
//        log.info("Номер для Ownership успешно сгенерирован и установлен {} :", uniqueNumber);
//        fieldGroup.setEditable("code", false);
//    }

//    @Override
//    protected void initNewItem(Ownership item) {
//        super.initNewItem(item);
//        String uniqueNumber = String.valueOf(( uniqueNumbersService.getNextNumber("CreditTypeCode")));
//        item.setCode(uniqueNumber);
//        log.info("Номер для COwnership успешно сгенерирован и установлен {} :", uniqueNumber);
//    }

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
