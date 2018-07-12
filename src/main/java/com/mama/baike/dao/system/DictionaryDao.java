package com.mama.baike.dao.system;

import com.mama.baike.entity.system.DictionaryEntity;
import com.mama.baike.entity.system.DictionaryQuery;
import com.mama.baike.dao.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictionaryDao extends BaseDao<DictionaryEntity,DictionaryQuery> {
    /**
     * 根据code查询数据字典
     */
    public DictionaryEntity queryByCode(String code);
}
