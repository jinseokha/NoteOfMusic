package com.devseok.data.mapper

import com.devseok.data.model.setting.DataInquiry
import com.devseok.domain.model.setting.DomainInquiry

/**
 * @author Ha Jin Seok
 * @created 2023-08-28
 * @desc
 */

// Domain -> Data
fun mapperToDataInquiry(inquiry: DomainInquiry): DataInquiry {
    return DataInquiry(
        id = inquiry.id,
        content = inquiry.content,
        time = inquiry.time
    )
}