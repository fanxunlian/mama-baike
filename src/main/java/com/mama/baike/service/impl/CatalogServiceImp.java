package com.mama.baike.service.impl;

import com.mama.baike.dao.catalog.CatalogDao;
import com.mama.baike.entity.catalog.CatalogEntity;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service("catalogService")
public class CatalogServiceImp implements CatalogService {

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
    /**
     * 递归出导航
     */
    public List<CatalogEntity> findNavList(CatalogQuery catalogQuery)
    {
        List<CatalogEntity>navList = new LinkedList<>();
        getNavList(navList,catalogQuery);
        Collections.reverse(navList);
        return navList;
    }

    /**
     * 递归找出导航地址
     * @param navList
     * @param catalogQuery
     * @return
     */
    private  List<CatalogEntity> getNavList(List<CatalogEntity>navList,CatalogQuery catalogQuery)
    {
        CatalogQuery parentCatalogQuery = new CatalogQuery();
        parentCatalogQuery.setId(catalogQuery.getId());
        List<CatalogEntity> catalogEntityList =  catalogDao.queryList(parentCatalogQuery);
        if(!catalogEntityList.isEmpty())
        {
            CatalogEntity catalogEntity = catalogEntityList.get(0);
            navList.add(catalogEntity);

            catalogQuery.setId(catalogEntity.getParentId());
            getNavList(navList,catalogQuery);
        }
        else
        {
            return navList;
        }
        return navList;
    }
}
