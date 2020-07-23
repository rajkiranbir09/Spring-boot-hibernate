package com.project.hibernate.abstracts;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;




public abstract class APIAbstract {

//    private static final Logger logger = LoggerFactory.getLogger(APIAbstract.class);
//
//    protected APIAbstract() {
//        //	logger.info("APIAbstract construction method load.");
//    }
//
//    protected HttpStatus generateHttpStatus(final ResponseModel response) {
//        HttpStatus status = null;
//        if (!response.isSuccess()) {
//            status = HttpStatus.BAD_REQUEST;
//        } else {
//            status = HttpStatus.OK;
//        }
//        return status;
//    }
//
//    protected List<SortModel> popularSortModelList(final String[] inputs) {
//        List<SortModel> sortModelList = new ArrayList<SortModel>();
//        try {
//            if ((inputs != null) && (inputs.length > 0)) {
//                SortModel sortModel = null;
//                String filedName = null;
//                boolean isDescend = false;
//                for (String input : inputs) {
//                    try {
//                        if (DataFormat.isStringValid(input)) {
//
//                            isDescend = input.startsWith(
//                                    Configuration.SORT_DESCEND_PREFIX);
//                            if (isDescend) {
//                                filedName = input.substring(
//                                        Configuration.SORT_DESCEND_FIELD_INDEX);
//                            } else {
//                                filedName = input.substring(
//                                        Configuration.SORT_ASC_FIELD_INDEX);
//                            }
//
//                            sortModel = new SortModel();
//                            sortModel.setDescend(isDescend);
//                            sortModel.setField(filedName);
//                            sortModelList.add(sortModel);
//                        }
//                    } catch (Exception e) {
//                        logger.error(e.toString());
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            logger.error(e.toString());
//        }
//        return sortModelList;
//    }
//
//    protected PaginationModel popularPaginationModel(final Integer page, final Integer perPage) {
//        PaginationModel paginationModel = null;
//        try {
//            if (DataFormat.isIntegerPositive(page)
//                    && DataFormat.isIntegerPositive(perPage)) {
//                paginationModel = new PaginationModel();
//                paginationModel.setStartPage(page);
//                paginationModel.setPerPage(perPage);
//                paginationModel.setFirstResult((page-1)*perPage);
//                paginationModel.setMaxResult(perPage);
//            }
//        } catch (Exception e) {
//            logger.error(e.toString());
//        }
//        return paginationModel;
//    }
}