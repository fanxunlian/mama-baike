package com.mama.baike.service;

import com.mama.baike.entity.system.DictionaryEntity;
import com.mama.baike.entity.system.DictionaryQuery;

import java.util.List;

public interface DictionaryService {
    /**
     * 查询数据字典
     */

    public DictionaryEntity findDictionary(DictionaryQuery dictionaryQuery);

    /**
     * 查询数据字典 列表
     */
    public List<DictionaryEntity> findDictionaryList(DictionaryQuery dictionaryQuery);

    /**
     * 根据code查询数据字典
     * @param code
     * @return
     */
    public String findDictionaryByCode(String code);
}
