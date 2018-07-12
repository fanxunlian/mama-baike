package com.mama.baike.service.impl;

import com.mama.baike.dao.system.DictionaryDao;
import com.mama.baike.entity.system.DictionaryEntity;
import com.mama.baike.entity.system.DictionaryQuery;
import com.mama.baike.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictionaryService")
public class DictionaryServiceImp implements DictionaryService {
    @Autowired
    private DictionaryDao dictionaryDao;

    /**
     * 查询数据字典
     */

    public DictionaryEntity findDictionary(DictionaryQuery dictionaryQuery)
    {
        return dictionaryDao.queryObject(dictionaryQuery.getId());
    }

    /**
     * 查询数据字典 列表
     */
    public List<DictionaryEntity> findDictionaryList(DictionaryQuery dictionaryQuery)
    {
        return dictionaryDao.queryList(dictionaryQuery);
    }
    /**
     * 根据code查询数据字典
     */
    public String findDictionaryByCode(String code)
    {
        DictionaryEntity dictionaryEntity =  dictionaryDao.queryByCode(code);
        return dictionaryEntity.getValue();
    }

}
