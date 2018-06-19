package com.mama.baike.service.impl;

import com.mama.baike.dao.catalog.CatalogDao;
import com.mama.baike.entity.catalog.CatalogEntity;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogDao catalogDao;
    /**
     * 查询目录
     * @param catalogQuery
     * @return
     */
    public List<CatalogEntity> findCatalog(CatalogQuery catalogQuery)
    {
        return catalogDao.queryList(catalogQuery);
    }
}
