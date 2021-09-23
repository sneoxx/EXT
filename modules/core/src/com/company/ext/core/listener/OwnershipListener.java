///*
// * Copyright (c) ${YEAR} ${PACKAGE_NAME}
// */
//
//package com.company.ext.core.listener;
//
//import com.company.ext.entity.Ownership;
//import com.haulmont.cuba.core.Persistence;
//import com.haulmont.cuba.core.app.UniqueNumbersService;
//import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
//import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//
//import javax.inject.Inject;
//import java.util.Arrays;
//import java.util.Set;
//
//public class OwnershipListener implements BeforeInsertEntityListener<Ownership> {
//
//    private static final Logger log = org.slf4j.LoggerFactory.getLogger(OwnershipListener.class);
//
//
//    @Inject
//    UniqueNumbersService uniqueNumbersService;
//
////    @Override
////    public void onBeforeUpdate(Ownership entity) {
////entity.setCode();
////    }
//
////    @Override
////    public void onBeforeInsert(Ownership entity) {
////        String uniqueNumber =  String.valueOf(uniqueNumbersService.getNextNumber("CreditTypeCode"));
////        entity.setCode(uniqueNumber);
////        log.info("Для нового Ownership: {} сгенерирован номер: {}",entity, uniqueNumber);
////    }
//
// }
