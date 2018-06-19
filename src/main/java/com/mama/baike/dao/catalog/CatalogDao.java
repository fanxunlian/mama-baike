package com.mama.baike.dao.catalog;

import com.mama.baike.dao.base.BaseDao;
import com.mama.baike.entity.catalog.CatalogEntity;
import com.mama.baike.entity.catalog.CatalogQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CatalogDao extends BaseDao<CatalogEntity,CatalogQuery>{

}
