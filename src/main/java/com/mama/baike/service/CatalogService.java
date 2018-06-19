package com.mama.baike.service;

import com.mama.baike.entity.catalog.CatalogEntity;
import com.mama.baike.entity.catalog.CatalogQuery;

import java.util.List;

public interface CatalogService {
    /**
     * 查询目录
     * @param catalogQuery
     * @return
     */
    public List<CatalogEntity> findCatalog(CatalogQuery catalogQuery);
}
